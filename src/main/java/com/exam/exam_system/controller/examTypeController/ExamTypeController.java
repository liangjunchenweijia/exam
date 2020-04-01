package com.exam.exam_system.controller.examTypeController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.exception.ExamTypeException;
import com.exam.exam_system.pojo.request.ExamTypeRequest;
import com.exam.exam_system.pojo.response.ExamTypeVO;
import com.exam.exam_system.service.examTypeService.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author :
 * @ClassName : ExamTypeController
 * @Description : 考试类型控制器
 * @Date : 2020/3/24 15:19
 */
@RestController
@RequestMapping("/examtype")
public class ExamTypeController extends BaseController {

    private ExamTypeService examTypeService;

    @Autowired
    public ExamTypeController(ExamTypeService examTypeService) {
        this.examTypeService = examTypeService;
    }

    /**
     * @param examTypeRequest
     * @Author :
     * @Description : 添加考试类型
     * @Date : 2020/3/24 15:26
     * @Return :
     **/
    @PostMapping("/saveExamType")
    public Result<Object> saveExamType(@RequestBody ExamTypeRequest examTypeRequest) {
        logger.info("添加考试类型:{}", JSON.toJSONString(examTypeRequest));
        try {
            examTypeService.addExamType(examTypeRequest);
        } catch (ExamTypeException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }

    /**
     * @param id
     * @Author :
     * @Description : 通过唯一编号查询考试类型详情
     * @Date : 2020/4/1 9:17
     * @Return :
     **/
    @GetMapping("/queryExamTypeById")
    public Result<ExamTypeVO> queryExamTypeById(Long id) {
        ExamTypeVO examType = examTypeService.findExamTypeById(id);
        return new Result<ExamTypeVO>(examType);
    }

    /**
     * @param examTypeRequest
     * @Author :
     * @Description : 修改考试类型
     * @Date : 2020/3/24 15:54
     * @Return :
     **/
    @PostMapping("/modifyExamType")
    public Result<Object> modifyExamType(@RequestBody ExamTypeRequest examTypeRequest) {
        logger.info("修改考试类型:{}", JSON.toJSONString(examTypeRequest));
        examTypeService.modifyExamTypeById(examTypeRequest);
        return new Result<Object>();
    }

    /**
     * @Author :
     * @Description : 查询考试类型(分页)
     * @Date : 2020/3/24 16:16
     * @Return :
     **/
    @PostMapping("/queryExamTypeAll")
    public Result<List<ExamTypeVO>> queryExamTypeAll() {
        List<ExamTypeVO> examTypeAll = examTypeService.findExamTypeAll();
        logger.info("查询考试类型返回:{}", JSON.toJSONString(examTypeAll));
        return new Result<List<ExamTypeVO>>(examTypeAll);
    }

}
