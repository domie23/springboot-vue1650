package com.entity.model;

import com.entity.QishouJiedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 骑手接单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QishouJiedanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 骑手
     */
    private Integer qishouId;


    /**
     * 订单
     */
    private Integer goodsOrderId;


    /**
     * 接单时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 送单状态
     */
    private Integer qishouJiedanTypes;


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
	 * 获取：骑手
	 */
    public Integer getQishouId() {
        return qishouId;
    }


    /**
	 * 设置：骑手
	 */
    public void setQishouId(Integer qishouId) {
        this.qishouId = qishouId;
    }
    /**
	 * 获取：订单
	 */
    public Integer getGoodsOrderId() {
        return goodsOrderId;
    }


    /**
	 * 设置：订单
	 */
    public void setGoodsOrderId(Integer goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }
    /**
	 * 获取：接单时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：接单时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：送单状态
	 */
    public Integer getQishouJiedanTypes() {
        return qishouJiedanTypes;
    }


    /**
	 * 设置：送单状态
	 */
    public void setQishouJiedanTypes(Integer qishouJiedanTypes) {
        this.qishouJiedanTypes = qishouJiedanTypes;
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
