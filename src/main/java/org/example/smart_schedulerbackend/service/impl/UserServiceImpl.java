package org.example.smart_schedulerbackend.service.impl;

import org.example.smart_schedulerbackend.mapper.UserMapper;
import org.example.smart_schedulerbackend.model.entity.User;
import org.example.smart_schedulerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(User user){
        User user1 = userMapper.getUserById(user.getId());
        if(user1 != null)
        {
            return false;
        }
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setIsDeleted(0);
        int rows = userMapper.insertUser(user);
        return rows > 0;
    }
    @Override
    public Map<String,Object> registerValidation(User user){
        Map<String,Object> dataMap = new HashMap<>();
        Map<String,Object> map = new HashMap<>();
        User user1 = userMapper.getUserById(user.getId());
        if(user1 != null)
        {
            dataMap.put("code",2);
            dataMap.put("message","用户已注册账号");
            return dataMap;
        }
        if(user.getIdentity().equals("student"))
        {
            List<Map<Object,Long>> list = userMapper.informationValidationForStudent(user.getId());
            if(list.get(0).get("count") == 0)
            {
                dataMap.put("code",0);
                dataMap.put("message","用户不存在");
                return dataMap;
            }
            else
            {
                dataMap.put("code",1);
                dataMap.put("message","校验成功");
                return dataMap;
            }
        }
        else
        {
            List<Map<Object,Long>> list = userMapper.informationValidationForTeacher(user.getId());
            if(list.get(0).get("count") == 0)
            {
                dataMap.put("code",0);
                dataMap.put("message","用户不存在");
                return dataMap;
            }
            else
            {
                dataMap.put("code",1);
                dataMap.put("message","校验成功");
                return dataMap;
            }
        }
    }

    @Override
    public boolean login(String id,String password){
        User user = userMapper.getUserById(id);
        if(user != null && user.getPassword().equals(password))
        {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> getClassByStudent(String id) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<Object, Object>> list = userMapper.getClassByStudent(id);
        if (!list.isEmpty()) {
            System.out.println(list);
            Object className = list.get(0).get("class_name");
            if (className != null) {
                resultMap.put("className", className);
                resultMap.put("schoolDistrict",list.get(0).get("school_district"));
            }
            return resultMap;
        }
        else
        {
            resultMap.put("result","无该学生");
            return resultMap;
        }
    }
}
