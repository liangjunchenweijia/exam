package com.exam.exam_system.controller.applyExamController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.pojo.StuExamPojo;
import com.exam.exam_system.pojo.request.ApplyExamRequest;
import com.exam.exam_system.service.applyExamService.ApplyExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}
