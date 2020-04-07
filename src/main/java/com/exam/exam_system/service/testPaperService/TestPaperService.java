package com.exam.exam_system.service.testPaperService;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.exception.ExamException;
import com.exam.exam_system.exception.TestPaperException;
import com.exam.exam_system.mapper.testPaperMapper.TestPaperMapper;
import com.exam.exam_system.mapper.timemapper.TimeMapper;
import com.exam.exam_system.pojo.request.ExamTestPaperContentRequest;
import com.exam.exam_system.pojo.request.ExamTestPaperNameRequest;
import com.exam.exam_system.pojo.response.ExamTestPaperNameVO;
import com.exam.exam_system.pojo.response.ExamTestPaperVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author :
 * @ClassName : TestPaperService
 * @Description :
 * @Date : 2020/4/1 10:34
 */
@Transactional
@Service
public class TestPaperService {
    private TestPaperMapper testPaperMapper;
    private TimeMapper timeMapper;

    @Autowired
    public TestPaperService(TestPaperMapper testPaperMapper, TimeMapper timeMapper) {
        this.testPaperMapper = testPaperMapper;
        this.timeMapper = timeMapper;
    }

    /**
     * @param examTestPaperRequest
     * @Author :添加试卷名称名称
     * @Description :
     * @Date : 2020/4/1 10:46
     * @Return :
     **/
    public int addTestPaper(ExamTestPaperNameRequest examTestPaperRequest) {
        examTestPaperRequest.setStatus(1);
        return testPaperMapper.addTestPaperName(examTestPaperRequest);
    }

    /**
     * @param
     * @Author :
     * @Description : 查询所有试卷名称
     * @Date : 2020/4/1 11:44
     * @Return :
     **/
    public PageResult<List<ExamTestPaperNameVO>> findTestPaperNameAll(PageRequest<ExamTestPaperNameRequest> request) {
        List<ExamTestPaperNameVO> examTestPaperNameVOS = testPaperMapper
                .selectTestPaperNameAll(request.getObj(), request.getOffset(), request.getLimit());
        int count = testPaperMapper.selectTestPaperNameCount(request.getObj());
        return new PageResult<List<ExamTestPaperNameVO>>(request.getPageNo(), request.getPageSize(), count, examTestPaperNameVOS);
    }

    /**
     * @param examTestPaperContentRequest
     * @Author :
     * @Description : 保存试卷内容
     * @Date : 2020/4/1 12:00
     * @Return :
     **/
    public int addTestPaperContent(List<ExamTestPaperContentRequest> examTestPaperContentRequest) {
        Long testPaperNameId = examTestPaperContentRequest.get(0).getTestPaperNameId();
        int count = testPaperMapper.selectTestPaperCount(testPaperNameId);
        if (1 <= count) {
            throw new TestPaperException(ErrorMsgEnum.EXAM_UNDERWAY);
        }
        int delLine = 0;
        int insertLine = 0;
        List<Long> ids = testPaperMapper.selectTestPaperIds(testPaperNameId);
        if (CollectionUtils.isNotEmpty(ids)) {
            delLine = testPaperMapper.batchDelTestPaperContent(ids);
            if (delLine == ids.size()) {
                insertLine = testPaperMapper.insertTestPaperContent(examTestPaperContentRequest);
            } else {
                throw new TestPaperException(ErrorMsgEnum.SAVE_ERROR);
            }
        }
        return insertLine;
    }

    /**
     * @param id
     * @Author :
     * @Description : 查询试卷详情
     * @Date : 2020/4/1 13:31
     * @Return :
     **/
    public List<ExamTestPaperVO> findTestPaperById(Long id) {
        return testPaperMapper.selectTestPaperById(id);
    }

    /**
     * @param examTestPaperNameRequest
     * @Author :
     * @Description : 修改试卷
     * @Date : 2020/4/1 13:51
     * @Return :
     **/
    public int updateTestPaperNameById(ExamTestPaperNameRequest examTestPaperNameRequest) {
        List<Long> ids = new ArrayList<Long>(1);
        ids.add(examTestPaperNameRequest.getId());
        int count = testPaperMapper.selectTestPaperExamCount(ids);
        if (1 <= count) {
            throw new ExamException(ErrorMsgEnum.TESTPAPER_ALREADY_APPLY);
        }
        examTestPaperNameRequest.setModifyTime(timeMapper.getTime());
        return testPaperMapper.updateTestPaperNameById(examTestPaperNameRequest);
    }

    /**
     * @param testPaperContentRequest
     * @Author :
     * @Description : 修改试卷内容
     * @Date : 2020/4/1 14:33
     * @Return :
     **/
    public int updateTestPaperContentById(List<ExamTestPaperContentRequest> testPaperContentRequest) {
        Date time = timeMapper.getTime();
        List<Long> ids = new ArrayList<Long>();
        for (ExamTestPaperContentRequest examTestPaperContentRequest : testPaperContentRequest) {
            examTestPaperContentRequest.setModifyTime(time);
            ids.add(examTestPaperContentRequest.getId());
        }
        int count = testPaperMapper.selectTestPaperContentExamCount(ids);
        if (1 <= count) {
            throw new ExamException(ErrorMsgEnum.TESTPAPER_ALREADY_APPLY);
        }
        return testPaperMapper.updateTestPaperContentById(testPaperContentRequest);
    }

    /**
     * @param ids
     * @Author :
     * @Description : 批量删除试卷名称
     * @Date : 2020/4/1 16:53
     * @Return :
     **/
    public int batchDelTestPaperNameById(List<Long> ids) {
        int count = testPaperMapper.selectTestPaperContentExamCount(ids);
        if (1 <= count) {
            throw new ExamException(ErrorMsgEnum.TESTPAPER_ALREADY_APPLY);
        }
        return testPaperMapper.batchDelTestPaperNameById(ids);
    }
}
