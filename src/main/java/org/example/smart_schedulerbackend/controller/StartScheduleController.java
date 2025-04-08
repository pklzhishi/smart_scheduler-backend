package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.tools.ExportDb;
import org.example.smart_schedulerbackend.tools.SaveFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StartScheduleController {
    ExportDb exportDb = new ExportDb();
    SaveFile saveFile = new SaveFile();

    @PostMapping("/startschedule")
    public Map<String,Object> startschedule()
    {
        exportDb.exportData();
        saveFile.save();
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("result",true);
        return dataMap;
    }
}
