package com.exam.exam_system.service.achievementService;

import com.exam.exam_system.mapper.achievementMapper.AchievementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AchievementService {

    private AchievementMapper achievementMapper;

    @Autowired
    public AchievementService(AchievementMapper achievementMapper) {
        this.achievementMapper = achievementMapper;
    }

}
