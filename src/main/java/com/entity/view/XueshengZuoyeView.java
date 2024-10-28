package com.entity.view;

import com.entity.XueshengZuoyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 作业
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("xuesheng_zuoye")
public class XueshengZuoyeView extends XueshengZuoyeEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 laoshi
//			/**
//			* 账户
//			*/
//			private String username;
//			/**
//			* 密码
//			*/
//			private String password;
			/**
			* 姓名
			*/
			private String laoshiName;
//			/**
//			* 性别
//			*/
//			private Integer sexTypes;
//				/**
//				* 性别的值
//				*/
//				private String sexValue;
			/**
			* 身份证号
			*/
			private String laoshiIdNumber;
			/**
			* 手机号
			*/
			private String laoshiPhone;
			/**
			* 照片
			*/
			private String laoshiPhoto;
			/**
			* 民族
			*/
			private String laoshiNation;
			/**
			* 政治面貌
			*/
			private Integer politicsTypes;
				/**
				* 政治面貌的值
				*/
				private String politicsValue;
			/**
			* 家庭住址
			*/
			private String laoshiAddress;

		//级联表 yonghu
//			/**
//			* 账户
//			*/
//			private String username;
//			/**
//			* 密码
//			*/
//			private String password;
			/**
			* 姓名
			*/
			private String name;
//			/**
//			* 性别
//			*/
//			private Integer sexTypes;
//				/**
//				* 性别的值
//				*/
//				private String sexValue;
			/**
			* 身份证号
			*/
			private String idNumber;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 照片
			*/
			private String yonghuPhoto;
			/**
			* 民族
			*/
			private String nation;
//			/**
//			* 政治面貌
//			*/
//			private Integer politicsTypes;
//				/**
//				* 政治面貌的值
//				*/
//				private String politicsValue;
			/**
			* 家庭住址
			*/
			private String address;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;

		//级联表 zuoye
			/**
			* 班级课程
			*/
			private Integer banjiKechengId;
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
			private Date insertTime;
			/**
			* 作业截止时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			private Date endTime;


			private String banjiName;
			private String kechengName;

	public XueshengZuoyeView() {

	}

	public XueshengZuoyeView(XueshengZuoyeEntity xueshengZuoyeEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengZuoyeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBanjiName() {
		return banjiName;
	}

	public void setBanjiName(String banjiName) {
		this.banjiName = banjiName;
	}

	public String getKechengName() {
		return kechengName;
	}

	public void setKechengName(String kechengName) {
		this.kechengName = kechengName;
	}


//级联表的get和set laoshi

					/**
					* 获取： 姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}

					/**
					* 获取： 身份证号
					*/
					public String getLaoshiIdNumber() {
						return laoshiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setLaoshiIdNumber(String laoshiIdNumber) {
						this.laoshiIdNumber = laoshiIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getLaoshiPhone() {
						return laoshiPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setLaoshiPhone(String laoshiPhone) {
						this.laoshiPhone = laoshiPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}
					/**
					* 获取： 民族
					*/
					public String getLaoshiNation() {
						return laoshiNation;
					}
					/**
					* 设置： 民族
					*/
					public void setLaoshiNation(String laoshiNation) {
						this.laoshiNation = laoshiNation;
					}

					/**
					* 获取： 家庭住址
					*/
					public String getLaoshiAddress() {
						return laoshiAddress;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setLaoshiAddress(String laoshiAddress) {
						this.laoshiAddress = laoshiAddress;
					}










				//级联表的get和set yonghu

					/**
					* 获取： 姓名
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 姓名
					*/
					public void setName(String name) {
						this.name = name;
					}

					/**
					* 获取： 身份证号
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 民族
					*/
					public String getNation() {
						return nation;
					}
					/**
					* 设置： 民族
					*/
					public void setNation(String nation) {
						this.nation = nation;
					}
					/**
					* 获取： 政治面貌
					*/
					public Integer getPoliticsTypes() {
						return politicsTypes;
					}
					/**
					* 设置： 政治面貌
					*/
					public void setPoliticsTypes(Integer politicsTypes) {
						this.politicsTypes = politicsTypes;
					}


						/**
						* 获取： 政治面貌的值
						*/
						public String getPoliticsValue() {
							return politicsValue;
						}
						/**
						* 设置： 政治面貌的值
						*/
						public void setPoliticsValue(String politicsValue) {
							this.politicsValue = politicsValue;
						}
					/**
					* 获取： 家庭住址
					*/
					public String getAddress() {
						return address;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setAddress(String address) {
						this.address = address;
					}
					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}





				//级联表的get和set zuoye
					/**
					* 获取： 班级课程
					*/
					public Integer getBanjiKechengId() {
						return banjiKechengId;
					}
					/**
					* 设置： 班级课程
					*/
					public void setBanjiKechengId(Integer banjiKechengId) {
						this.banjiKechengId = banjiKechengId;
					}
					/**
					* 获取： 作业名字
					*/
					public String getZuoyeName() {
						return zuoyeName;
					}
					/**
					* 设置： 作业名字
					*/
					public void setZuoyeName(String zuoyeName) {
						this.zuoyeName = zuoyeName;
					}
					/**
					* 获取： 布置的作业
					*/
					public String getZuoyeFile() {
						return zuoyeFile;
					}
					/**
					* 设置： 布置的作业
					*/
					public void setZuoyeFile(String zuoyeFile) {
						this.zuoyeFile = zuoyeFile;
					}
					/**
					* 获取： 作业详情
					*/
					public String getZuoyeContent() {
						return zuoyeContent;
					}
					/**
					* 设置： 作业详情
					*/
					public void setZuoyeContent(String zuoyeContent) {
						this.zuoyeContent = zuoyeContent;
					}
					/**
					* 获取： 发布作业时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 发布作业时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}
					/**
					* 获取： 作业截止时间
					*/
					public Date getEndTime() {
						return endTime;
					}
					/**
					* 设置： 作业截止时间
					*/
					public void setEndTime(Date endTime) {
						this.endTime = endTime;
					}





}
