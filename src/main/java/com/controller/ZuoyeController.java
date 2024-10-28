package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.*;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.view.ZuoyeView;
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
@RequestMapping("/zuoye")
public class ZuoyeController {
    private static final Logger logger = LoggerFactory.getLogger(ZuoyeController.class);

    @Autowired
    private ZuoyeService zuoyeService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private BanjiKechengLaoshiService banjiKechengLaoshiService;
    @Autowired
    private LaoshiService laoshiService;
    @Autowired
    private XueshengZuoyeService xueshengZuoyeService;
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = zuoyeService.queryPage(params);

        //字典表数据转换
        List<ZuoyeView> list =(List<ZuoyeView>)page.getList();
        for(ZuoyeView c:list){
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
        ZuoyeEntity zuoye = zuoyeService.selectById(id);
        if(zuoye !=null){
            //entity转view
            ZuoyeView view = new ZuoyeView();
            BeanUtils.copyProperties( zuoye , view );//把实体数据重构到view中

            //级联表
            BanjiKechengLaoshiEntity banjiKechengLaoshi = banjiKechengLaoshiService.selectById(zuoye.getBanjiKechengLaoshiId());
            if(banjiKechengLaoshi != null){
                BeanUtils.copyProperties( banjiKechengLaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBanjiKechengLaoshiId(banjiKechengLaoshi.getId());
                DictionaryEntity banjiEntity = dictionaryService.selectById(banjiKechengLaoshi.getBanjiId());
                view.setBanjiName(banjiEntity.getIndexName());
                DictionaryEntity kechengEntity = dictionaryService.selectById(banjiKechengLaoshi.getKechengId());
                view.setKechengName(kechengEntity.getIndexName());
                LaoshiEntity laoshiEntity = laoshiService.selectById(banjiKechengLaoshi.getLaoshiId());
                view.setLaoshiName(laoshiEntity.getLaoshiName());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZuoyeEntity zuoye, HttpServletRequest request) {
        logger.debug("save方法:,,Controller:{},,zuoye:{}", this.getClass().getName(), zuoye.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if ("老师".equals(role)) {
            Wrapper<ZuoyeEntity> queryWrapper = new EntityWrapper<ZuoyeEntity>()
                    .eq("banji_kecheng_laoshi_id", zuoye.getBanjiKechengLaoshiId())
                    .eq("zuoye_name", zuoye.getZuoyeName());
            logger.info("sql语句:" + queryWrapper.getSqlSegment());
            ZuoyeEntity zuoyeEntity = zuoyeService.selectOne(queryWrapper);
            if (zuoyeEntity == null) {
                Date date = new Date();
                zuoye.setInsertTime(date);
                zuoye.setCreateTime(date);
                if ((zuoye.getEndTime().getTime() - date.getTime()) < 0) {
                    return R.error(511, "作业截止时间不能小于当前时间");
                }
                zuoyeService.insert(zuoye);

                //级联新增学生作业
                        // 查询出关系
                        BanjiKechengLaoshiEntity banjiKechengLaoshiEntity = banjiKechengLaoshiService.selectById(zuoye.getBanjiKechengLaoshiId());
                if (banjiKechengLaoshiEntity != null) {
                    DictionaryEntity banjiEntity = dictionaryService.selectById(banjiKechengLaoshiEntity.getBanjiId());
                    List<YonghuEntity> xueshengEntities = yonghuService.selectList(new EntityWrapper<YonghuEntity>().eq("banji_types", banjiEntity.getCodeIndex()));
                    List<Integer> xueshengIds = new ArrayList<>();
                    for (YonghuEntity y : xueshengEntities) {
                        xueshengIds.add(y.getId());
                    }
                    List<XueshengZuoyeEntity> xueshengZuoyeLists = new ArrayList<>();
                    for (Integer i : xueshengIds) {
                        XueshengZuoyeEntity xueshengZuoyeEntity = new XueshengZuoyeEntity();
                        xueshengZuoyeEntity.setCreateTime(date);
                        xueshengZuoyeEntity.setYonghuId(i);
                        xueshengZuoyeEntity.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
                        xueshengZuoyeEntity.setZuoyeId(zuoye.getId());
                        xueshengZuoyeLists.add(xueshengZuoyeEntity);
                    }
                    if(xueshengZuoyeLists != null && xueshengZuoyeLists.size()>0){
                        xueshengZuoyeService.insertBatch(xueshengZuoyeLists);
                    }
                    return R.ok();
                } else {
                    return R.error(511, "查不到班级课程老师关系表");
                }
            } else {
                return R.error(511, "表中有相同数据");
            }
        }else {
            return R.error(511, "您没有权限新增作业");
        }
    }

//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody ZuoyeEntity zuoye, HttpServletRequest request) {
//        logger.debug("update方法:,,Controller:{},,zuoye:{}", this.getClass().getName(), zuoye.toString());
//
//        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if ("老师".equals(role)) {
//            //根据字段查询是否有相同数据
//            Wrapper<ZuoyeEntity> queryWrapper = new EntityWrapper<ZuoyeEntity>()
//                    .notIn("id", zuoye.getId())
//                    .andNew()
//                    .eq("banji_kecheng_laoshi_id", zuoye.getBanjiKechengLaoshiId())
//                    .eq("zuoye_name", zuoye.getZuoyeName());
//            logger.info("sql语句:" + queryWrapper.getSqlSegment());
//            ZuoyeEntity zuoyeEntity = zuoyeService.selectOne(queryWrapper);
//            if ("".equals(zuoye.getZuoyeFile()) || "null".equals(zuoye.getZuoyeFile())) {
//                zuoye.setZuoyeFile(null);
//            }
//            if (zuoyeEntity == null) {
//                if ((zuoye.getEndTime().getTime() - zuoye.getInsertTime().getTime()) < 0) {
//                    return R.error(511, "作业截止时间不能小于当前时间");
//                }
//                ZuoyeEntity one = zuoyeService.selectById(zuoye.getId());
//                if(zuoye.getBanjiKechengLaoshiId() == zuoye.)
//                zuoyeService.updateById(zuoye);//根据id更新
//                return R.ok();
//            } else {
//                return R.error(511, "表中有相同数据");
//            }
//        } else {
//            return R.error(511, "您没有权限修改作业");
//        }
//    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zuoyeService.deleteBatchIds(Arrays.asList(ids));
        xueshengZuoyeService.delete(new EntityWrapper<XueshengZuoyeEntity>().in("zuoye_id",ids));
        return R.ok();
    }


}

