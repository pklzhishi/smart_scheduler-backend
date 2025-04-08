package org.example.smart_schedulerbackend.service.impl;

import org.example.smart_schedulerbackend.controller.CourseListGetFinalController;
import org.example.smart_schedulerbackend.mapper.CourseListGetFinalMapper;
import org.example.smart_schedulerbackend.mapper.CourseListGetMapper;
import org.example.smart_schedulerbackend.model.entity.SchedulingTaskFinal;
import org.example.smart_schedulerbackend.service.CourseListGetFinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseListGetFinalServiceImpl implements CourseListGetFinalService {
    @Autowired
    private CourseListGetFinalMapper courseListGetFinalMapper;

    @Override
    @Cacheable(value = "courseList", key = "#classSchoolDistrict + '_' + #classroomname + '_' + #timeWeek", cacheManager = "cacheManager", unless = "#result == null")
    @Transactional(readOnly = true)
    public List<Map<String,Object>> getcourselist(String classSchoolDistrict, String classroomname, String timeWeek)
    {
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,String> mapx = new HashMap<>();
        mapx.put("classSchoolDistrict",classSchoolDistrict);
        mapx.put("classCompose",classroomname);
        mapx.put("timeWeek",timeWeek);
        List<SchedulingTaskFinal> dataMap = courseListGetFinalMapper.getCourseList(mapx);
        String[] x = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for(SchedulingTaskFinal classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("yearSemester",classInfo.getYearSemester());
            String timeDay = classInfo.getTime().substring(0,3);
            for(int i = 0;i < 7;i++)
            {
                if(timeDay.equals(x[i]))
                {
                    map.put("timeDay",i+1);
                }
            }
            map.put("timeTime",classInfo.getTime().substring(classInfo.getTime().length() - 1,classInfo.getTime().length()));
            map.put("courseNumber",classInfo.getCourseNumber());
            map.put("courseName",classInfo.getCourseName());
            map.put("teacherNumber",classInfo.getTeacherNumber());
            map.put("teacherName",classInfo.getTeacherName());
            map.put("classCompose",classInfo.getClassCompose());
            map.put("credits",classInfo.getCredits());
            map.put("hourType",classInfo.getHourType());
            map.put("commencementHour",classInfo.getCommencementHour());
            map.put("schedulingHour",classInfo.getSchedulingHour());
            map.put("totalHour",classInfo.getTotalHour());
            map.put("schedulingPriority",classInfo.getSchedulingPriority());
            map.put("classPeopleNumber",classInfo.getClassPeopleNumber());
            map.put("classSchoolDistrict",classInfo.getClassSchoolDistrict());
            int n = classInfo.getClassWeeksHours().indexOf(":");
            map.put("classWeeksHours",classInfo.getClassWeeksHours().substring(0,n));
            map.put("rowsNumber",classInfo.getRowsNumber());
            map.put("classroomTypeAssigned",classInfo.getClassroomTypeAssigned());
            map.put("classroomAssigned",classInfo.getClassroomAssigned());
            map.put("classroomName",classInfo.getClassroomName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    @Cacheable(value = "changeCourseList", key = "#classSchoolDistrict + '_' + #classroomname")
    @Transactional(readOnly = true)
    public List<Map<String,Object>> getchangecourselist(String classSchoolDistrict, String classroomname)
    {
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,String> mapx = new HashMap<>();
        mapx.put("classSchoolDistrict",classSchoolDistrict);
        mapx.put("classCompose",classroomname);
        List<SchedulingTaskFinal> dataMap = courseListGetFinalMapper.getChangeCourseList(mapx);
        String[] x = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for(SchedulingTaskFinal classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("yearSemester",classInfo.getYearSemester());
            String timeDay = classInfo.getTime().substring(0,3);
            for(int i = 0;i < 7;i++)
            {
                if(timeDay.equals(x[i]))
                {
                    map.put("timeDay",i+1);
                }
            }
            map.put("timeTime",classInfo.getTime().substring(classInfo.getTime().length() - 1,classInfo.getTime().length()));
            map.put("courseNumber",classInfo.getCourseNumber());
            map.put("courseName",classInfo.getCourseName());
            map.put("teacherNumber",classInfo.getTeacherNumber());
            map.put("teacherName",classInfo.getTeacherName());
            map.put("classCompose",classInfo.getClassCompose());
            map.put("credits",classInfo.getCredits());
            map.put("hourType",classInfo.getHourType());
            map.put("commencementHour",classInfo.getCommencementHour());
            map.put("schedulingHour",classInfo.getSchedulingHour());
            map.put("totalHour",classInfo.getTotalHour());
            map.put("schedulingPriority",classInfo.getSchedulingPriority());
            map.put("classPeopleNumber",classInfo.getClassPeopleNumber());
            map.put("classSchoolDistrict",classInfo.getClassSchoolDistrict());
            int n = classInfo.getClassWeeksHours().indexOf(":");
            map.put("classWeeksHours",classInfo.getClassWeeksHours().substring(0,n));
            map.put("rowsNumber",classInfo.getRowsNumber());
            map.put("classroomTypeAssigned",classInfo.getClassroomTypeAssigned());
            map.put("classroomAssigned",classInfo.getClassroomAssigned());
            map.put("classroomName",classInfo.getClassroomName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    @Cacheable(value = "teacherCourseList", key = "#teacherName + '_' + #timeWeek")
    @Transactional(readOnly = true)
    public List<Map<String,Object>> getTeacherCourseList(String teacherName,String timeWeek)
    {
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,String> mapx = new HashMap<>();
        mapx.put("teacherName",teacherName);
        mapx.put("timeWeek",timeWeek);
        List<SchedulingTaskFinal> dataMap = courseListGetFinalMapper.getTeacherCourseList(mapx);
        String[] x = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for(SchedulingTaskFinal classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("yearSemester",classInfo.getYearSemester());
            String timeDay = classInfo.getTime().substring(0,3);
            for(int i = 0;i < 7;i++)
            {
                if(timeDay.equals(x[i]))
                {
                    map.put("timeDay",i+1);
                }
            }
            map.put("timeTime",classInfo.getTime().substring(classInfo.getTime().length() - 1,classInfo.getTime().length()));
            map.put("courseNumber",classInfo.getCourseNumber());
            map.put("courseName",classInfo.getCourseName());
            map.put("teacherNumber",classInfo.getTeacherNumber());
            map.put("teacherName",classInfo.getTeacherName());
            map.put("classCompose",classInfo.getClassCompose());
            map.put("credits",classInfo.getCredits());
            map.put("hourType",classInfo.getHourType());
            map.put("commencementHour",classInfo.getCommencementHour());
            map.put("schedulingHour",classInfo.getSchedulingHour());
            map.put("totalHour",classInfo.getTotalHour());
            map.put("schedulingPriority",classInfo.getSchedulingPriority());
            map.put("classPeopleNumber",classInfo.getClassPeopleNumber());
            map.put("classSchoolDistrict",classInfo.getClassSchoolDistrict());
            int n = classInfo.getClassWeeksHours().indexOf(":");
            map.put("classWeeksHours",classInfo.getClassWeeksHours().substring(0,n));
            map.put("rowsNumber",classInfo.getRowsNumber());
            map.put("classroomTypeAssigned",classInfo.getClassroomTypeAssigned());
            map.put("classroomAssigned",classInfo.getClassroomAssigned());
            map.put("classroomName",classInfo.getClassroomName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    @Cacheable(value = "changeTeacherCourseList", key = "#teacherName")
    @Transactional(readOnly = true)
    public List<Map<String,Object>> getChangeTeacherCourseList(String teacherName)
    {
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,String> mapx = new HashMap<>();
        mapx.put("teacherName",teacherName);
        List<SchedulingTaskFinal> dataMap = courseListGetFinalMapper.getChangeTeacherCourseList(mapx);
        String[] x = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for(SchedulingTaskFinal classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("yearSemester",classInfo.getYearSemester());
            String timeDay = classInfo.getTime().substring(0,3);
            for(int i = 0;i < 7;i++)
            {
                if(timeDay.equals(x[i]))
                {
                    map.put("timeDay",i+1);
                }
            }
            map.put("timeTime",classInfo.getTime().substring(classInfo.getTime().length() - 1,classInfo.getTime().length()));
            map.put("courseNumber",classInfo.getCourseNumber());
            map.put("courseName",classInfo.getCourseName());
            map.put("teacherNumber",classInfo.getTeacherNumber());
            map.put("teacherName",classInfo.getTeacherName());
            map.put("classCompose",classInfo.getClassCompose());
            map.put("credits",classInfo.getCredits());
            map.put("hourType",classInfo.getHourType());
            map.put("commencementHour",classInfo.getCommencementHour());
            map.put("schedulingHour",classInfo.getSchedulingHour());
            map.put("totalHour",classInfo.getTotalHour());
            map.put("schedulingPriority",classInfo.getSchedulingPriority());
            map.put("classPeopleNumber",classInfo.getClassPeopleNumber());
            map.put("classSchoolDistrict",classInfo.getClassSchoolDistrict());
            int n = classInfo.getClassWeeksHours().indexOf(":");
            map.put("classWeeksHours",classInfo.getClassWeeksHours().substring(0,n));
            map.put("rowsNumber",classInfo.getRowsNumber());
            map.put("classroomTypeAssigned",classInfo.getClassroomTypeAssigned());
            map.put("classroomAssigned",classInfo.getClassroomAssigned());
            map.put("classroomName",classInfo.getClassroomName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    @Cacheable(value = "classroomUtilization", key = "#classroomName + '_' + #timeWeek")
    @Transactional(readOnly = true)
    public Map<String,Long> getClassroomUtilization(String classroomName,Integer timeWeek)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("classroomName",classroomName);
        map.put("timeWeek",timeWeek);
        Map<String,Long> mapx = new HashMap<>();
        mapx.put("result",courseListGetFinalMapper.getClassroomUtilization(map));
        return mapx;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String,Object>> getMonthViewForStudent(String times,String classSchoolDistrict, String className)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse("2023-02-17", formatter);
        LocalDate endDate = LocalDate.parse(times, formatter);
        LocalDate startDateWithoutYear = startDate.withYear(0);
        LocalDate endDateWithoutYear = endDate.withYear(0);
        long days = ChronoUnit.DAYS.between(startDateWithoutYear, endDateWithoutYear);
        int week = (int) (days / 7 + 1);
        int day = (int) (days % 7);
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,String> mapx = new HashMap<>();
        mapx.put("classSchoolDistrict",classSchoolDistrict);
        mapx.put("classCompose",className);
        mapx.put("timeWeek",String.valueOf(week));
        List<SchedulingTaskFinal> dataMap = courseListGetFinalMapper.getCourseList(mapx);
        String[] x = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for(SchedulingTaskFinal classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            String timeDay = classInfo.getTime().substring(0,3);
            if(timeDay.equals(x[day]))
            {
                map.put("timeDay",day);
                map.put("yearSemester",classInfo.getYearSemester());
                map.put("timeTime",classInfo.getTime().substring(classInfo.getTime().length() - 1,classInfo.getTime().length()));
                map.put("courseNumber",classInfo.getCourseNumber());
                map.put("courseName",classInfo.getCourseName());
                map.put("teacherNumber",classInfo.getTeacherNumber());
                map.put("teacherName",classInfo.getTeacherName());
                map.put("classCompose",classInfo.getClassCompose());
                map.put("credits",classInfo.getCredits());
                map.put("hourType",classInfo.getHourType());
                map.put("commencementHour",classInfo.getCommencementHour());
                map.put("schedulingHour",classInfo.getSchedulingHour());
                map.put("totalHour",classInfo.getTotalHour());
                map.put("schedulingPriority",classInfo.getSchedulingPriority());
                map.put("classPeopleNumber",classInfo.getClassPeopleNumber());
                map.put("classSchoolDistrict",classInfo.getClassSchoolDistrict());
                int n = classInfo.getClassWeeksHours().indexOf(":");
                map.put("classWeeksHours",classInfo.getClassWeeksHours().substring(0,n));
                map.put("rowsNumber",classInfo.getRowsNumber());
                map.put("classroomTypeAssigned",classInfo.getClassroomTypeAssigned());
                map.put("classroomAssigned",classInfo.getClassroomAssigned());
                map.put("classroomName",classInfo.getClassroomName());
                resultList.add(map);
            }
        }
        return resultList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String,Object>> getMonthViewForTeacher(String times,String teacherName)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse("2023-02-17", formatter);
        LocalDate endDate = LocalDate.parse(times, formatter);
        LocalDate startDateWithoutYear = startDate.withYear(0);
        LocalDate endDateWithoutYear = endDate.withYear(0);
        long days = ChronoUnit.DAYS.between(startDateWithoutYear, endDateWithoutYear);
        int week = (int) (days / 7 + 1);
        int day = (int) (days % 7);
        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,String> mapx = new HashMap<>();
        mapx.put("teacherName",teacherName);
        mapx.put("timeWeek",String.valueOf(week));
        List<SchedulingTaskFinal> dataMap = courseListGetFinalMapper.getTeacherCourseList(mapx);
        String[] x = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        for(SchedulingTaskFinal classInfo : dataMap)
        {
            Map<String,Object> map = new HashMap<>();
            String timeDay = classInfo.getTime().substring(0,3);
            if(timeDay.equals(x[day])) {
                map.put("timeDay", day);
                map.put("timeTime", classInfo.getTime().substring(classInfo.getTime().length() - 1, classInfo.getTime().length()));
                map.put("courseNumber", classInfo.getCourseNumber());
                map.put("courseName", classInfo.getCourseName());
                map.put("teacherNumber", classInfo.getTeacherNumber());
                map.put("teacherName", classInfo.getTeacherName());
                map.put("classCompose", classInfo.getClassCompose());
                map.put("credits", classInfo.getCredits());
                map.put("hourType", classInfo.getHourType());
                map.put("commencementHour", classInfo.getCommencementHour());
                map.put("schedulingHour", classInfo.getSchedulingHour());
                map.put("totalHour", classInfo.getTotalHour());
                map.put("schedulingPriority", classInfo.getSchedulingPriority());
                map.put("classPeopleNumber", classInfo.getClassPeopleNumber());
                map.put("classSchoolDistrict", classInfo.getClassSchoolDistrict());
                int n = classInfo.getClassWeeksHours().indexOf(":");
                map.put("classWeeksHours", classInfo.getClassWeeksHours().substring(0, n));
                map.put("rowsNumber", classInfo.getRowsNumber());
                map.put("classroomTypeAssigned", classInfo.getClassroomTypeAssigned());
                map.put("classroomAssigned", classInfo.getClassroomAssigned());
                map.put("classroomName", classInfo.getClassroomName());
                resultList.add(map);
            }
        }
        return resultList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> detectConflicts(List<Map<String,Object>> list)
    {
        int size = list.size();
        String[] x = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        Map<String,Object> map = new HashMap<>();
        int xx = 0;
        for(int i = 0;i < size;i++)
        {
            Map<String,Object> dataMapTeacher = new HashMap<>();
            Map<String,Object> dataMapClass = new HashMap<>();
//            Map<String,Object> dataMapClassroom = new HashMap<>();
            String time = "";
            time += x[(int) list.get(i).get("timeDay") - 1] + "-" + list.get(i).get("timeTime");
            dataMapTeacher.put("time",time);
            dataMapClass.put("time",time);
//            dataMapClassroom.put("time",time);
            dataMapTeacher.put("teacherName",list.get(i).get("teacherName"));
            dataMapClass.put("classCompose",list.get(i).get("classCompose"));
            dataMapTeacher.put("classroomName",list.get(i).get("classroomName"));
            dataMapClass.put("classroomName",list.get(i).get("classroomName"));
//            dataMapClassroom.put("classroomName",list.get(i).get("classroomName"));
            List<Map<String,Object>> x1 = courseListGetFinalMapper.detectConflictsByClass(dataMapClass);
            List<Map<String,Object>> x2 = courseListGetFinalMapper.detectConflictsByTeacher(dataMapTeacher);
            if(!x1.isEmpty())
            {
                if(xx == 0)
                {
                    xx = 1;
                    map.put("code",0);
                }
                map.put("message","第" + (i + 1) + "条排课安排中," + "教室:" + x1.get(0).get("classroom_name") + "已被排课");
            }
            else if (!x2.isEmpty())
            {
                if(xx == 0)
                {
                    xx = 1;
                    map.put("code",0);
                }
                map.put("message","第" + (i + 1) + "条排课安排中," + "教师:" + x1.get(0).get("teacher_name") + "已被排课");
            }
        }
        if(xx == 1)
        {
            return map;
        }
        else
        {
            Long a = courseListGetFinalMapper.deleteClassSchedule((String) list.get(0).get("classCompose"));
            for(int i = 0;i < size;i++)
            {
                System.out.println(list.get(0));
                Map<String,Object> dataMap = new HashMap<>();
                String time = "";
                time += x[(int) list.get(i).get("timeDay") - 1] + "-" + list.get(i).get("timeTime");
                dataMap.put("yearSemester", list.get(i).get("yearSemester"));
                dataMap.put("time",time);
                dataMap.put("courseNumber", list.get(i).get("courseNumber"));
                dataMap.put("courseName", list.get(i).get("courseName"));
                dataMap.put("teacherNumber", list.get(i).get("teacherNumber"));
                dataMap.put("teacherName", list.get(i).get("teacherName"));
                dataMap.put("classCompose", list.get(i).get("classCompose"));
                dataMap.put("credits", list.get(i).get("credits"));
                dataMap.put("hourType", list.get(i).get("hourType"));
                dataMap.put("commencementHour", list.get(i).get("commencementHour"));
                dataMap.put("schedulingHour", list.get(i).get("schedulingHour"));
                dataMap.put("totalHour", list.get(i).get("totalHour"));
                dataMap.put("schedulingPriority", list.get(i).get("schedulingPriority"));
                dataMap.put("classPeopleNumber", list.get(i).get("classPeopleNumber"));
                dataMap.put("classSchoolDistrict", list.get(i).get("classSchoolDistrict"));
                dataMap.put("classWeeksHours", list.get(i).get("classWeeksHours") + ":2");
                dataMap.put("rowsNumber", list.get(i).get("rowsNumber"));
                dataMap.put("classroomTypeAssigned", list.get(i).get("classroomTypeAssigned"));
                dataMap.put("classroomAssigned", list.get(i).get("classroomAssigned"));
                dataMap.put("classroomName", list.get(i).get("classroomName"));
                Long b = courseListGetFinalMapper.insertClassSchedule(dataMap);
            }
            map.put("code",1);
            map.put("message","手动排课成功");
        }
        return map;
    }

    @Override
    @Cacheable(value = "attendenceRate", key = "#className")
    @Transactional(readOnly = true)
    public List<Map<String,Object>> getAttendenceRate(String className)
    {
        return courseListGetFinalMapper.getAttendenceRate(className);
    }
}
