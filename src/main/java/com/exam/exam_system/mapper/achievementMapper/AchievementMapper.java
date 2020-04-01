package com.exam.exam_system.mapper.achievementMapper;

import com.exam.exam_system.pojo.request.AchievementRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :
 * @ClassName : AchievementMapper
 * @Description :
 * @Date : 2020/3/28 16:47
 */
public interface AchievementMapper {
    /**
     * @param achievementRequests
     * @Author :
     * @Description : 保存考试成绩信息
     * @Date : 2020/3/28 16:53
     * @Return :
     **/
    int insert(@Param("achievementRequests") List<AchievementRequest> achievementRequests);


}
