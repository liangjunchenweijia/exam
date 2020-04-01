package com.exam.exam_system.controller.testpaperController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.pojo.request.ExamTestPaperNameRequest;
import com.exam.exam_system.pojo.request.ExamTestPaperRequest;
import com.exam.exam_system.pojo.response.ExamTestPaperNameVO;
import com.exam.exam_system.pojo.response.ExamTestPaperVO;
import com.exam.exam_system.service.testPaperService.TestPaperService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author :
 * @ClassName : TestPaperController
 * @Description : 试卷控制器
 * @Date : 2020/4/1 10:17
 */
@RequestMapping("/testPaper")
@RestController
public class TestPaperController extends BaseController {

    private TestPaperService testPaperService;

    @Autowired
    public TestPaperController(TestPaperService testPaperService) {
        this.testPaperService = testPaperService;
    }

    /**
     * @param examTestPaperRequest
     * @Author :
     * @Description : 保存试卷
     * @Date : 2020/4/1 10:36
     * @Return :
     **/
    @PostMapping("/saveTestPaper")
    public Result<Object> saveTestPaper(@RequestBody ExamTestPaperNameRequest examTestPaperRequest) {
        logger.info("保存试卷:{}", JSON.toJSONString(examTestPaperRequest));
        if (null == examTestPaperRequest) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        testPaperService.addTestPaper(examTestPaperRequest);
        return new Result<Object>();
    }

    /**
     * @param
     * @Author :
     * @Description : 查询所有试卷名称
     * @Date : 2020/4/1 11:42
     * @Return :
     **/
    @PostMapping("/queryTestPaperNameAll")
    public PageResult<List<ExamTestPaperNameVO>> queryTestPaperNameAll(@RequestBody PageRequest<ExamTestPaperNameRequest> request) {
        PageResult<List<ExamTestPaperNameVO>> testPaperNameAll = testPaperService.findTestPaperNameAll(request);
        logger.info("查询所有试卷名称返回:{}", JSON.toJSONString(testPaperNameAll));
        return new PageResult<List<ExamTestPaperNameVO>>(testPaperNameAll.getPageNo(), testPaperNameAll.getPageSize(), testPaperNameAll.getTotal(), testPaperNameAll.getObj());
    }

    /**
     * @param ExamTestPaperRequest
     * @Author :
     * @Description : 保存试卷内容
     * @Date : 2020/4/1 11:53
     * @Return :
     **/
    @PostMapping("/saveTestPaperContent")
    public Result<Object> saveTestPaperContent(@RequestBody ExamTestPaperRequest ExamTestPaperRequest) {
        if (null == ExamTestPaperRequest || CollectionUtils.isEmpty(ExamTestPaperRequest.getExamTestPaperContentRequests())) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        logger.info("保存试卷内容:{}", JSON.toJSONString(ExamTestPaperRequest));
        testPaperService.addTestPaperContent(ExamTestPaperRequest.getExamTestPaperContentRequests());
        return new Result<Object>();
    }

    /**
     * @param id
     * @Author :
     * @Description : 查询试卷详情
     * @Date : 2020/4/1 13:30
     * @Return :
     **/
    @GetMapping("/queryTestPaperById")
    public Result<List<ExamTestPaperVO>> queryTestPaperById(Long id) {
        if (null == id) {
            return new Result<List<ExamTestPaperVO>>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        List<ExamTestPaperVO> testPapers = testPaperService.findTestPaperById(id);
        logger.info("查询试卷详情返回:{}", JSON.toJSONString(testPapers));
        return new Result<List<ExamTestPaperVO>>(testPapers);
    }

    /**
     * @param examTestPaperNameRequest
     * @Author :
     * @Description : 修改试卷
     * @Date : 2020/4/1 13:50
     * @Return :
     **/
    @PostMapping("/modifyTestPaperNameById")
    public Result<Object> modifyTestPaperNameById(@RequestBody ExamTestPaperNameRequest examTestPaperNameRequest) {
        logger.info("修改试卷名称:{}", JSON.toJSONString(examTestPaperNameRequest));
        testPaperService.updateTestPaperNameById(examTestPaperNameRequest);
        return new Result<Object>();
    }

    /**
     * @param examTestPaperRequest
     * @Author :
     * @Description : 批量修改试卷内容
     * @Date : 2020/4/1 14:29
     * @Return :
     **/
    @PostMapping("/modifyTestPaperContentById")
    public Result<Object> modifyTestPaperContentById(@RequestBody ExamTestPaperRequest examTestPaperRequest) {
        logger.info("批量修改试卷内容:{}", JSON.toJSONString(examTestPaperRequest));
        if (null == examTestPaperRequest || CollectionUtils.isEmpty(examTestPaperRequest.getExamTestPaperContentRequests())) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        testPaperService.updateTestPaperContentById(examTestPaperRequest.getExamTestPaperContentRequests());
        return new Result<Object>();
    }


}
