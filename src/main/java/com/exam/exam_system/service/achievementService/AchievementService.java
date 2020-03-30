package com.exam.exam_system.service.achievementService;

import com.exam.exam_system.common.PageRequest;
import com.exam.exam_system.common.PageResult;
import com.exam.exam_system.mapper.achievementMapper.AchievementMapper;
import com.exam.exam_system.pojo.AchievementPojo;
import com.exam.exam_system.pojo.request.AchievementRequest;
import com.exam.exam_system.pojo.response.UserAchievementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AchievementService {

    private AchievementMapper achievementMapper;

    @Autowired
    public AchievementService(AchievementMapper achievementMapper) {
        this.achievementMapper = achievementMapper;
    }

    /**
     * @param achievementPojo
     * @Author :
     * @Description : 保存考试成绩
     * @Date : 2020/3/28 16:51
     * @Return :
     **/
    public int addAchievement(AchievementPojo achievementPojo) {
        return achievementMapper.insert(achievementPojo.getAchievementRequests());
    }

    /**
     * @param request
     * @Author :
     * @Description : 查询所有成绩
     * @Date : 2020/3/30 13:42
     * @Return :
     **/
    public PageResult<List<UserAchievementVO>> findAchievementAll(PageRequest<AchievementRequest> request) {
        List<UserAchievementVO> userAchievementVOS = achievementMapper.selectAchievementAll(request.getObj(), request.getOffset(), request.getLimit());
        int count = achievementMapper.selectAchievementCount(request.getObj());
        return new PageResult<List<UserAchievementVO>>(request.getPageNo(),request.getPageSize(),count,userAchievementVOS);
    }
}
