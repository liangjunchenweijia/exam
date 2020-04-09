package com.exam.exam_system.controller.applyExamController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.common.config.annotation.LoginUser;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.exception.ExamException;
import com.exam.exam_system.exception.TestPaperException;
import com.exam.exam_system.pojo.ApplyExamPojo;
import com.exam.exam_system.pojo.LoginUserPojo;
import com.exam.exam_system.pojo.StuExamPojo;
import com.exam.exam_system.pojo.request.ApplyExamRequest;
import com.exam.exam_system.pojo.response.ApplyExamResponse;
import com.exam.exam_system.service.applyExamService.ApplyExamService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author :
 * @ClassName : ApplyExamController
 * @Description : 报名考试控制器
 * @Date : 2020/4/2 16:21
 */
@RestController
@RequestMapping("applyExam")
public class ApplyExamController extends BaseController {
    private ApplyExamService applyExamService;

    @Autowired
    public ApplyExamController(ApplyExamService applyExamService) {
        this.applyExamService = applyExamService;
    }

    /**
     * @param applyExamRequest
     * @Author :
     * @Description : 考试列表
     * @Date : 2020/4/7 9:29
     * @Return :
     **/
    @PostMapping("/queryStuExamAll")
    public PageResult<List<StuExamPojo>> queryStuExamAll(@RequestBody PageRequest<ApplyExamRequest> applyExamRequest) {
        logger.info("考试列表:{}", JSON.toJSONString(applyExamRequest));
        PageResult<List<StuExamPojo>> stuExamAll = applyExamService.findStuExamAll(applyExamRequest);
        logger.info("考试列表返回:{}", JSON.toJSONString(stuExamAll));
        return new PageResult<List<StuExamPojo>>(stuExamAll.getPageNo()
                , stuExamAll.getPageSize(), stuExamAll.getTotal(), stuExamAll.getObj());
    }

    /**
     * @param applyExamPojo
     * @param userLogin
     * @Author :
     * @Description : 开始考试
     * @Date : 2020/4/8 14:14
     * @Return :
     **/
    @PostMapping("/saveApplyExam")
    public Result<Object> saveApplyExam(@RequestBody ApplyExamPojo applyExamPojo
            , @LoginUser LoginUserPojo userLogin) {
        logger.info("开始考试:applyExamRequest{},userLogin{}", JSON.toJSONString(applyExamPojo)
                , JSON.toJSONString(userLogin));
        if (CollectionUtils.isEmpty(applyExamPojo.getStuExamRequests()) || null == userLogin || null == applyExamPojo) {
            return new Result<Object>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode(), ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        //开始保存
        try {
            applyExamService.addApplyExam(applyExamPojo, userLogin);
        } catch (ExamException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }

    /**
     * @param id
     * @Author :
     * @Description : 查询考试规则
     * @Date : 2020/4/8 14:32
     * @Return :
     **/
    @GetMapping("/queryExamRule")
    public Result<ApplyExamResponse> queryExamRule(Long id) {
        logger.info("查询考试规则:{}", id);
        ApplyExamResponse examRule = null;
        if (null == id) {
            return new Result<ApplyExamResponse>(ErrorMsgEnum.PARAMETER_EXCEPTION.getCode()
                    , ErrorMsgEnum.PARAMETER_EXCEPTION.getMsg());
        }
        try {
            examRule = applyExamService.findExamRule(id);
        } catch (TestPaperException e) {
            return new Result<ApplyExamResponse>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        logger.info("查询考试规则返回:{}", JSON.toJSONString(examRule));
        return new Result<ApplyExamResponse>(examRule);
    }


}
