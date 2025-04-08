package org.example.smart_schedulerbackend.service.impl;

import org.example.smart_schedulerbackend.mapper.FeedbackMapper;
import org.example.smart_schedulerbackend.model.entity.Feedback;
import org.example.smart_schedulerbackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public Map<String,Object> problemandadvice(Feedback feedback)
    {
        feedback.setSubmissionTime(LocalDateTime.now());
        int x = feedbackMapper.ProblemAndAdvice(feedback);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("result",x > 0);
        return dataMap;
    }

    @Override
    public List<Map<String,Object>> getAllFeedBack()
    {
        return feedbackMapper.getAllFeedBack();
    }
}
