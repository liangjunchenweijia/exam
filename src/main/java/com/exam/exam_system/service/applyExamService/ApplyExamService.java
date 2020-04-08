package com.exam.exam_system.service.applyExamService;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.exception.TestPaperException;
import com.exam.exam_system.mapper.applyExamMapper.ApplyExamMapper;
import com.exam.exam_system.mapper.timemapper.TimeMapper;
import com.exam.exam_system.pojo.StuExamPojo;
import com.exam.exam_system.pojo.request.ApplyExamRequest;
import com.exam.exam_system.pojo.response.ApplyExamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
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

    private TimeMapper timeMapper;

    @Autowired
    public ApplyExamService(ApplyExamMapper applyExamMapper, TimeMapper timeMapper) {
        this.applyExamMapper = applyExamMapper;
        this.timeMapper = timeMapper;
    }

    /**
     * @param applyExamRequest
     * @Author :
     * @Description : 报名考试
     * @Date : 2020/4/7 9:29
     * @Return :
     **/
//    public int addApplyExam(ApplyExamRequest applyExamRequest) {
//        applyExamMapper.insertApplyExam(applyExamRequest);
//        return 0;
//    }

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
        return new PageResult<List<StuExamPojo>>(applyExamRequest.getPageNo(), applyExamRequest.getPageSize(), count, stuExamPojoList);
    }

    /**
     * @param id
     * @Author :
     * @Description : 查询考试规则
     * @Date : 2020/4/8 14:34
     * @Return :
     **/
    public ApplyExamResponse findExamRule(Long id) {
        ApplyExamResponse applyExamResponse = applyExamMapper.selectExamRule(id);
        if (null != applyExamResponse) {
            Date startTime = applyExamResponse.getStartTime();
            Date endTime = applyExamResponse.getEndTime();
            Calendar nowDate = Calendar.getInstance();
            nowDate.setTime(timeMapper.getTime());
            Calendar startDate = Calendar.getInstance();
            startDate.setTime(startTime);
            Calendar endDate = Calendar.getInstance();
            endDate.setTime(endTime);
            if (nowDate.compareTo(startDate) == -1) {
                throw new TestPaperException(ErrorMsgEnum.EXAM_HAVE_NOT_STARTED);
            }

            if (nowDate.compareTo(endDate) == 1) {
                throw new TestPaperException(ErrorMsgEnum.EXAM_FINISHED);
            }

            long start = startTime.getTime();
            long end = endTime.getTime();
            String time = String.valueOf((end - start) / (1000 * 60));
            applyExamResponse.setMinute(time);
        }
        return applyExamResponse;
    }
}
