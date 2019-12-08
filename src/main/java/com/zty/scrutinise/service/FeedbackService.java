package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.FeedbackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FeedbackService implements FeedbackDao {
    @Autowired
    private FeedbackDao feedbackDao;

    //增加反馈信息
    @Override
    public int add_feedback(Map map) {
        return feedbackDao.add_feedback(map);
    }
}
