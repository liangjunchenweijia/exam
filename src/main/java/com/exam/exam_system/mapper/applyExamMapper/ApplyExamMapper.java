package com.exam.exam_system.mapper.applyExamMapper;

import com.exam.exam_system.pojo.StuExamPojo;
import com.exam.exam_system.pojo.request.AchievementRequest;
import com.exam.exam_system.pojo.request.ApplyExamRequest;
import com.exam.exam_system.pojo.request.StuExamRequest;
import com.exam.exam_system.pojo.response.AchievementResponse;
import com.exam.exam_system.pojo.response.ApplyExamResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :
 * @ClassName : ApplyExamMapper
 * @Description :
 * @Date : 2020/4/2 16:31
 */
public interface ApplyExamMapper {
    /**
     * @param applyExamRequest
     * @Author :
     * @Description :  报名参加考试
     * @Date : 2020/4/7 9:32
     * @Return : 返回 影响行数
     **/
//    int insertApplyExam(@Param("request") ApplyExamRequest applyExamRequest);

    /**
     * @param applyExamRequest
     * @Author :
     * @Description : 考试列表
     * @Date : 2020/4/7 10:16
     * @Return :
     **/
    List<StuExamPojo> selectStuExamAll(@Param("request") ApplyExamRequest applyExamRequest, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * @param request
     * @Author :
     * @Description : 考试列表总数
     * @Date : 2020/4/7 11:04
     * @Return :
     **/
    int selectStuExamAllCount(@Param("request") ApplyExamRequest request);

    /**
     * @param id
     * @Author :
     * @Description : 查询考试规则
     * @Date : 2020/4/8 14:35
     * @Return :
     **/
    ApplyExamResponse selectExamRule(@Param("id") Long id);

    /**
     * @param stuExamRequest
     * @Author :
     * @Description : 开始考试
     * @Date : 2020/4/8 16:52
     * @Return :
     **/
    int insert(@Param("stuExamRequest") List<StuExamRequest> stuExamRequest);

    /**
     * @param topicIds
     * @Author :
     * @Description : 查询填选答案和正确答案
     * @Date : 2020/4/9 9:21
     * @Return :
     **/
    List<AchievementResponse> selectAnswers(@Param("ids") List<Long> topicIds);

    /**
     * @param achievementRequest
     * @Author :
     * @Description : 保存考试信息
     * @Date : 2020/4/9 9:39
     * @Return :
     **/
    int addAchievement(@Param("request") AchievementRequest achievementRequest);
}
