package com.entity.model;

import com.entity.XueshengZuoyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 作业
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-24
 */
public class XueshengZuoyeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 作业
     */
    private Integer zuoyeId;


    /**
     * 学生完成作业
     */
    private String xueshengZuoyeFile;


    /**
     * 学生完成作业时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xueshengZuoyeTime;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 老师批改作业
     */
    private String laoshiZuoyeFile;


    /**
     * 老师批改作业备注
     */
    private String laoshiZuoyeContent;


    /**
     * 老师批改作业时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date laoshiZuoyeTime;


    /**
     * 作业分数
     */
    private Integer zuoyeNumber;


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
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：作业
	 */
    public Integer getZuoyeId() {
        return zuoyeId;
    }


    /**
	 * 设置：作业
	 */
    public void setZuoyeId(Integer zuoyeId) {
        this.zuoyeId = zuoyeId;
    }
    /**
	 * 获取：学生完成作业
	 */
    public String getXueshengZuoyeFile() {
        return xueshengZuoyeFile;
    }


    /**
	 * 设置：学生完成作业
	 */
    public void setXueshengZuoyeFile(String xueshengZuoyeFile) {
        this.xueshengZuoyeFile = xueshengZuoyeFile;
    }
    /**
	 * 获取：学生完成作业时间
	 */
    public Date getXueshengZuoyeTime() {
        return xueshengZuoyeTime;
    }


    /**
	 * 设置：学生完成作业时间
	 */
    public void setXueshengZuoyeTime(Date xueshengZuoyeTime) {
        this.xueshengZuoyeTime = xueshengZuoyeTime;
    }
    /**
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：老师批改作业
	 */
    public String getLaoshiZuoyeFile() {
        return laoshiZuoyeFile;
    }


    /**
	 * 设置：老师批改作业
	 */
    public void setLaoshiZuoyeFile(String laoshiZuoyeFile) {
        this.laoshiZuoyeFile = laoshiZuoyeFile;
    }
    /**
	 * 获取：老师批改作业备注
	 */
    public String getLaoshiZuoyeContent() {
        return laoshiZuoyeContent;
    }


    /**
	 * 设置：老师批改作业备注
	 */
    public void setLaoshiZuoyeContent(String laoshiZuoyeContent) {
        this.laoshiZuoyeContent = laoshiZuoyeContent;
    }
    /**
	 * 获取：老师批改作业时间
	 */
    public Date getLaoshiZuoyeTime() {
        return laoshiZuoyeTime;
    }


    /**
	 * 设置：老师批改作业时间
	 */
    public void setLaoshiZuoyeTime(Date laoshiZuoyeTime) {
        this.laoshiZuoyeTime = laoshiZuoyeTime;
    }
    /**
	 * 获取：作业分数
	 */
    public Integer getZuoyeNumber() {
        return zuoyeNumber;
    }


    /**
	 * 设置：作业分数
	 */
    public void setZuoyeNumber(Integer zuoyeNumber) {
        this.zuoyeNumber = zuoyeNumber;
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
