package org.example.smart_schedulerbackend.service.impl;

import org.example.smart_schedulerbackend.mapper.ClassroomBookingMapper;
import org.example.smart_schedulerbackend.model.entity.SchedulingTaskFinal;
import org.example.smart_schedulerbackend.service.ClassroomBookingMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ClassroomBookingMapperServiceImpl implements ClassroomBookingMapperService {
    @Autowired
    private ClassroomBookingMapper classroomBookingMapper;

    @Override
    public Map<String, Object> bookingClassroom(String schoolDistricts, String classroomName, Integer timeWeek, String time) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("schoolDistricts", schoolDistricts);
        dataMap.put("classroomName", classroomName);
        dataMap.put("timeWeek", timeWeek);
        dataMap.put("time", time);
        Map<String, Object> map = new HashMap<>();
        try {
            LocalDate start = LocalDate.of(2025, 2, 17);
            int add = 7 * (timeWeek - 1);
            String[] day = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
            String timeDay = time.substring(0, 3);
            for (int i = 0; i < 7; i++) {
                if (timeDay.equals(day[i])) {
                    add += i;
                }
            }
            String[] times = {"10:00", "12:00", "16:05", "18:05", "21:10"};
            LocalDate finalDate = start.plusDays(add);
            int hour = Integer.parseInt(times[Integer.parseInt(time.substring(4, 5))].substring(0,2));
            int minute = Integer.parseInt(times[Integer.parseInt(time.substring(4, 5))].substring(3,5));
            LocalDateTime targetDateTime = finalDate.atTime(hour, minute);
            LocalDateTime now = LocalDateTime.now();
            Date target = Date.from(targetDateTime.atZone(ZoneId.systemDefault()).toInstant());
            Date current = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
            long delay = target.getTime() - current.getTime();
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            Runnable cancelTask = () -> classroomBookingMapper.cancelBooking(dataMap);
            executor.schedule(cancelTask, delay, TimeUnit.MILLISECONDS);
            executor.shutdown();
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
        map.put("result", classroomBookingMapper.bookingClassroom(dataMap) > 0);
        return map;
    }
//    @Override
//    public Map<String,Object> bookingClassroom(String schoolDistricts, String classroomName, Integer timeWeek, String time)
//    {
//        Map<String,Object> dataMap = new HashMap<>();
//        dataMap.put("schoolDistricts",schoolDistricts);
//        dataMap.put("classroomName",classroomName);
//        dataMap.put("timeWeek",timeWeek);
//        dataMap.put("time",time);
//        Map<String,Object> map = new HashMap<>();
//        LocalDate start = LocalDate.of(2025, 2, 17);
//        int add = 7 * (timeWeek - 1);
//        String[] day = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
//        String timeDay = time.substring(0,3);
//        for(int i = 0;i < 7;i++)
//        {
//            if(timeDay.equals(day[i]))
//            {
//                add += i;
//            }
//        }
//        String[] times = {"10:00","12:00","16:05","18:05","21:10"};
//        LocalDate finalTime = start.plusDays(add);
//        String accurateTime = "0 " + times[Integer.parseInt(time.substring(4,5))].substring(3,5) + " " + times[Integer.parseInt(time.substring(4,5))].substring(0,2) + " " + String.valueOf(finalTime.getDayOfMonth()) + " " + String.valueOf(finalTime.getMonthValue()) + " " + time.substring(0,3) + " " + String.valueOf(finalTime.getYear());
//        @Scheduled(cron = accurateTime)
//        {
//            classroomBookingMapper.cancelBooking(dataMap);
//        }
//        map.put("result",classroomBookingMapper.bookingClassroom(dataMap));
//        return map;
//    }

    @Override
    public Map<String,Object> cancelBooking(String schoolDistricts,String classroomName,Integer timeWeek,String time)
    {
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("schoolDistricts", schoolDistricts);
        dataMap.put("classroomName", classroomName);
        dataMap.put("timeWeek", timeWeek);
        dataMap.put("time", time);
        Map<String,Object> map = new HashMap<>();
        map.put("result",classroomBookingMapper.cancelBooking(dataMap) > 0);
        return map;
    }
}
