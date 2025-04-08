package org.example.smart_schedulerbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO2;
import org.example.smart_schedulerbackend.model.dto.SchedulingTaskDTO3;
import org.example.smart_schedulerbackend.model.entity.SchedulingTask;
import org.example.smart_schedulerbackend.model.entity.SchedulingTaskFinal;

import java.util.List;
import java.util.Map;


@Mapper
public interface CourseListGetMapper extends BaseMapper<SchedulingTask> {

    @Select("SELECT attendance_rate FROM scheduling_task WHERE class_school_district = #{classSchoolDistrict} AND class_compose = #{classCompose} AND course_number = #{courseNumber}")
    String getAttendanceRateByClassSchoolDistrictAndClassCompose(
            @Param("classSchoolDistrict") String classSchoolDistrict,
            @Param("classCompose") String classCompose,
            @Param("courseNumber") String courseNumber
    );

    @Update("UPDATE scheduling_task " +
            "SET attendance_rate = #{attendanceRate} " +
            "WHERE class_school_district = #{classSchoolDistrict} " +
            "AND class_compose = #{classCompose} " +
            "AND course_number = #{courseNumber}")
    int updateAttendanceRateByFields(String classSchoolDistrict, String classCompose, String courseNumber, String attendanceRate);

    @Select("SELECT course_name, teacher_name, class_weeks_hours, class_compose, class_people_number " +
            "FROM scheduling_task " +
            "WHERE classroom_name = #{classroomName}")
    List<SchedulingTaskDTO2> getSchedulingTaskDTO2ByClassroomName(@Param("classroomName") String classroomName);

    @Select("SELECT DISTINCT course_name, class_people_number, attendance_rate FROM scheduling_task_final WHERE class_compose = #{classCompose}")
    List<SchedulingTaskDTO3> selectSchedulingTasksByClassCompose(@Param("classCompose") String classCompose);


}
