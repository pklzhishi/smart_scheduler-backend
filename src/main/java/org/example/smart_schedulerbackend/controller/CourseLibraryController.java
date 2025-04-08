package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.model.dto.CourseLibraryDTO;
import org.example.smart_schedulerbackend.model.entity.ClassroomInformation;
import org.example.smart_schedulerbackend.model.entity.CourseLibrary;
import org.example.smart_schedulerbackend.service.CourseLibraryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course-library")
public class CourseLibraryController {

    @Autowired
    private CourseLibraryService courseLibraryService;

    @GetMapping("/")
    public List<CourseLibraryDTO> getAllCourses() {
        List<CourseLibrary> courses = courseLibraryService.getAllCourses();
        return courses.stream()
                .map(course -> {
                    CourseLibraryDTO dto = new CourseLibraryDTO();
                    BeanUtils.copyProperties(course, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{courseNumber}")
    public CourseLibraryDTO getCourseByNumber(@PathVariable String courseNumber) {
        return courseLibraryService.getCourseByNumber(courseNumber);
    }

    @PostMapping
    public void insertCourse(@RequestBody CourseLibrary courseLibrary) {
        courseLibraryService.insertCourse(courseLibrary);
    }

    @PutMapping
    public void updateCourse(@RequestBody CourseLibrary courseLibrary) {
        courseLibraryService.updateCourse(courseLibrary);
    }

    @DeleteMapping("/{courseNumber}")
    public void deleteCourse(@PathVariable String courseNumber) {
        courseLibraryService.deleteCourse(courseNumber);
    }

    @PostMapping("/getallcourseinformation")
    public List<CourseLibrary> getallcourseinformation(@RequestParam String department, @RequestParam String courseProperties,@RequestParam int page,@RequestParam int size)
    {
        return courseLibraryService.getAllCourseInformation(department,courseProperties,page,size);
    }

    @PostMapping("/getallcoursecategories")
    public List<Map<String,Object>> getallcoursecategories()
    {
        return courseLibraryService.getAllCourseProperties();
    }

    @PostMapping("/countcourseinformation")
    public Map<String,Object> countcourseinformation(@RequestParam String department, @RequestParam String courseProperties)
    {
        return courseLibraryService.countCourseInformation(department,courseProperties);
    }
}