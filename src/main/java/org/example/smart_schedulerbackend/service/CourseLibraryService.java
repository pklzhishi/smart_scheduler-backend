package org.example.smart_schedulerbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.smart_schedulerbackend.model.dto.CourseLibraryDTO;
import org.example.smart_schedulerbackend.model.entity.CourseLibrary;

import java.util.List;
import java.util.Map;

public interface CourseLibraryService extends IService<CourseLibrary> {
    List<CourseLibrary> getAllCourses();


    List<CourseLibrary> searchByKeyword(String keyword);

    CourseLibraryDTO getCourseByNumber(String courseNumber);
    void insertCourse(CourseLibrary courseLibrary);
    void updateCourse(CourseLibrary courseLibrary);
    void deleteCourse(String courseNumber);
    List<CourseLibrary> getAllCourseInformation(String department, String courseProperties,int page,int size);
    List<Map<String,Object>> getAllCourseProperties();
    Map<String,Object> countCourseInformation(String department, String courseProperties);
}