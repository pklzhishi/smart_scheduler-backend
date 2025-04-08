package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.entity.Feedback;
import org.example.smart_schedulerbackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/problemandadvice")
    public Map<String,Object> problemandadvice(@RequestBody Feedback feedback){
        return feedbackService.problemandadvice(feedback);
    }

    @PostMapping("/getAllFeedBack")
    public List<Map<String,Object>> getAllFeedBack(){
        return feedbackService.getAllFeedBack();
    }
}
