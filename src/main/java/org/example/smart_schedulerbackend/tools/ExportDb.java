package org.example.smart_schedulerbackend.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class ExportDb {
//    public static void main(String[] args) {
//        ExportDb exportDb = new ExportDb();
//        exportDb.exportData();
//    }
    public void exportData() {
        String jdbcUrl = "jdbc:mysql://115.29.241.234:3306/ai_schedulerdb";
        String username = "root";
        String password = "@84986730Pkl";
        String root = "D:\\testfileupload\\";
//        String root = "/opt/ai_schedule/";
        String csvFilePathClasses = "classes.csv";
        String csvFilePathClassrooms = "classrooms.csv";
        String csvFilePathCourses = "courses.csv";
        String csvFilePathTeacherSatisfaction = "teacher_satisfaction.csv";
        String csvFilePathTeachers = "teachers.csv";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT Class_name,Class_size,Major FROM class_information");
             FileWriter csvWriter = new FileWriter(root + csvFilePathClasses)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) csvWriter.append(",");
                csvWriter.append(metaData.getColumnName(i));
            }
            csvWriter.append("\n");
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) csvWriter.append(",");
                    csvWriter.append(resultSet.getString(i));
                }
                csvWriter.append("\n");
            }
            System.out.println("数据已成功导出到 " + root + csvFilePathClasses);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT Classroom_name,Classroom_type,Maximum_capacity,score FROM classroom_information");
             FileWriter csvWriter = new FileWriter(root + csvFilePathClassrooms)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) csvWriter.append(",");
                csvWriter.append(metaData.getColumnName(i));
            }
            csvWriter.append("\n");
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) csvWriter.append(",");
                    csvWriter.append(resultSet.getString(i));
                }
                csvWriter.append("\n");
            }
            System.out.println("数据已成功导出到 " + root + csvFilePathClassrooms);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("SELECT Year_semester,Course_number,Course_name,Teacher_number,Teacher_name,Class_compose,Credits,Hour_type,Commencement_hour,Scheduling_hour,Total_hour,Scheduling_priority,Class_people_number,Class_school_district,Class_weeks_hours,Rows_number,Classroom_type_assigned,Classroom_assigned FROM scheduling_task");
             ResultSet resultSet = statement.executeQuery("SELECT Year_semester,Course_number,Course_name,Teacher_number,Teacher_name,Class_compose,Credits,Commencement_hour,Scheduling_hour,Total_hour,Scheduling_priority,Class_people_number,Course_nature,Class_school_district,Class_weeks_hours,Rows_number,Classroom_type_assigned,Classroom_assigned FROM scheduling_task");
             FileWriter csvWriter = new FileWriter(root + csvFilePathCourses)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) csvWriter.append(",");
                csvWriter.append(metaData.getColumnName(i));
            }
            csvWriter.append("\n");
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) csvWriter.append(",");
                    csvWriter.append(resultSet.getString(i));
                }
                csvWriter.append("\n");
            }
            System.out.println("数据已成功导出到 " + root + csvFilePathCourses);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT Teacher_name,Preference FROM teacher_information");
             FileWriter csvWriter = new FileWriter(root + csvFilePathTeacherSatisfaction)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) csvWriter.append(",");
                csvWriter.append(metaData.getColumnName(i));
            }
            csvWriter.append("\n");
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) csvWriter.append(",");
                    csvWriter.append(resultSet.getString(i));
                }
                csvWriter.append("\n");
            }
            System.out.println("数据已成功导出到 " + root + csvFilePathTeacherSatisfaction);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT Teacher_name FROM teacher_information");
             FileWriter csvWriter = new FileWriter(root + csvFilePathTeachers)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                if (i > 1) csvWriter.append(",");
                csvWriter.append(metaData.getColumnName(i));
            }
            csvWriter.append("\n");
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) csvWriter.append(",");
                    csvWriter.append(resultSet.getString(i));
                }
                csvWriter.append("\n");
            }
            System.out.println("数据已成功导出到 " + root + csvFilePathTeachers);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
