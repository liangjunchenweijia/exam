package com.exam.exam_system.controller.achievementController;

import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.service.achievementService.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
