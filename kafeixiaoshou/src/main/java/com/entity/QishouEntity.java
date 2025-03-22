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
 * 骑手
 *
 * @author 
 * @email
 */
@TableName("qishou")
public class QishouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QishouEntity() {

	}

	public QishouEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 骑手姓名
     */
    @TableField(value = "qishou_name")

    private String qishouName;


    /**
     * 头像
     */
    @TableField(value = "qishou_photo")

    private String qishouPhoto;


    /**
     * 骑手手机号
     */
    @TableField(value = "qishou_phone")

    private String qishouPhone;


    /**
     * 骑手身份证号
     */
    @TableField(value = "qishou_id_number")

    private String qishouIdNumber;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 假删
     */
    @TableField(value = "qishou_delete")

    private Integer qishouDelete;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：骑手姓名
	 */
    public String getQishouName() {
        return qishouName;
    }


    /**
	 * 获取：骑手姓名
	 */

    public void setQishouName(String qishouName) {
        this.qishouName = qishouName;
    }
    /**
	 * 设置：头像
	 */
    public String getQishouPhoto() {
        return qishouPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setQishouPhoto(String qishouPhoto) {
        this.qishouPhoto = qishouPhoto;
    }
    /**
	 * 设置：骑手手机号
	 */
    public String getQishouPhone() {
        return qishouPhone;
    }


    /**
	 * 获取：骑手手机号
	 */

    public void setQishouPhone(String qishouPhone) {
        this.qishouPhone = qishouPhone;
    }
    /**
	 * 设置：骑手身份证号
	 */
    public String getQishouIdNumber() {
        return qishouIdNumber;
    }


    /**
	 * 获取：骑手身份证号
	 */

    public void setQishouIdNumber(String qishouIdNumber) {
        this.qishouIdNumber = qishouIdNumber;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getQishouDelete() {
        return qishouDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setQishouDelete(Integer qishouDelete) {
        this.qishouDelete = qishouDelete;
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
        return "Qishou{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", qishouName=" + qishouName +
            ", qishouPhoto=" + qishouPhoto +
            ", qishouPhone=" + qishouPhone +
            ", qishouIdNumber=" + qishouIdNumber +
            ", sexTypes=" + sexTypes +
            ", qishouDelete=" + qishouDelete +
            ", createTime=" + createTime +
        "}";
    }
}
