package org.example.smart_schedulerbackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.smart_schedulerbackend.model.entity.DepartmentInformation;
import org.example.smart_schedulerbackend.model.entity.Teacher;
import org.example.smart_schedulerbackend.model.entity.TeacherInformation;
import org.example.smart_schedulerbackend.model.dto.TeacherDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper extends BaseMapper<TeacherInformation> {

    @Select("SELECT * FROM teacher_information")
    List<TeacherDTO> getAllTeachers();

    default List<TeacherInformation> searchByKeyword(String keyword) {
        QueryWrapper<TeacherInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("Teacher_name", keyword)
                .or()
                .like("Teacher_number", keyword); // 假设我们对"name"字段进行模糊搜索
        return this.selectList(queryWrapper);
    }

    List<Teacher> getAllTeacherInformation(String department);
    List<Teacher> getTeacherInformation(String department);
    long countTeacherInformation(String department);
    int updatePreference(Map<String,Object> param);

}
