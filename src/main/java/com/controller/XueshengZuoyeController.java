package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.XueshengZuoyeEntity;

import com.service.XueshengZuoyeService;
import com.entity.view.XueshengZuoyeView;
import com.service.LaoshiService;
import com.entity.LaoshiEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.service.ZuoyeService;
import com.entity.ZuoyeEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 作业
 * 后端接口
 * @author
 * @email
 * @date 2021-03-24
*/
@RestController
@Controller
@RequestMapping("/xueshengZuoye")
public class XueshengZuoyeController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengZuoyeController.class);

    @Autowired
    private XueshengZuoyeService xueshengZuoyeService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private LaoshiService laoshiService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZuoyeService zuoyeService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "老师".equals(role)){
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = xueshengZuoyeService.queryPage(params);

        //字典表数据转换
        List<XueshengZuoyeView> list =(List<XueshengZuoyeView>)page.getList();
        for(XueshengZuoyeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XueshengZuoyeEntity xueshengZuoye = xueshengZuoyeService.selectById(id);
        if(xueshengZuoye !=null){
            //entity转view
            XueshengZuoyeView view = new XueshengZuoyeView();
            BeanUtils.copyProperties( xueshengZuoye , view );//把实体数据重构到view中

            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(xueshengZuoye.getLaoshiId());
            if(laoshi != null){
                BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setLaoshiId(laoshi.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xueshengZuoye.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //级联表
            ZuoyeEntity zuoye = zuoyeService.selectById(xueshengZuoye.getZuoyeId());
            if(zuoye != null){
                BeanUtils.copyProperties( zuoye , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setZuoyeId(zuoye.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

//    /**
//    * 后端保存
//    */
//    @RequestMapping("/save")
//    public R save(@RequestBody XueshengZuoyeEntity xueshengZuoye, HttpServletRequest request){
//        logger.debug("save方法:,,Controller:{},,xueshengZuoye:{}",this.getClass().getName(),xueshengZuoye.toString());
//        Wrapper<XueshengZuoyeEntity> queryWrapper = new EntityWrapper<XueshengZuoyeEntity>()
//            .eq("yonghu_id", xueshengZuoye.getYonghuId())
//            .eq("zuoye_id", xueshengZuoye.getZuoyeId())
//            .eq("laoshi_id", xueshengZuoye.getLaoshiId())
//            .eq("laoshi_zuoye_content", xueshengZuoye.getLaoshiZuoyeContent())
//            .eq("zuoye_number", xueshengZuoye.getZuoyeNumber())
//            ;
//        logger.info("sql语句:"+queryWrapper.getSqlSegment());
//        XueshengZuoyeEntity xueshengZuoyeEntity = xueshengZuoyeService.selectOne(queryWrapper);
//        if(xueshengZuoyeEntity==null){
//            xueshengZuoye.setCreateTime(new Date());
//        //  String role = String.valueOf(request.getSession().getAttribute("role"));
//        //  if("".equals(role)){
//        //      xueshengZuoye.set
//        //  }
//            xueshengZuoyeService.insert(xueshengZuoye);
//            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
//    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengZuoyeEntity xueshengZuoye, HttpServletRequest request) {
        logger.debug("update方法:,,Controller:{},,xueshengZuoye:{}", this.getClass().getName(), xueshengZuoye.toString());
        //根据字段查询是否有相同数据
        Wrapper<XueshengZuoyeEntity> queryWrapper = new EntityWrapper<XueshengZuoyeEntity>()
                .notIn("id", xueshengZuoye.getId())
                .andNew()
                .eq("yonghu_id", xueshengZuoye.getYonghuId())
                .eq("zuoye_id", xueshengZuoye.getZuoyeId());
        logger.info("sql语句:" + queryWrapper.getSqlSegment());
        XueshengZuoyeEntity xueshengZuoyeEntity = xueshengZuoyeService.selectOne(queryWrapper);
        if ("".equals(xueshengZuoye.getXueshengZuoyeFile()) || "null".equals(xueshengZuoye.getXueshengZuoyeFile())) {
            xueshengZuoye.setXueshengZuoyeFile(null);
        }
        xueshengZuoye.setXueshengZuoyeTime(new Date());
        if ("".equals(xueshengZuoye.getLaoshiZuoyeFile()) || "null".equals(xueshengZuoye.getLaoshiZuoyeFile())) {
            xueshengZuoye.setLaoshiZuoyeFile(null);
        }
        if (xueshengZuoyeEntity == null) {
              String role = String.valueOf(request.getSession().getAttribute("role"));
              if("老师".equals(role)){
                  xueshengZuoye.setLaoshiZuoyeTime(new Date());
              }else if("学生".equals(role)){
                  xueshengZuoye.setXueshengZuoyeTime(new Date());
              }
            xueshengZuoyeService.updateById(xueshengZuoye);//根据id更新
            return R.ok();
        } else {
            return R.error(511, "该学生已有该作业");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xueshengZuoyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

