package org.example.smart_schedulerbackend.service;

import org.example.smart_schedulerbackend.model.entity.Feedback;

import java.util.List;
import java.util.Map;

public interface FeedbackService {
    Map<String,Object> problemandadvice(Feedback feedback);
    List<Map<String,Object>> getAllFeedBack();
}
