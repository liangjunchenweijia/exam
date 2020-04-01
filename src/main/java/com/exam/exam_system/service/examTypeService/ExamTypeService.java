package com.exam.exam_system.service.examTypeService;

import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.exception.ExamTypeException;
import com.exam.exam_system.mapper.examtypemapper.ExamTypeMapper;
import com.exam.exam_system.mapper.timemapper.TimeMapper;
import com.exam.exam_system.pojo.request.ExamTypeRequest;
import com.exam.exam_system.pojo.response.ExamTypeVO;
import com.exam.exam_system.service.subjectservice.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamTypeService
 * @Description :
 * @Date : 2020/3/24 15:28
 */
@Transactional
@Service
public class ExamTypeService {

    private ExamTypeMapper examTypeMapper;

    private TimeMapper timeMapper;

    private SubjectService subjectService;

    @Autowired
    public ExamTypeService(ExamTypeMapper examTypeMapper, TimeMapper timeMapper, SubjectService subjectService) {
        this.examTypeMapper = examTypeMapper;
        this.timeMapper = timeMapper;
        this.subjectService = subjectService;
    }


    /**
     * @param examTypeRequest
     * @Author :
     * @Description :  添加考试类型
     * @Date : 2020/3/24 15:30
     * @Return :
     **/
    public int addExamType(ExamTypeRequest examTypeRequest) {
        String examName = examTypeRequest.getExamName();
        int count = examTypeMapper.selectExamTypeByName(examName);
        if (1 <= count) {
            throw new ExamTypeException(ErrorMsgEnum.EXAM_TYPE_NAME_ALREADY_EXISTED);
        }
        examTypeRequest.setStatus(1);
        return examTypeMapper.insert(examTypeRequest);
    }


    /**
     * @param examTypeRequest
     * @Author :
     * @Description : 修改考试类型
     * @Date : 2020/3/24 15:55
     * @Return :
     **/
    public int modifyExamTypeById(ExamTypeRequest examTypeRequest) {
        examTypeRequest.setModifyTime(timeMapper.getTime());
        return examTypeMapper.updateExamTypeById(examTypeRequest);
    }

    /**
     * @param id
     * @Author :
     * @Description : 通过唯一编号查询考试类型详情
     * @Date : 2020/4/1 9:18
     * @Return :
     **/
    public ExamTypeVO findExamTypeById(Long id) {
        return examTypeMapper.selectExamTypeById(id);
    }

    /**
     * @param
     * @Author :
     * @Description : 查询所有考试类型
     * @Date : 2020/4/1 9:22
     * @Return :
     **/
    public List<ExamTypeVO> findExamTypeAll() {
        return examTypeMapper.selectExamTypeAll();
    }
}
