package com.exam.exam_system.mapper.applyExamMapper;

import com.exam.exam_system.pojo.StuExamPojo;
import com.exam.exam_system.pojo.request.ApplyExamRequest;
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
    int insertApplyExam(@Param("request") ApplyExamRequest applyExamRequest);

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

}
