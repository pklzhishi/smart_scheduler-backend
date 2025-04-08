package org.example.smart_schedulerbackend.service;

import org.example.smart_schedulerbackend.model.entity.Remark;

import java.util.List;
import java.util.Map;

public interface RemarkService {
    Map<String,Object> insertRemark(Remark remark);
    List<Map<String,Object>> getRemark(Remark remark);
}
