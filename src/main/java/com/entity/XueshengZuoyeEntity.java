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
 * 作业
 *
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("xuesheng_zuoye")
public class XueshengZuoyeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengZuoyeEntity() {

	}

	public XueshengZuoyeEntity(T t) {
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
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 作业
     */
    @TableField(value = "zuoye_id")

    private Integer zuoyeId;


    /**
     * 学生完成作业
     */
    @TableField(value = "xuesheng_zuoye_file")

    private String xueshengZuoyeFile;


    /**
     * 学生完成作业时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "xuesheng_zuoye_time",fill = FieldFill.UPDATE)

    private Date xueshengZuoyeTime;


    /**
     * 老师
     */
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 老师批改作业
     */
    @TableField(value = "laoshi_zuoye_file")

    private String laoshiZuoyeFile;


    /**
     * 老师批改作业备注
     */
    @TableField(value = "laoshi_zuoye_content")

    private String laoshiZuoyeContent;


    /**
     * 老师批改作业时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "laoshi_zuoye_time",fill = FieldFill.UPDATE)

    private Date laoshiZuoyeTime;


    /**
     * 作业分数
     */
    @TableField(value = "zuoye_number")

    private Integer zuoyeNumber;


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
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：作业
	 */
    public Integer getZuoyeId() {
        return zuoyeId;
    }


    /**
	 * 获取：作业
	 */

    public void setZuoyeId(Integer zuoyeId) {
        this.zuoyeId = zuoyeId;
    }
    /**
	 * 设置：学生完成作业
	 */
    public String getXueshengZuoyeFile() {
        return xueshengZuoyeFile;
    }


    /**
	 * 获取：学生完成作业
	 */

    public void setXueshengZuoyeFile(String xueshengZuoyeFile) {
        this.xueshengZuoyeFile = xueshengZuoyeFile;
    }
    /**
	 * 设置：学生完成作业时间
	 */
    public Date getXueshengZuoyeTime() {
        return xueshengZuoyeTime;
    }


    /**
	 * 获取：学生完成作业时间
	 */

    public void setXueshengZuoyeTime(Date xueshengZuoyeTime) {
        this.xueshengZuoyeTime = xueshengZuoyeTime;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：老师批改作业
	 */
    public String getLaoshiZuoyeFile() {
        return laoshiZuoyeFile;
    }


    /**
	 * 获取：老师批改作业
	 */

    public void setLaoshiZuoyeFile(String laoshiZuoyeFile) {
        this.laoshiZuoyeFile = laoshiZuoyeFile;
    }
    /**
	 * 设置：老师批改作业备注
	 */
    public String getLaoshiZuoyeContent() {
        return laoshiZuoyeContent;
    }


    /**
	 * 获取：老师批改作业备注
	 */

    public void setLaoshiZuoyeContent(String laoshiZuoyeContent) {
        this.laoshiZuoyeContent = laoshiZuoyeContent;
    }
    /**
	 * 设置：老师批改作业时间
	 */
    public Date getLaoshiZuoyeTime() {
        return laoshiZuoyeTime;
    }


    /**
	 * 获取：老师批改作业时间
	 */

    public void setLaoshiZuoyeTime(Date laoshiZuoyeTime) {
        this.laoshiZuoyeTime = laoshiZuoyeTime;
    }
    /**
	 * 设置：作业分数
	 */
    public Integer getZuoyeNumber() {
        return zuoyeNumber;
    }


    /**
	 * 获取：作业分数
	 */

    public void setZuoyeNumber(Integer zuoyeNumber) {
        this.zuoyeNumber = zuoyeNumber;
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
        return "XueshengZuoye{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", zuoyeId=" + zuoyeId +
            ", xueshengZuoyeFile=" + xueshengZuoyeFile +
            ", xueshengZuoyeTime=" + xueshengZuoyeTime +
            ", laoshiId=" + laoshiId +
            ", laoshiZuoyeFile=" + laoshiZuoyeFile +
            ", laoshiZuoyeContent=" + laoshiZuoyeContent +
            ", laoshiZuoyeTime=" + laoshiZuoyeTime +
            ", zuoyeNumber=" + zuoyeNumber +
            ", createTime=" + createTime +
        "}";
    }
}
