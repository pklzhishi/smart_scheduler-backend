package org.example.smart_schedulerbackend.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveFile {
    public void save() {
        String root = "D:\\testfileupload\\";
//        String root = "/opt/ai_schedule/";
        String inputCsvFilePath1 = root + "courses.csv";
        String inputCsvFilePath2 = root + "classes.csv";
        String inputCsvFilePath3 = root + "teachers.csv";
        String inputCsvFilePath4 = root + "classrooms.csv";
        String inputCsvFilePath5 = root + "teacher_satisfaction.csv";
        String outputCsvFilePath = root + "timetable_result.csv";
        String pythonScriptPath = "D:\\服创相关\\3.31修改\\ai_schedule.py";
//        String pythonScriptPath = "/opt/ai_schedule/ai_schedule.py";

        // 读取 CSV 文件
        try {
            // 调用 Python 脚本
            ProcessBuilder pb = new ProcessBuilder("python",pythonScriptPath,inputCsvFilePath1,inputCsvFilePath2,inputCsvFilePath3,inputCsvFilePath4,inputCsvFilePath5,outputCsvFilePath);
            Process process = pb.start();

            // 获取标准输出
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            System.out.println("Python 脚本标准输出:");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // 获取标准错误输出
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.out.println("Python 脚本标准错误输出:");
            while ((s = stdError.readLine()) != null) {
                System.err.println(s);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Python 脚本执行成功");
                // 导入结果到数据库
                importCsvToDatabase(outputCsvFilePath);
            } else {
                System.out.println("Python 脚本执行失败");
            }
        } catch (IOException | InterruptedException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void importCsvToDatabase(String csvFilePath) throws IOException, SQLException {
        String jdbcUrl = "jdbc:mysql://115.29.241.234:3306/ai_schedulerdb";
        String username = "root";
        String password = "@84986730Pkl";
        String insertQuery = "INSERT INTO scheduling_task_final (Year_semester,time,Course_number,Course_name,Teacher_number,Teacher_name,Class_compose,Credits,Hour_type,Commencement_hour,Scheduling_hour,Total_hour,Scheduling_priority,Class_people_number,Class_school_district,Class_weeks_hours,Rows_number,Classroom_type_assigned,Classroom_assigned,classroom_name) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
             BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] values = line.split(",");
                preparedStatement.setString(1, values[0]);
                preparedStatement.setString(2, values[1]);
                preparedStatement.setString(3, values[2]);
                preparedStatement.setString(4, values[3]);
                preparedStatement.setString(5, values[4]);
                preparedStatement.setString(6, values[5]);
                preparedStatement.setString(7, values[6]);
                preparedStatement.setString(8, values[7]);
                preparedStatement.setString(9, values[8]);
                preparedStatement.setString(10, values[9]);
                preparedStatement.setString(11, values[10]);
                preparedStatement.setString(12, values[11]);
                preparedStatement.setString(13, values[12]);
                preparedStatement.setString(14, values[13]);
                preparedStatement.setString(15, values[14]);
                preparedStatement.setString(16, values[15]);
                preparedStatement.setString(17, values[16]);
                preparedStatement.setString(18, values[17]);
                preparedStatement.setString(19, values[18]);
                preparedStatement.setString(20, values[19]);
                preparedStatement.executeUpdate();
            }
            System.out.println("数据导入成功");
        }
    }
}