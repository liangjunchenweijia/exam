package com.exam.exam_system.mapper.exammapper;

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
}
