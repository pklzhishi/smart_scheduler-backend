package org.example.smart_schedulerbackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.smart_schedulerbackend.model.entity.CourseLibrary;

import java.util.List;

@Mapper
public interface SchoolBuildingMapper extends BaseMapper<CourseLibrary> {

    default List<CourseLibrary> searchByKeyword(String keyword) {
        QueryWrapper<CourseLibrary> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("Building_number", keyword)
                .or()
                .like("Building_name", keyword)
                .or()
                .like("School_districts", keyword); // 假设我们对"name"字段进行模糊搜索
        return this.selectList(queryWrapper);
    }
    //自定义的 SQL 方法
}