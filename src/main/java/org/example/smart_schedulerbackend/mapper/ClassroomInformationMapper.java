package org.example.smart_schedulerbackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.smart_schedulerbackend.model.dto.ClassroomEquipmentDTO;
import org.example.smart_schedulerbackend.model.dto.ClassroomInformationDTO;
import org.example.smart_schedulerbackend.model.entity.ClassroomInformation;

import java.util.List;
import java.util.Map;


@Mapper
public interface ClassroomInformationMapper extends BaseMapper<ClassroomInformation> {

    @Select("SELECT DISTINCT school_districts FROM classroom_information")
    List<String> getAllSchoolDistricts();

    @Select("SELECT DISTINCT school_building FROM classroom_information WHERE school_districts = #{schoolDistricts}")
    List<String> getSchoolBuildingsBySchoolDistricts(String schoolDistricts);

    @Select("SELECT classroom_name, classroom_type, floor FROM classroom_information WHERE school_building = #{schoolBuilding}")
    List<ClassroomInformationDTO> getClassroomInformationsBySchoolBuilding(String schoolBuilding);

    default List<ClassroomInformation> searchByKeyword(String keyword) {
        QueryWrapper<ClassroomInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("Classroom_number", keyword)
                .or()
                .like("Classroom_name", keyword)
                .or()
                .like("Classroom_type", keyword)
                .or()
                .like("Management_department", keyword); // 假设我们对"name"字段进行模糊搜索
        return this.selectList(queryWrapper);
    }

    @Select("SELECT * FROM classroom_information WHERE classroom_number = #{classroomNumber}")
    ClassroomInformation selectByClassroomNumber(String classroomNumber);

    @Update({
            "UPDATE classroom_information",
            "SET",
            "classroom_name = #{classroomName},",
            "floor = #{floor},",
            "maximum_capacity = #{maximumCapacity},",
            "status = #{status},",
            "projector = #{projector},",
            "lamp = #{lamp},",
            "microphone = #{microphone},",
            "air_conditioning = #{airConditioning}",
            "WHERE classroom_number = #{classroomNumber}"
    })
    int updateByClassroomNumber(@Param("classroomNumber") String classroomNumber,
                                @Param("classroomName") String classroomName,
                                @Param("floor") String floor,
                                @Param("maximumCapacity") String maximumCapacity,
                                @Param("status") String status,
                                @Param("projector") String projector,
                                @Param("lamp") String lamp,
                                @Param("microphone") String microphone,
                                @Param("airConditioning") String airConditioning
    );

    @Select("SELECT projector, lamp, microphone, air_conditioning " +
            "FROM classroom_information " +
            "WHERE classroom_name = #{classroomName}")
    ClassroomEquipmentDTO getClassroomEquipmentByClassroomName(@Param("classroomName") String classroomName);

    @Update("UPDATE classroom_information " +
            "SET projector = #{projector} " +
            "WHERE classroom_name = #{classroomName}")
    int updateProjectorByClassroomName(@Param("classroomName") String classroomName, @Param("projector") String projector);

    @Update("UPDATE classroom_information " +
            "SET lamp = #{lamp} " +
            "WHERE classroom_name = #{classroomName}")
    int updateLampByClassroomName(@Param("classroomName") String classroomName, @Param("lamp") String lamp);

    @Update("UPDATE classroom_information " +
            "SET microphone = #{microphone} " +
            "WHERE classroom_name = #{classroomName}")
    int updateMicrophoneByClassroomName(@Param("classroomName") String classroomName, @Param("microphone") String microphone);

    @Update("UPDATE classroom_information " +
            "SET air_conditioning = #{airConditioning} " +
            "WHERE classroom_name = #{classroomName}")
    int updateAirConditioningByClassroomName(@Param("classroomName") String classroomName, @Param("airConditioning") String airConditioning);

    List<ClassroomInformation> getAllClassroomInformation(Map<String,Object> param);
    long countClassroomInformation(Map<String,Object> param);
    List<ClassroomInformation> getEmptyClassroom(Map<String,Object> param);
    Long bookingClassroom(String classroomName);
}