package com.exam.exam_system.mapper.subjectmapper;

import com.exam.exam_system.pojo.request.SubjectRequest;
import com.exam.exam_system.pojo.response.SubjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author :
 * @ClassName : SubjectMapper
 * @Description :
 * @Date : 2020/3/23 19:55
 */
public interface SubjectMapper {

    /**
     * @param subjectRequest
     * @Author :
     * @Description : 添加学科
     * @Date : 2020/3/23 19:55
     * @Return : 返回 影响行数
     **/
    int insert(@Param("subjectRequest") SubjectRequest subjectRequest);

    /**
     * @param request
     * @param offset
     * @param limit
     * @Author :
     * @Description : 查询学科
     * @Date : 2020/3/24 9:25
     * @Return :
     **/
    List<SubjectVO> selectSubjectInfo(@Param("request") SubjectRequest request, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * @param request
     * @Author :
     * @Description : 学科总数
     * @Date : 2020/3/24 9:31
     * @Return :
     **/
    int selectSubjectCount(@Param("request") SubjectRequest request);

    /**
     * @param subjectRequest 唯一编号
     * @Author :
     * @Description :  修改学科
     * @Date : 2020/3/24 9:51
     * @Return :
     **/
    int updateByPrimaryKeySelective(@Param("request") SubjectRequest subjectRequest);

    /**
     * @param ids
     * @Author :
     * @Description : 批量修改学科状态
     * @Date : 2020/3/24 10:08
     * @Return :
     **/
    int batchUpdateSubjectStatusById(@Param("ids") List<Long> ids, @Param("subjectStatus") Integer subjectStatus, @Param("modifyTime") Date modifyTime);

    /**
     * @param id
     * @Author :
     * @Description : 批量查询学科姓名
     * @Date : 2020/3/26 14:37
     * @Return :
     **/
    List<String> batchSelectSubjectName(@Param("id") List<String> id);

    /**
     * @param subjectName
     * @Author :
     * @Description : 校验学科名称
     * @Date : 2020/3/31 13:30
     * @Return :
     **/
    SubjectVO checkSubjectName(@Param("subjectName") String subjectName);

}
