package com.exam.exam_system.service.ExamService;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.mapper.exammapper.ExamMapper;
import com.exam.exam_system.mapper.examtypemapper.ExamTypeMapper;
import com.exam.exam_system.pojo.request.ExamRequest;
import com.exam.exam_system.pojo.response.ExamVO;
import com.exam.exam_system.pojo.response.UserVO;
import com.exam.exam_system.service.subjectservice.SubjectService;
import com.exam.exam_system.service.userservice.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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
     * @Description : 报名参加考试
     * @Date : 2020/3/26 15:23
     * @Return :
     **/
    public int saveExam(ExamRequest examRequest) {
        //通过选中的考试类型找出此次考试类型中包含的科目
        String subject = examTypeMapper.selectEaxmSubjectById(examRequest.getExamTypeId());
        examRequest.setSubjectId(subject);
        examRequest.setStatus(1);
        return examMapper.insert(examRequest);
    }

    /**
     * @param examRequest
     * @Author :
     * @Description : 查询所有考试
     * @Date : 2020/3/26 16:14
     * @Return :
     **/
    public PageResult<List<ExamVO>> getExamAll(PageRequest<ExamRequest> examRequest) {
        List<ExamVO> examVOS = examMapper
                .selectExamAll(examRequest.getObj(), examRequest.getOffset(), examRequest.getLimit());
        if (CollectionUtils.isNotEmpty(examVOS)) {
            for (ExamVO examVO : examVOS) {
                List<String> subjectIdList = new ArrayList<>();
                String subjectId = examVO.getSubjectId();
                if (subjectId.contains(",")) {
                    String[] subjectIds = subjectId.split(",");
                    subjectIdList = Arrays.asList(subjectIds);
                    List<String> subjectName = subjectService.batchGetSubjectName(subjectIdList);
                    examVO.setSubjectName(subjectName);
                } else {
                    subjectIdList.add(examVO.getSubjectId());
                    List<String> subjectName = subjectService.batchGetSubjectName(subjectIdList);
                    examVO.setSubjectName(subjectName);
                }
            }
        }
        int count = examMapper.selectExamCount(examRequest.getObj());
        return new PageResult<List<ExamVO>>(examRequest.getPageNo(), examRequest.getPageSize(), count, examVOS);
    }
}
