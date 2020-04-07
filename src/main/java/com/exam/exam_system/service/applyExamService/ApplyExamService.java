package com.exam.exam_system.service.applyExamService;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.mapper.applyExamMapper.ApplyExamMapper;
import com.exam.exam_system.pojo.StuExamPojo;
import com.exam.exam_system.pojo.request.ApplyExamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author :
 * @ClassName : ApplyExamService
 * @Description :
 * @Date : 2020/4/2 16:22
 */
@Transactional
@Service
public class ApplyExamService {
    private ApplyExamMapper applyExamMapper;

    @Autowired
    public ApplyExamService(ApplyExamMapper applyExamMapper) {
        this.applyExamMapper = applyExamMapper;
    }

    /**
     * @param applyExamRequest
     * @Author :
     * @Description : 报名考试
     * @Date : 2020/4/7 9:29
     * @Return :
     **/
    public int addApplyExam(ApplyExamRequest applyExamRequest) {
        applyExamMapper.insertApplyExam(applyExamRequest);
        return 0;
    }

    /**
     * @param applyExamRequest
     * @Author :
     * @Description : 考试列表
     * @Date : 2020/4/7 10:15
     * @Return :
     **/
    public PageResult<List<StuExamPojo>> findStuExamAll(PageRequest<ApplyExamRequest> applyExamRequest) {
        List<StuExamPojo> stuExamPojoList = applyExamMapper
                .selectStuExamAll(applyExamRequest.getObj(), applyExamRequest.getOffset(), applyExamRequest.getLimit());
        int count = applyExamMapper.selectStuExamAllCount(applyExamRequest.getObj());
        return new PageResult<List<StuExamPojo>>(applyExamRequest.getPageNo(),applyExamRequest.getPageSize(),count,stuExamPojoList);
    }
}
