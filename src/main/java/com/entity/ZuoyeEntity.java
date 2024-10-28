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
@TableName("zuoye")
public class ZuoyeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZuoyeEntity() {

	}

	public ZuoyeEntity(T t) {
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
     * 班级课程
     */
    @TableField(value = "banji_kecheng_laoshi_id")

    private Integer banjiKechengLaoshiId;


    /**
     * 作业名字
     */
    @TableField(value = "zuoye_name")

    private String zuoyeName;


    /**
     * 布置的作业
     */
    @TableField(value = "zuoye_file")

    private String zuoyeFile;


    /**
     * 作业详情
     */
    @TableField(value = "zuoye_content")

    private String zuoyeContent;


    /**
     * 发布作业时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 作业截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "end_time",fill = FieldFill.UPDATE)

    private Date endTime;


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
	 * 设置：班级课程
	 */
    public Integer getBanjiKechengLaoshiId() {
        return banjiKechengLaoshiId;
    }


    /**
	 * 获取：班级课程
	 */

    public void setBanjiKechengLaoshiId(Integer banjiKechengLaoshiId) {
        this.banjiKechengLaoshiId = banjiKechengLaoshiId;
    }
    /**
	 * 设置：作业名字
	 */
    public String getZuoyeName() {
        return zuoyeName;
    }


    /**
	 * 获取：作业名字
	 */

    public void setZuoyeName(String zuoyeName) {
        this.zuoyeName = zuoyeName;
    }
    /**
	 * 设置：布置的作业
	 */
    public String getZuoyeFile() {
        return zuoyeFile;
    }


    /**
	 * 获取：布置的作业
	 */

    public void setZuoyeFile(String zuoyeFile) {
        this.zuoyeFile = zuoyeFile;
    }
    /**
	 * 设置：作业详情
	 */
    public String getZuoyeContent() {
        return zuoyeContent;
    }


    /**
	 * 获取：作业详情
	 */

    public void setZuoyeContent(String zuoyeContent) {
        this.zuoyeContent = zuoyeContent;
    }
    /**
	 * 设置：发布作业时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布作业时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：作业截止时间
	 */
    public Date getEndTime() {
        return endTime;
    }


    /**
	 * 获取：作业截止时间
	 */

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        return "Zuoye{" +
            "id=" + id +
            ", banjiKechengLaoshiId=" + banjiKechengLaoshiId +
            ", zuoyeName=" + zuoyeName +
            ", zuoyeFile=" + zuoyeFile +
            ", zuoyeContent=" + zuoyeContent +
            ", insertTime=" + insertTime +
            ", endTime=" + endTime +
            ", createTime=" + createTime +
        "}";
    }
}
