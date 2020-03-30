package com.exam.exam_system.mapper.achievementMapper;

import com.exam.exam_system.pojo.AchievementPojo;
import com.exam.exam_system.pojo.request.AchievementRequest;
import com.exam.exam_system.pojo.response.UserAchievementVO;
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

    /**
     * @param request
     * @param offset
     * @param limit
     * @Author :
     * @Description : 查询所有学生成绩
     * @Date : 2020/3/30 13:44
     * @Return :
     **/
    List<UserAchievementVO> selectAchievementAll(@Param("request") AchievementRequest request, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * @param request
     * @Author :
     * @Description : 成绩总数
     * @Date : 2020/3/30 13:56
     * @Return :
     **/
    int selectAchievementCount(@Param("request") AchievementRequest request);
}
