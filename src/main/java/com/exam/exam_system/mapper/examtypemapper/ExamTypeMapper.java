package com.exam.exam_system.mapper.examtypemapper;

import com.exam.exam_system.pojo.request.ExamTypeRequest;
import com.exam.exam_system.pojo.response.ExamTypeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamTypeMapper
 * @Description :
 * @Date : 2020/3/24 15:31
 */
public interface ExamTypeMapper {
    /**
     * @param examTypeRequest
     * @Author :
     * @Description : 添加考试类型
     * @Date : 2020/3/24 15:35
     * @Return :
     **/
    int insert(@Param("examTypeRequest") ExamTypeRequest examTypeRequest);

    /**
     * @param examTypeRequest
     * @Author :
     * @Description : 修改考试类型
     * @Date : 2020/3/24 15:56
     * @Return :
     **/
    int updateExamTypeById(@Param("examTypeRequest") ExamTypeRequest examTypeRequest);

    /**
     * @Author :
     * @Description : 查询所有考试类型(分页)
     * @Date : 2020/3/26 13:39
     * @Return :
     **/
    List<ExamTypeVO> selectExamTypeAll();


    /**
     * @param examTypeId
     * @Author :
     * @Description : 通过选中的考试类型找出此次考试类型中包含的科目
     * @Date : 2020/3/26 15:36
     * @Return :
     **/
    String selectEaxmSubjectById(@Param("examTypeId") Long examTypeId);

    /**
     * @param examName
     * @Author :
     * @Description : 通过名称查询考试类型
     * @Date : 2020/4/1 9:10
     * @Return : 返回总数
     **/
    int selectExamTypeByName(@Param("examName") String examName);

    /**
     * @param id
     * @Author :
     * @Description : 通过唯一编号查询考试类型详情
     * @Date : 2020/4/1 9:19
     * @Return :
     **/
    ExamTypeVO selectExamTypeById(@Param("id") Long id);
}
