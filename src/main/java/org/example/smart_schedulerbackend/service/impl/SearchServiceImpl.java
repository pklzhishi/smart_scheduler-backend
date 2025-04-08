package org.example.smart_schedulerbackend.service.impl;

import org.example.smart_schedulerbackend.model.entity.*;
import org.example.smart_schedulerbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import java.util.*;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private DepartmentInformationService departmentInformationService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClassInformationService classInformationService;

    @Autowired
    private ClassroomInformationService classroomInformationService;

    @Autowired
    private CourseLibraryService courseLibraryService;


    @Override
    public List<Object> search(String keyword) {
        List<Map<String, Object>> result = new ArrayList<>();

        // 搜索部门信息
        List<DepartmentInformation> departments = departmentInformationService.searchByKeyword(keyword);
        for (DepartmentInformation department : departments) {
            Map<String, Object> departmentMap = new HashMap<>();
            departmentMap.put("data", department);
            departmentMap.put("type", "department");
            result.add(departmentMap);
        }

        // 搜索教师信息
        List<TeacherInformation> teachers = teacherService.searchByKeyword(keyword);
        for (TeacherInformation teacher : teachers) {
            Map<String, Object> teacherMap = new HashMap<>();
            teacherMap.put("data", teacher);
            teacherMap.put("type", "teacher");
            result.add(teacherMap);
        }

        List<ClassInformation> classes = classInformationService.searchByKeyword(keyword);
        for (ClassInformation classInformation : classes) {
            Map<String, Object> classMap = new HashMap<>();
            classMap.put("data", classInformation);
            classMap.put("type", "class");
            result.add(classMap);
        }

        List<ClassroomInformation> classrooms = classroomInformationService.searchByKeyword(keyword);
        for (ClassroomInformation classroom : classrooms) {
            Map<String, Object> classroomMap = new HashMap<>();
            classroomMap.put("data", classroom);
            classroomMap.put("type", "classroom");
            result.add(classroomMap);
        }

        List<CourseLibrary> courses = courseLibraryService.searchByKeyword(keyword);
        for (CourseLibrary course : courses) {
            Map<String, Object> courseMap = new HashMap<>();
            courseMap.put("data", course);
            courseMap.put("type", "course");
            result.add(courseMap);
        }

        // 其他表的搜索...

        return Collections.singletonList(result);
    }
}
