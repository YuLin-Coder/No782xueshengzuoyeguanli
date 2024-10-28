package com.entity.view;

import com.entity.ZuoyeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("zuoye")
public class ZuoyeView extends ZuoyeEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 banji_kecheng_laoshi
			/**
			* 班级
			*/
			private Integer banjiId;
			/**
			* 课程
			*/
			private Integer kechengId;
			/**
			* 老师
			*/
			private Integer laoshiId;
			/**
			* 备注
			*/
			private String beizhuContent;

            /**
             * 班级名
             */
            private String banjiName;
            /**
             * 课程名
             */
            private String kechengName;
            /**
             * 老师名
             */
            private String laoshiName;

	public ZuoyeView() {

	}

	public ZuoyeView(ZuoyeEntity zuoyeEntity) {
		try {
			BeanUtils.copyProperties(this, zuoyeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set banji_kecheng_laoshi
					/**
					* 获取： 班级
					*/
					public Integer getBanjiId() {
						return banjiId;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiId(Integer banjiId) {
						this.banjiId = banjiId;
					}
					/**
					* 获取： 课程
					*/
					public Integer getKechengId() {
						return kechengId;
					}
					/**
					* 设置： 课程
					*/
					public void setKechengId(Integer kechengId) {
						this.kechengId = kechengId;
					}
					/**
					* 获取： 老师
					*/
					public Integer getLaoshiId() {
						return laoshiId;
					}
					/**
					* 设置： 老师
					*/
					public void setLaoshiId(Integer laoshiId) {
						this.laoshiId = laoshiId;
					}
					/**
					* 获取： 备注
					*/
					public String getBeizhuContent() {
						return beizhuContent;
					}
					/**
					* 设置： 备注
					*/
					public void setBeizhuContent(String beizhuContent) {
						this.beizhuContent = beizhuContent;
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

    public String getLaoshiName() {
        return laoshiName;
    }

    public void setLaoshiName(String laoshiName) {
        this.laoshiName = laoshiName;
    }
}
