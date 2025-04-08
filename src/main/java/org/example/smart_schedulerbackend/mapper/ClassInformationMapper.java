package org.example.smart_schedulerbackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.smart_schedulerbackend.model.dto.ClassInformationDTO;
import org.example.smart_schedulerbackend.model.entity.ClassInformation;
import org.example.smart_schedulerbackend.model.entity.TeacherInformation;

import java.util.List;

@Mapper
public interface ClassInformationMapper extends BaseMapper<ClassInformation> {

    @Select("SELECT class_number, class_name, class_size, Class_scheduling_type FROM class_information WHERE major = #{major}")
    List<ClassInformationDTO> getClassInformationsByMajor(String major);

    default List<ClassInformation> searchByKeyword(String keyword) {
        QueryWrapper<ClassInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("Class_number", keyword)
                .or()
                .like("Class_name", keyword)
                .or()
                .like("Faculties", keyword)
                .or()
                .like("Major", keyword); // 假设我们对"name"字段进行模糊搜索
        return this.selectList(queryWrapper);
    }
}

