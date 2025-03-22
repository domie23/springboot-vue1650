






















package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 骑手
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qishou")
public class QishouController {
    private static final Logger logger = LoggerFactory.getLogger(QishouController.class);

    @Autowired
    private QishouService qishouService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("骑手".equals(role))
            params.put("qishouId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        params.put("qishouDeleteStart",1);params.put("qishouDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = qishouService.queryPage(params);

        //字典表数据转换
        List<QishouView> list =(List<QishouView>)page.getList();
        for(QishouView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QishouEntity qishou = qishouService.selectById(id);
        if(qishou !=null){
            //entity转view
            QishouView view = new QishouView();
            BeanUtils.copyProperties( qishou , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody QishouEntity qishou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qishou:{}",this.getClass().getName(),qishou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<QishouEntity> queryWrapper = new EntityWrapper<QishouEntity>()
            .eq("username", qishou.getUsername())
            .or()
            .eq("qishou_phone", qishou.getQishouPhone())
            .or()
            .eq("qishou_id_number", qishou.getQishouIdNumber())
            .andNew()
            .eq("qishou_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QishouEntity qishouEntity = qishouService.selectOne(queryWrapper);
        if(qishouEntity==null){
            qishou.setQishouDelete(1);
            qishou.setCreateTime(new Date());
            qishou.setPassword("123456");
            qishouService.insert(qishou);
            return R.ok();
        }else {
            return R.error(511,"账户或者骑手手机号或者骑手身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QishouEntity qishou, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,qishou:{}",this.getClass().getName(),qishou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<QishouEntity> queryWrapper = new EntityWrapper<QishouEntity>()
            .notIn("id",qishou.getId())
            .andNew()
            .eq("username", qishou.getUsername())
            .or()
            .eq("qishou_phone", qishou.getQishouPhone())
            .or()
            .eq("qishou_id_number", qishou.getQishouIdNumber())
            .andNew()
            .eq("qishou_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QishouEntity qishouEntity = qishouService.selectOne(queryWrapper);
        if("".equals(qishou.getQishouPhoto()) || "null".equals(qishou.getQishouPhoto())){
                qishou.setQishouPhoto(null);
        }
        if(qishouEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      qishou.set
            //  }
            qishouService.updateById(qishou);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者骑手手机号或者骑手身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<QishouEntity> list = new ArrayList<>();
        for(Integer id:ids){
            QishouEntity qishouEntity = new QishouEntity();
            qishouEntity.setId(id);
            qishouEntity.setQishouDelete(2);
            list.add(qishouEntity);
        }
        if(list != null && list.size() >0){
            qishouService.updateBatchById(list);
        }
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<QishouEntity> qishouList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            QishouEntity qishouEntity = new QishouEntity();
//                            qishouEntity.setUsername(data.get(0));                    //账户 要改的
//                            //qishouEntity.setPassword("123456");//密码
//                            qishouEntity.setQishouName(data.get(0));                    //骑手姓名 要改的
//                            qishouEntity.setQishouPhoto("");//照片
//                            qishouEntity.setQishouPhone(data.get(0));                    //骑手手机号 要改的
//                            qishouEntity.setQishouIdNumber(data.get(0));                    //骑手身份证号 要改的
//                            qishouEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            qishouEntity.setQishouDelete(1);//逻辑删除字段
//                            qishouEntity.setCreateTime(date);//时间
                            qishouList.add(qishouEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //骑手手机号
                                if(seachFields.containsKey("qishouPhone")){
                                    List<String> qishouPhone = seachFields.get("qishouPhone");
                                    qishouPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> qishouPhone = new ArrayList<>();
                                    qishouPhone.add(data.get(0));//要改的
                                    seachFields.put("qishouPhone",qishouPhone);
                                }
                                //骑手身份证号
                                if(seachFields.containsKey("qishouIdNumber")){
                                    List<String> qishouIdNumber = seachFields.get("qishouIdNumber");
                                    qishouIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qishouIdNumber = new ArrayList<>();
                                    qishouIdNumber.add(data.get(0));//要改的
                                    seachFields.put("qishouIdNumber",qishouIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<QishouEntity> qishouEntities_username = qishouService.selectList(new EntityWrapper<QishouEntity>().in("username", seachFields.get("username")).eq("qishou_delete", 1));
                        if(qishouEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QishouEntity s:qishouEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //骑手手机号
                        List<QishouEntity> qishouEntities_qishouPhone = qishouService.selectList(new EntityWrapper<QishouEntity>().in("qishou_phone", seachFields.get("qishouPhone")).eq("qishou_delete", 1));
                        if(qishouEntities_qishouPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QishouEntity s:qishouEntities_qishouPhone){
                                repeatFields.add(s.getQishouPhone());
                            }
                            return R.error(511,"数据库的该表中的 [骑手手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //骑手身份证号
                        List<QishouEntity> qishouEntities_qishouIdNumber = qishouService.selectList(new EntityWrapper<QishouEntity>().in("qishou_id_number", seachFields.get("qishouIdNumber")).eq("qishou_delete", 1));
                        if(qishouEntities_qishouIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QishouEntity s:qishouEntities_qishouIdNumber){
                                repeatFields.add(s.getQishouIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [骑手身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qishouService.insertBatch(qishouList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        QishouEntity qishou = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("username", username));
        if(qishou==null || !qishou.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(qishou.getQishouDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(qishou.getId(),username, "qishou", "骑手");
        R r = R.ok();
        r.put("token", token);
        r.put("role","骑手");
        r.put("username",qishou.getQishouName());
        r.put("tableName","qishou");
        r.put("userId",qishou.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody QishouEntity qishou){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<QishouEntity> queryWrapper = new EntityWrapper<QishouEntity>()
            .eq("username", qishou.getUsername())
            .or()
            .eq("qishou_phone", qishou.getQishouPhone())
            .or()
            .eq("qishou_id_number", qishou.getQishouIdNumber())
            .andNew()
            .eq("qishou_delete", 1)
            ;
        QishouEntity qishouEntity = qishouService.selectOne(queryWrapper);
        if(qishouEntity != null)
            return R.error("账户或者骑手手机号或者骑手身份证号已经被使用");
        qishou.setQishouDelete(1);
        qishou.setCreateTime(new Date());
        qishouService.insert(qishou);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        QishouEntity qishou = new QishouEntity();
        qishou.setPassword("123456");
        qishou.setId(id);
        qishouService.updateById(qishou);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        QishouEntity qishou = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("username", username));
        if(qishou!=null){
            qishou.setPassword("123456");
            boolean b = qishouService.updateById(qishou);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrQishou(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        QishouEntity qishou = qishouService.selectById(id);
        if(qishou !=null){
            //entity转view
            QishouView view = new QishouView();
            BeanUtils.copyProperties( qishou , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = qishouService.queryPage(params);

        //字典表数据转换
        List<QishouView> list =(List<QishouView>)page.getList();
        for(QishouView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QishouEntity qishou = qishouService.selectById(id);
            if(qishou !=null){


                //entity转view
                QishouView view = new QishouView();
                BeanUtils.copyProperties( qishou , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody QishouEntity qishou, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qishou:{}",this.getClass().getName(),qishou.toString());
        Wrapper<QishouEntity> queryWrapper = new EntityWrapper<QishouEntity>()
            .eq("username", qishou.getUsername())
            .or()
            .eq("qishou_phone", qishou.getQishouPhone())
            .or()
            .eq("qishou_id_number", qishou.getQishouIdNumber())
            .andNew()
            .eq("qishou_delete", 1)
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QishouEntity qishouEntity = qishouService.selectOne(queryWrapper);
        if(qishouEntity==null){
            qishou.setQishouDelete(1);
            qishou.setCreateTime(new Date());
        qishou.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      qishou.set
        //  }
        qishouService.insert(qishou);
            return R.ok();
        }else {
            return R.error(511,"账户或者骑手手机号或者骑手身份证号已经被使用");
        }
    }


}
