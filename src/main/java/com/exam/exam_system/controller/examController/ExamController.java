package com.exam.exam_system.controller.examController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.pojo.request.ExamRequest;
import com.exam.exam_system.service.ExamService.ExamService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        examService.addExam(examRequest);
        return new Result<Object>();
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
        examService.batchDelExamById(examRequest.getIds());
        return new Result<Object>();
    }


}
