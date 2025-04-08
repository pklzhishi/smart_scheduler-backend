package org.example.smart_schedulerbackend.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ClassroomBookingMapper {
    Long bookingClassroom(Map<String,Object> param);
    Long cancelBooking(Map<String,Object> param);
}