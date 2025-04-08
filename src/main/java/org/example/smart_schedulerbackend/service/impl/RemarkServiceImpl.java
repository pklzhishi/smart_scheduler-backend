package org.example.smart_schedulerbackend.service.impl;

import org.example.smart_schedulerbackend.mapper.RemarkMapper;
import org.example.smart_schedulerbackend.model.entity.Remark;
import org.example.smart_schedulerbackend.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RemarkServiceImpl implements RemarkService {
    @Autowired
    private RemarkMapper remarkMapper;

    @Override
    public Map<String,Object> insertRemark(Remark remark)
    {
        int x = remarkMapper.insertRemark(remark);
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("result",x > 0);
        return dataMap;
    }

    @Override
    public List<Map<String,Object>> getRemark(Remark remark)
    {
        List<Map<String,Object>> resultList = new ArrayList<>();
        List<Remark> dataMap = remarkMapper.getRemark(remark);
        for(Remark classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("remarkInformation",classInfo.getRemarkInformation());
            resultList.add(map);
        }
        return resultList;
    }
}
