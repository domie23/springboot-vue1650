package com.entity.model;

import com.entity.QishouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 骑手
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QishouModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 骑手姓名
     */
    private String qishouName;


    /**
     * 头像
     */
    private String qishouPhoto;


    /**
     * 骑手手机号
     */
    private String qishouPhone;


    /**
     * 骑手身份证号
     */
    private String qishouIdNumber;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 假删
     */
    private Integer qishouDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：骑手姓名
	 */
    public String getQishouName() {
        return qishouName;
    }


    /**
	 * 设置：骑手姓名
	 */
    public void setQishouName(String qishouName) {
        this.qishouName = qishouName;
    }
    /**
	 * 获取：头像
	 */
    public String getQishouPhoto() {
        return qishouPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setQishouPhoto(String qishouPhoto) {
        this.qishouPhoto = qishouPhoto;
    }
    /**
	 * 获取：骑手手机号
	 */
    public String getQishouPhone() {
        return qishouPhone;
    }


    /**
	 * 设置：骑手手机号
	 */
    public void setQishouPhone(String qishouPhone) {
        this.qishouPhone = qishouPhone;
    }
    /**
	 * 获取：骑手身份证号
	 */
    public String getQishouIdNumber() {
        return qishouIdNumber;
    }


    /**
	 * 设置：骑手身份证号
	 */
    public void setQishouIdNumber(String qishouIdNumber) {
        this.qishouIdNumber = qishouIdNumber;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：假删
	 */
    public Integer getQishouDelete() {
        return qishouDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setQishouDelete(Integer qishouDelete) {
        this.qishouDelete = qishouDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
