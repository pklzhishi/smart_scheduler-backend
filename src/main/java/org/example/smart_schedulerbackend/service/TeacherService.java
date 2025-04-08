package org.example.smart_schedulerbackend.service;

import org.example.smart_schedulerbackend.model.dto.TeacherDTO;
import org.example.smart_schedulerbackend.model.entity.DepartmentInformation;
import org.example.smart_schedulerbackend.model.entity.Teacher;
import org.example.smart_schedulerbackend.model.entity.TeacherInformation;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();

    List<TeacherInformation> searchByKeyword(String keyword);

    List<Teacher> getAllTeacherInformation(String department, int page, int size);
    List<Teacher> getTeacherInformation(String teacherNumber);
    Map<String,Object> countTeacherInformation(String department);
    Map<String,Object> updatePreference(String teacher_number,String preference);

}
