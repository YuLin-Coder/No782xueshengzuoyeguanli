package com.entity.model;

import com.entity.ZuoyeEntity;

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
public class ZuoyeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 班级课程
     */
    private Integer banjiKechengLaoshiId;


    /**
     * 作业名字
     */
    private String zuoyeName;


    /**
     * 布置的作业
     */
    private String zuoyeFile;


    /**
     * 作业详情
     */
    private String zuoyeContent;


    /**
     * 发布作业时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 作业截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date endTime;


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
	 * 获取：班级课程
	 */
    public Integer getBanjiKechengLaoshiId() {
        return banjiKechengLaoshiId;
    }


    /**
	 * 设置：班级课程
	 */
    public void setBanjiKechengLaoshiId(Integer banjiKechengLaoshiId) {
        this.banjiKechengLaoshiId = banjiKechengLaoshiId;
    }
    /**
	 * 获取：作业名字
	 */
    public String getZuoyeName() {
        return zuoyeName;
    }


    /**
	 * 设置：作业名字
	 */
    public void setZuoyeName(String zuoyeName) {
        this.zuoyeName = zuoyeName;
    }
    /**
	 * 获取：布置的作业
	 */
    public String getZuoyeFile() {
        return zuoyeFile;
    }


    /**
	 * 设置：布置的作业
	 */
    public void setZuoyeFile(String zuoyeFile) {
        this.zuoyeFile = zuoyeFile;
    }
    /**
	 * 获取：作业详情
	 */
    public String getZuoyeContent() {
        return zuoyeContent;
    }


    /**
	 * 设置：作业详情
	 */
    public void setZuoyeContent(String zuoyeContent) {
        this.zuoyeContent = zuoyeContent;
    }
    /**
	 * 获取：发布作业时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布作业时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：作业截止时间
	 */
    public Date getEndTime() {
        return endTime;
    }


    /**
	 * 设置：作业截止时间
	 */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
