package org.example.smart_schedulerbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.smart_schedulerbackend.model.entity.ProfessionalData;
import org.example.smart_schedulerbackend.model.dto.ProfessionalDTO;

import java.util.List;

@Mapper
public interface ProfessionalDataMapper extends BaseMapper<ProfessionalData> {

    @Select("SELECT DISTINCT affiliation FROM professional_data")
    List<String> getAllAffiliations();

    @Select("SELECT professional_number, professional_name FROM professional_data WHERE affiliation = #{affiliation}")
    List<ProfessionalDTO> getProfessionalsByAffiliation(String affiliation);

    List<ProfessionalData> getAllProfessionalData();

}
