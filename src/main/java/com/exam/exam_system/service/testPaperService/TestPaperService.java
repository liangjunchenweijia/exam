package com.exam.exam_system.service.testPaperService;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.mapper.testPaperMapper.TestPaperMapper;
import com.exam.exam_system.mapper.timemapper.TimeMapper;
import com.exam.exam_system.pojo.request.ExamTestPaperContentRequest;
import com.exam.exam_system.pojo.request.ExamTestPaperNameRequest;
import com.exam.exam_system.pojo.response.ExamTestPaperNameVO;
import com.exam.exam_system.pojo.response.ExamTestPaperVO;
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
        return new PageResult<List<ExamTestPaperNameVO>>(request.getPageNo(),request.getPageSize(),count,examTestPaperNameVOS);
    }

    /**
     * @param examTestPaperContentRequest
     * @Author :
     * @Description : 保存试卷内容
     * @Date : 2020/4/1 12:00
     * @Return :
     **/
    public int addTestPaperContent(List<ExamTestPaperContentRequest> examTestPaperContentRequest) {
        return testPaperMapper.insertTestPaperContent(examTestPaperContentRequest);
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
        return testPaperMapper.updateTestPaperContentById(testPaperContentRequest);
    }
}
