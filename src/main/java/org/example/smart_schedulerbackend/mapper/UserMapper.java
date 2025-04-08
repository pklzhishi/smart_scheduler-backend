package org.example.smart_schedulerbackend.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.example.smart_schedulerbackend.model.entity.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    User getUserById(String id);
    int insertUser(User user);
    int updateUser(User user);
    Long deleteUser(String id);
    List<Map<Object,Long>> informationValidationForStudent(String id);
    List<Map<Object,Long>> informationValidationForTeacher(String teacherNumber);
    List<Map<Object,Object>> getClassByStudent(String id);
    List<Map<Object,Object>> onlyTelephoneNumber(String telepooneNumber);
}