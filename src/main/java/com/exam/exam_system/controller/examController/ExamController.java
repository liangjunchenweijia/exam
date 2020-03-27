package com.exam.exam_system.controller.examController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.common.config.annotation.LoginUser;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.pojo.LoginUserPojo;
import com.exam.exam_system.pojo.request.ExamRequest;
import com.exam.exam_system.pojo.response.ExamVO;
import com.exam.exam_system.service.ExamService.ExamService;
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
     * @Description : 报名参加考试
     * @Date : 2020/3/26 15:22
     * @Return :
     **/
    @PostMapping("/applyExam")
    public Result<Object> applyExam(@RequestBody ExamRequest examRequest, @LoginUser LoginUserPojo loginUserPojo) {
        logger.info("报名参加考试:{}", JSON.toJSONString(examRequest));
        if (null == examRequest || null == loginUserPojo) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        examRequest.setUserId(loginUserPojo.getId());
        examService.saveExam(examRequest);
        return new Result<Object>();
    }

    /**
     * @param examRequest
     * @Author :
     * @Description : 查询考试(分页)
     * @Date : 2020/3/26 16:05
     * @Return :
     **/
    @PostMapping(" queryExamAll")
    public PageResult<List<ExamVO>> queryExamAll(@RequestBody PageRequest<ExamRequest> examRequest) {
        logger.info("查询考试:{}", JSON.toJSONString(examRequest));
        PageResult<List<ExamVO>> examAll = examService.getExamAll(examRequest);
        return new PageResult<List<ExamVO>>(examAll.getPageNo(), examAll.getPageSize(), examAll.getTotal(), examAll.getObj());

    }


}
