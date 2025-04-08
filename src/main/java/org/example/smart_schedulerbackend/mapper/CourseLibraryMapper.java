package org.example.smart_schedulerbackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.smart_schedulerbackend.model.entity.CourseLibrary;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseLibraryMapper extends BaseMapper<CourseLibrary> {

    default List<CourseLibrary> searchByKeyword(String keyword) {
        QueryWrapper<CourseLibrary> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("course_number", keyword)
                .or()
                .like("course_name", keyword)
                .or()
                .like("Department", keyword); // 假设我们对"name"字段进行模糊搜索
        return this.selectList(queryWrapper);
    }

    //自定义的 SQL 方法
    List<CourseLibrary> getAllCourses();
    CourseLibrary getCourseByNumber(String courseNumber);
    void insertCourse(CourseLibrary courseLibrary);
    void updateCourse(CourseLibrary courseLibrary);
    void deleteCourse(String courseNumber);
    List<CourseLibrary> getAllCourseInformation(Map<String,Object> param);
    List<CourseLibrary> getAllCourseProperties();
    long countCourseInformation(Map<String,Object> param);
}
