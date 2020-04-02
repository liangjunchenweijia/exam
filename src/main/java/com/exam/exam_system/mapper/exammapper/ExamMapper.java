package com.exam.exam_system.mapper.exammapper;

import com.exam.exam_system.pojo.ExamPojo;
import com.exam.exam_system.pojo.request.ExamAllRequet;
import com.exam.exam_system.pojo.request.ExamRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamMapper
 * @Description :
 * @Date : 2020/3/26 15:24
 */
public interface ExamMapper {

    /**
     * @param examRequest
     * @Author :
     * @Description : 添加考试
     * @Date : 2020/4/1 17:05
     * @Return :
     **/
    int insertExam(@Param("examRequest") ExamRequest examRequest);

    /**
     * @param ids
     * @Author :
     * @Description : 批量删除考试
     * @Date : 2020/4/1 17:31
     * @Return :
     **/
    int batchDelExamById(@Param("ids") List<Long> ids);

    /**
     * @param request
     * @param offset
     * @param limit
     * @Author :
     * @Description :  考试列表
     * @Date : 2020/4/2 9:41
     * @Return :
     **/
    List<ExamPojo> selectExamAll(@Param("request") ExamAllRequet request, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * @param request
     * @Author :
     * @Description :  考试列表总数
     * @Date : 2020/4/2 9:52
     * @Return :
     **/
    int selectExamAllCount(@Param("request") ExamAllRequet request);
}
