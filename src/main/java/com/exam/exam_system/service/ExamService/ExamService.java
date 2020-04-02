package com.exam.exam_system.service.ExamService;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.mapper.exammapper.ExamMapper;
import com.exam.exam_system.mapper.examtypemapper.ExamTypeMapper;
import com.exam.exam_system.pojo.ExamPojo;
import com.exam.exam_system.pojo.request.ExamAllRequet;
import com.exam.exam_system.pojo.request.ExamRequest;
import com.exam.exam_system.service.subjectservice.SubjectService;
import com.exam.exam_system.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamService
 * @Description :
 * @Date : 2020/3/26 15:20
 */
@Transactional
@Service
public class ExamService {
    private ExamMapper examMapper;
    private ExamTypeMapper examTypeMapper;
    private SubjectService subjectService;
    private UserService userService;

    @Autowired
    public ExamService(ExamMapper examMapper, ExamTypeMapper examTypeMapper, SubjectService subjectService, UserService userService) {
        this.examMapper = examMapper;
        this.examTypeMapper = examTypeMapper;
        this.subjectService = subjectService;
        this.userService = userService;
    }

    /**
     * @param examRequest
     * @Author :
     * @Description : 发布考试
     * @Date : 2020/4/1 16:46
     * @Return :
     **/
    public int addExam(ExamRequest examRequest) {
        examRequest.setStatus(1);
        return examMapper.insertExam(examRequest);
    }

    /**
     * @param ids
     * @Author :
     * @Description :  批量删除考试
     * @Date : 2020/4/1 17:29
     * @Return :
     **/
    public int batchDelExamById(List<Long> ids) {
        return examMapper.batchDelExamById(ids);
    }

    /**
     * @param examAllRequet
     * @Author :
     * @Description : 考试列表
     * @Date : 2020/4/2 9:39
     * @Return :
     **/
    public PageResult<List<ExamPojo>> findExamAll(PageRequest<ExamAllRequet> examAllRequet) {
        List<ExamPojo> examPojos = examMapper.selectExamAll(examAllRequet.getObj(), examAllRequet.getOffset(), examAllRequet.getLimit());
        int count = examMapper.selectExamAllCount(examAllRequet.getObj());
        return new PageResult<List<ExamPojo>>(examAllRequet.getPageNo(),examAllRequet.getPageSize(),count,examPojos);
    }
}
