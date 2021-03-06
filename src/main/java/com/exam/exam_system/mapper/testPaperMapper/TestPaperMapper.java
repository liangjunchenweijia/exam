package com.exam.exam_system.mapper.testPaperMapper;

import com.exam.exam_system.pojo.request.ExamTestPaperContentRequest;
import com.exam.exam_system.pojo.request.ExamTestPaperNameRequest;
import com.exam.exam_system.pojo.response.ExamTestPaperNameVO;
import com.exam.exam_system.pojo.response.ExamTestPaperVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author :
 * @ClassName : TestPaperMapper
 * @Description :
 * @Date : 2020/4/1 10:34
 */
public interface TestPaperMapper {
    /**
     * @param examTestPaperRequest
     * @Author :
     * @Description : 添加试卷名称
     * @Date : 2020/4/1 10:47
     * @Return : 返回 主键
     **/
    int addTestPaperName(@Param("examTestPaperRequest") ExamTestPaperNameRequest examTestPaperRequest);

    /**
     * @param
     * @Author :
     * @Description : 查询所有试卷名称
     * @Date : 2020/4/1 11:45
     * @Return :
     **/
    List<ExamTestPaperNameVO> selectTestPaperNameAll(@Param("request") ExamTestPaperNameRequest examTestPaperNameRequest, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * @param request
     * @Author :
     * @Description : 查询所有试卷名称总数
     * @Date : 2020/4/1 16:34
     * @Return :
     **/
    int selectTestPaperNameCount(@Param("request") ExamTestPaperNameRequest request);

    /**
     * @param examTestPaperContentRequest
     * @Author :
     * @Description : 保存试卷内容
     * @Date : 2020/4/1 12:01
     * @Return :
     **/
    int insertTestPaperContent(@Param("examTestPaperContent") List<ExamTestPaperContentRequest> examTestPaperContentRequest);

    /**
     * @param id
     * @Author :
     * @Description : 查询试卷详情
     * @Date : 2020/4/1 13:33
     * @Return :
     **/
    List<ExamTestPaperVO> selectTestPaperById(@Param("id") Long id);

    List<ExamTestPaperVO> selectTestPaperInfo(@Param("id") Long id);

    /**
     * @param examTestPaperNameRequest
     * @Author :
     * @Description : 修改试卷名称
     * @Date : 2020/4/1 13:52
     * @Return :
     **/
    int updateTestPaperNameById(@Param("examTestPaperNameRequest") ExamTestPaperNameRequest examTestPaperNameRequest);

    /**
     * @param examTestPaperContentRequest
     * @Author :
     * @Description :  修改试卷内容
     * @Date : 2020/4/1 14:35
     * @Return :
     **/
    int updateTestPaperContentById(@Param("examTestPaperContentRequest") List<ExamTestPaperContentRequest> examTestPaperContentRequest);

    /**
     * @param ids
     * @Author :
     * @Description : 批量删除试卷名称
     * @Date : 2020/4/1 16:53
     * @Return :
     **/
    int batchDelTestPaperNameById(@Param("ids") List<Long> ids);

    /**
     * @param ids
     * @Author :
     * @Description : 查询试卷被考试次数
     * @Date : 2020/4/2 15:37
     * @Return :
     **/
    int selectTestPaperExamCount(@Param("ids") List<Long> ids);

    /**
     * @param ids
     * @Author :
     * @Description : 查询试卷被报名考试的次数
     * @Date : 2020/4/2 15:58
     * @Return :
     **/
    int selectTestPaperContentExamCount(@Param("ids") List<Long> ids);

    /**
     * @param testPaperNameId
     * @Author :
     * @Description : 查询试卷内容主键
     * @Date : 2020/4/3 9:07
     * @Return :
     **/
    List<Long> selectTestPaperIds(@Param("testPaperNameId") Long testPaperNameId);

    /**
     * @param ids
     * @Author :
     * @Description : 批量删除试卷内容
     * @Date : 2020/4/3 9:19
     * @Return :
     **/
    int batchDelTestPaperContent(@Param("ids") List<Long> ids);

    int selectTestPaperCount(@Param("testPaperNameId") Long testPaperNameId);

    int selectTestPaperCounts(@Param("testPaperNameId") List<Long> testPaperNameId);

    int selectExamCount(@Param("testPaperNameId")List<Long> testPaperNameId);

}
