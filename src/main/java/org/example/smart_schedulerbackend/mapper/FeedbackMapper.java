package org.example.smart_schedulerbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.smart_schedulerbackend.model.entity.Feedback;

import java.util.List;
import java.util.Map;

@Mapper
public interface FeedbackMapper {
    int ProblemAndAdvice(Feedback feedback);
    List<Map<String,Object>> getAllFeedBack();
}
