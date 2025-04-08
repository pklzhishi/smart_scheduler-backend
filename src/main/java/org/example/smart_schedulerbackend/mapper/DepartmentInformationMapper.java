package org.example.smart_schedulerbackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.smart_schedulerbackend.model.entity.DepartmentInformation;
import org.example.smart_schedulerbackend.model.dto.DepartmentInformationDTO;

import java.util.List;

@Mapper
public interface DepartmentInformationMapper extends BaseMapper<DepartmentInformation> {

    @Select("SELECT * FROM department_information")
    List<DepartmentInformationDTO> getAllDepartments();

    default List<DepartmentInformation> searchByKeyword(String keyword) {
        QueryWrapper<DepartmentInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("Department_name", keyword)
                .or()
                .like("Department_number", keyword); // 对 "Department_number" 和 "Department_name" 进行模糊搜索
        return this.selectList(queryWrapper);
    }

    List<DepartmentInformation> getAllDepartmentInformation();
    long countDepartmentInformation();

}
