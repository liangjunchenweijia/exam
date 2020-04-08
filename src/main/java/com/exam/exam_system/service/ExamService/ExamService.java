package com.exam.exam_system.service.ExamService;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.exception.ExamException;
import com.exam.exam_system.mapper.exammapper.ExamMapper;
import com.exam.exam_system.mapper.examtypemapper.ExamTypeMapper;
import com.exam.exam_system.pojo.ExamPojo;
import com.exam.exam_system.pojo.request.ExamAllRequest;
import com.exam.exam_system.pojo.request.ExamRequest;
import com.exam.exam_system.service.subjectservice.SubjectService;
import com.exam.exam_system.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        Long examTypeId = examRequest.getExamTypeId();
        Long examTestPaperId = examRequest.getExamTestPaperId();
        int count = examMapper.selectExamCount(examTypeId, examTestPaperId);
        if (1 <= count) {
            throw new ExamException(ErrorMsgEnum.EXAM_ALREADY_EXISTED);
        }
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
        int count = examMapper.selectApplyExamCount(ids);
        if (1 <= count) {
            throw new ExamException(ErrorMsgEnum.LOGIN_AGAIN);
        }
        return examMapper.batchDelExamById(ids);
    }

    /**
     * @param examAllRequest
     * @Author :
     * @Description : 考试列表
     * @Date : 2020/4/2 9:39
     * @Return :
     **/
    public PageResult<List<ExamPojo>> findExamAll(PageRequest<ExamAllRequest> examAllRequest) {
        List<ExamPojo> examPojos = examMapper.selectExamAll(examAllRequest.getObj(), examAllRequest.getOffset(), examAllRequest.getLimit());
        int count = examMapper.selectExamAllCount(examAllRequest.getObj());
        return new PageResult<List<ExamPojo>>(examAllRequest.getPageNo(), examAllRequest.getPageSize(), count, examPojos);
    }

    /**
     * @param examRequest
     * @Author :
     * @Description :  修改考试
     * @Date : 2020/4/2 14:45
     * @Return :
     **/
    public int updateExamById(ExamRequest examRequest) {
        List<Long> ids = new ArrayList<Long>(1);
        Long id = examRequest.getId();
        ids.add(id);
        int count = examMapper.selectApplyExamCount(ids);
        if (1 <= count) {
            throw new ExamException(ErrorMsgEnum.EXAM_ALREADY_APPLY);
        }
        return examMapper.updateExamById(examRequest);
    }
}
