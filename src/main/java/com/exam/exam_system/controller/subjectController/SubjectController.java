package com.exam.exam_system.controller.subjectController;

import com.alibaba.fastjson.JSON;
import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.Result;
import com.exam.exam_system.controller.BaseController;
import com.exam.exam_system.exception.SubjectException;
import com.exam.exam_system.pojo.request.SubjectRequest;
import com.exam.exam_system.pojo.response.SubjectVO;
import com.exam.exam_system.service.subjectservice.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author :
 * @ClassName : SubjectController
 * @Description : 学科控制器
 * @Date : 2020/3/23 19:44
 */
@RestController
@RequestMapping("/subject")
public class SubjectController extends BaseController {
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     * @param subjectRequest
     * @Author :
     * @Description : 添加学科
     * @Date : 2020/3/23 19:46
     * @Return :
     **/
    @PostMapping("/saveSubject")
    public Result<Object> saveSubject(@RequestBody SubjectRequest subjectRequest) {
        logger.info("添加学科:{}", JSON.toJSONString(subjectRequest));
        try {
            subjectService.addSubject(subjectRequest);
        } catch (SubjectException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }

    /**
     * @param
     * @Author :
     * @Description : 查询所有学科
     * @Date : 2020/3/24 9:19
     * @Return :
     **/
    @PostMapping("/querySubjectAll")
    public PageResult<List<SubjectVO>> querySubjectAll(@RequestBody PageRequest<SubjectRequest> subjectRequest) {
        logger.info("查询所有学科：{}", JSON.toJSONString(subjectRequest));
        PageResult<List<SubjectVO>> subjectAll = subjectService.findSubjectAll(subjectRequest);
        logger.info("查询所有学科返回:{}", JSON.toJSONString(subjectAll));
        return new PageResult<>(subjectAll.getPageNo(), subjectAll.getPageSize(), subjectAll.getTotal(), subjectAll.getObj());
    }

    /**
     * @param subjectRequest
     * @Author :
     * @Description : 修改学科
     * @Date : 2020/3/24 9:42
     * @Return :
     **/
    @PostMapping("/modifySubject")
    public Result<Object> modifySubject(@RequestBody SubjectRequest subjectRequest) {
        logger.info("修改学科：{}", JSON.toJSONString(subjectRequest));
        try {
            subjectService.modifySubjectById(subjectRequest);
        } catch (SubjectException e) {
            return new Result<Object>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        return new Result<Object>();
    }

    /**
     * @param subjectRequest
     * @Author :
     * @Description : 批量修改学科状态
     * @Date : 2020/3/24 9:59
     * @Return :
     **/
    @PostMapping("/batchModifySubjectStatus")
    public Result<Object> batchModifySubjectStatus(@RequestBody SubjectRequest subjectRequest) {
        logger.info("批量修改学科状态：{}", JSON.toJSONString(subjectRequest));
        subjectService.batchModifySubjectStatusById(subjectRequest);
        return new Result<Object>();
    }

}
