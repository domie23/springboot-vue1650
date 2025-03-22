package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 骑手接单
 *
 * @author 
 * @email
 */
@TableName("qishou_jiedan")
public class QishouJiedanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QishouJiedanEntity() {

	}

	public QishouJiedanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 骑手
     */
    @TableField(value = "qishou_id")

    private Integer qishouId;


    /**
     * 订单
     */
    @TableField(value = "goods_order_id")

    private Integer goodsOrderId;


    /**
     * 接单时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 送单状态
     */
    @TableField(value = "qishou_jiedan_types")

    private Integer qishouJiedanTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：骑手
	 */
    public Integer getQishouId() {
        return qishouId;
    }


    /**
	 * 获取：骑手
	 */

    public void setQishouId(Integer qishouId) {
        this.qishouId = qishouId;
    }
    /**
	 * 设置：订单
	 */
    public Integer getGoodsOrderId() {
        return goodsOrderId;
    }


    /**
	 * 获取：订单
	 */

    public void setGoodsOrderId(Integer goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }
    /**
	 * 设置：接单时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：接单时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：送单状态
	 */
    public Integer getQishouJiedanTypes() {
        return qishouJiedanTypes;
    }


    /**
	 * 获取：送单状态
	 */

    public void setQishouJiedanTypes(Integer qishouJiedanTypes) {
        this.qishouJiedanTypes = qishouJiedanTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "QishouJiedan{" +
            "id=" + id +
            ", qishouId=" + qishouId +
            ", goodsOrderId=" + goodsOrderId +
            ", insertTime=" + insertTime +
            ", qishouJiedanTypes=" + qishouJiedanTypes +
            ", createTime=" + createTime +
        "}";
    }
}
