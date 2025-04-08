package org.example.smart_schedulerbackend.controller;

import org.example.smart_schedulerbackend.mapper.UserMapper;
import org.example.smart_schedulerbackend.model.entity.User;
import org.example.smart_schedulerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/getClassByStudent")
    public Map<String,Object> getClassByStudent(@RequestParam String id)
    {
        return userService.getClassByStudent(id);
    }

    @PostMapping("/registerValidation")
    public Map<String, Object> registerValidation(@RequestBody User user) {
        return userService.registerValidation(user);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
        List<Map<Object,Object>> list = userMapper.onlyTelephoneNumber(user.getTelephoneNumber());
        System.out.println("收到请求");
        Map<String, Object> response = new HashMap<>();
        if (userService.register(user)) {

            System.out.println(list);
            if(list.isEmpty())
            {
                response.put("code", 1);
                response.put("message", "注册成功");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else
            {
                Long x = userMapper.deleteUser(user.getId());
                response.put("code", 2);
                response.put("message", "该手机号已注册");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } else {
            response.put("code", 0);
            response.put("message", "注册失败，用户名已存在");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String id, @RequestParam String password) {
        System.out.println("收到请求");
        Map<String, Object> response = new HashMap<>();
        if (userService.login(id, password)) {
            response.put("code", 1);
            response.put("message", "登录成功");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("code", 0);
            response.put("message", "登录失败，用户名或密码错误");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
}