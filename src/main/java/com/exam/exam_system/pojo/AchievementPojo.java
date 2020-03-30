package com.exam.exam_system.pojo;

import com.exam.exam_system.pojo.request.AchievementRequest;

import java.util.List;

/**
 * @Author :
 * @ClassName : achievementPojo
 * @Description :
 * @Date : 2020/3/30 9:37
 */
public class AchievementPojo {
    private List<AchievementRequest> achievementRequests;

    public List<AchievementRequest> getAchievementRequests() {
        return achievementRequests;
    }

    public void setAchievementRequests(List<AchievementRequest> achievementRequests) {
        this.achievementRequests = achievementRequests;
    }
}
