package com.exam.exam_system.controller.achievementController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.pojo.AchievementPojo;
import com.exam.exam_system.pojo.request.AchievementRequest;
import com.exam.exam_system.pojo.response.UserAchievementVO;
import com.exam.exam_system.service.achievementService.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author :
 * @ClassName : AchievementController
 * @Description : 考试成绩控制器
 * @Date : 2020/3/28 16:44
 */
@RestController
@RequestMapping("/achievement")
public class AchievementController extends BaseController {

    private AchievementService achievementService;

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    /**
     * @param achievementPojo
     * @Author :
     * @Description : 保存考试成绩信息
     * @Date : 2020/3/28 16:50
     * @Return :
     **/
    @PostMapping("/saveAchievement")
    public Result<Object> saveAchievement(@RequestBody AchievementPojo achievementPojo) {
        logger.info("保存考试成绩信息:{}", JSON.toJSONString(achievementPojo));
        achievementService.addAchievement(achievementPojo);
        return new Result<Object>();
    }

    /**
     * @param
     * @Author :
     * @Description : 成绩列表
     * @Date : 2020/3/30 13:25
     * @Return : 返回学生成绩信息
     **/
    @PostMapping("/queryAchievementAll")
    public PageResult<List<UserAchievementVO>> queryAchievementAll(@RequestBody PageRequest<AchievementRequest> request) {
        logger.info("成绩列表:{}", JSON.toJSONString(request));
        PageResult<List<UserAchievementVO>> achievementAll = achievementService.findAchievementAll(request);
        logger.info("成绩列表返回:{}",JSON.toJSONString(achievementAll));
        return new PageResult<List<UserAchievementVO>>(achievementAll.getPageNo(), achievementAll.getPageSize()
                , achievementAll.getTotal(), achievementAll.getObj());
    }
}
