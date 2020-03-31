package com.exam.exam_system.service.subjectservice;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.common.enums.ErrorMsgEnum;
import com.exam.exam_system.exception.SubjectException;
import com.exam.exam_system.mapper.subjectmapper.SubjectMapper;
import com.exam.exam_system.mapper.timemapper.TimeMapper;
import com.exam.exam_system.pojo.request.SubjectRequest;
import com.exam.exam_system.pojo.response.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author :
 * @ClassName : SubjectService
 * @Description :
 * @Date : 2020/3/23 19:53
 */
@Transactional
@Service
public class SubjectService {
    private SubjectMapper subjectMapper;

    private TimeMapper timeMapper;

    @Autowired
    public SubjectService(SubjectMapper subjectMapper, TimeMapper timeMapper) {
        this.subjectMapper = subjectMapper;
        this.timeMapper = timeMapper;
    }

    /**
     * @param subjectRequest
     * @Author :
     * @Description : 添加学科
     * @Date : 2020/3/23 19:54
     * @Return : 返回影响行数
     **/
    public int addSubject(SubjectRequest subjectRequest) {
        //学科状态(默认可用)
        subjectRequest.setSubjectStatus(1);
        SubjectVO subjectVO = subjectMapper.checkSubjectName(subjectRequest.getSubjectName());
        if (null != subjectVO) {
            throw new SubjectException(ErrorMsgEnum.SUBJECTNAME_ALREADY_EXISTED);
        }
        return subjectMapper.insert(subjectRequest);
    }

    /**
     * @param
     * @Author :
     * @Description : 查询所有学科
     * @Date : 2020/3/24 9:20
     * @Return :
     **/
    public PageResult<List<SubjectVO>> findSubjectAll(PageRequest<SubjectRequest> subjectRequest) {
        List<SubjectVO> subjectVOS = subjectMapper
                .selectSubjectInfo(subjectRequest.getObj(), subjectRequest.getOffset(), subjectRequest.getLimit());
        int count = subjectMapper.selectSubjectCount(subjectRequest.getObj());
        return new PageResult<List<SubjectVO>>(subjectRequest.getPageNo(), subjectRequest.getPageSize(), count, subjectVOS);
    }

    /**
     * @param subjectRequest
     * @Author :
     * @Description :
     * @Date : 2020/3/24 9:49
     * @Return :
     **/
    public int modifySubjectById(SubjectRequest subjectRequest) {
        SubjectVO subjectVO = subjectMapper.checkSubjectName(subjectRequest.getSubjectName());
        if (null != subjectVO && !subjectRequest.getId().equals(subjectVO.getId())) {
            throw new SubjectException(ErrorMsgEnum.SUBJECTNAME_ALREADY_EXISTED);
        }
        subjectRequest.setModifyTime(timeMapper.getTime());
        return subjectMapper.updateByPrimaryKeySelective(subjectRequest);
    }

    /**
     * @param subjectRequest
     * @Author :
     * @Description : 批量修改学科状态
     * @Date : 2020/3/24 10:06
     * @Return :
     **/
    public int batchModifySubjectStatusById(SubjectRequest subjectRequest) {
        List<Long> ids = subjectRequest.getIds();
        Integer subjectStatus = subjectRequest.getSubjectStatus();
        subjectRequest.setModifyTime(timeMapper.getTime());
        return subjectMapper.batchUpdateSubjectStatusById(ids, subjectStatus, subjectRequest.getModifyTime());
    }

    /**
     * @param id
     * @Author :
     * @Description : 批量查询学科名称
     * @Date : 2020/3/26 14:36
     * @Return :
     **/
    public List<String> batchGetSubjectName(List<String> id) {
        return subjectMapper.batchSelectSubjectName(id);
    }

}
