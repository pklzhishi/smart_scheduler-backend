package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.entity.Remark;
import org.example.smart_schedulerbackend.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RemarkController {
    @Autowired
    private RemarkService remarkService;

    @PostMapping("/insertremark")
    public Map<String,Object> insertremark(@RequestBody Remark remark)
    {
        return remarkService.insertRemark(remark);
    }

    @PostMapping("/getremark")
    public List<Map<String,Object>> getremark(@RequestBody Remark remark)
    {
        return remarkService.getRemark(remark);
    }
}
