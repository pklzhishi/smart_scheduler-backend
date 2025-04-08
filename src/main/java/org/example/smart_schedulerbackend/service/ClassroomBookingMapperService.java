package org.example.smart_schedulerbackend.service;

import java.util.Map;

public interface ClassroomBookingMapperService {
    Map<String,Object> bookingClassroom(String schoolDistricts,String classroomName,Integer timeWeek,String time);
    Map<String,Object> cancelBooking(String schoolDistricts,String classroomName,Integer timeWeek,String time);
}
