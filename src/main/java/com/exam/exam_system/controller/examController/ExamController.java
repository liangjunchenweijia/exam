package com.exam.exam_system.controller.examController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.exception.ExamException;
import com.exam.exam_system.pojo.ExamPojo;
import com.exam.exam_system.pojo.request.ExamAllRequest;
import com.exam.exam_system.pojo.request.ExamRequest;
import com.exam.exam_system.service.ExamService.ExamService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamController
 * @Description : 考试控制器
 * @Date : 2020/3/26 15:18
 */
@RestController
@RequestMapping("/exam")
public class ExamController extends BaseController {
    private ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    /**
     * @param examRequest
     * @Author :
     * @Description :  发布考试
     * @Date : 2020/4/1 16:45
     * @Return :
     **/
    @PostMapping("/saveExam")
    public Result<Object> saveExam(@RequestBody ExamRequest examRequest) {
        logger.info("发布考试:{}", JSON.toJSONString(examRequest));
        if (null == examRequest) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        try {
            examService.addExam(examRequest);
        } catch (ExamException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }

    /**
     * @param
     * @Author :
     * @Description : 考试列表
     * @Date : 2020/4/2 9:36
     * @Return :
     **/
    @PostMapping("/queryExamAll")
    public PageResult<List<ExamPojo>> queryExamAll(@RequestBody PageRequest<ExamAllRequest> examAllRequest) {
        logger.info("考试列表:{}", JSON.toJSONString(examAllRequest));
        PageResult<List<ExamPojo>> examAll = examService.findExamAll(examAllRequest);
        logger.info("考试列表返回:{}", JSON.toJSONString(examAll));
        return new PageResult<List<ExamPojo>>(examAll.getPageNo(), examAll.getPageSize(), examAll.getTotal(), examAll.getObj());
    }

    /**
     * @param examRequest
     * @Author :
     * @Description : 批量删除考试
     * @Date : 2020/4/1 17:27
     * @Return :
     **/
    @PostMapping("/batchDelExamById")
    public Result<Object> batchDelExamById(@RequestBody ExamRequest examRequest) {
        logger.info("批量删除考试:{}", JSON.toJSONString(examRequest));
        if (null == examRequest || CollectionUtils.isEmpty(examRequest.getIds())) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        try {
            examService.batchDelExamById(examRequest.getIds());
        } catch (ExamException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }

    /**
     * @param examRequest
     * @Author :
     * @Description : 修改考试
     * @Date : 2020/4/2 14:43
     * @Return :
     **/
    @PostMapping("/modifyExam")
    public Result<Object> modifyExam(@RequestBody ExamRequest examRequest) {
        logger.info("修改考试:{}", JSON.toJSONString(examRequest));
        if (null == examRequest) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        try {
            examService.updateExamById(examRequest);
        } catch (ExamException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }


}
