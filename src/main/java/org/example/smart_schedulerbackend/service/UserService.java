package org.example.smart_schedulerbackend.service;
import org.example.smart_schedulerbackend.model.entity.User;

import java.util.Map;

public interface UserService {
    boolean register(User user);
    Map<String,Object> registerValidation(User user);
    Map<String,Object> getClassByStudent(String id);
    boolean login(String username,String password);
}
