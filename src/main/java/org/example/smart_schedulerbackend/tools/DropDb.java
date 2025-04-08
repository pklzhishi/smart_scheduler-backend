package org.example.smart_schedulerbackend.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropDb {
    public int drop(String semester) {
        // 数据库连接信息
        String jdbcUrl = "jdbc:mysql://115.29.241.234:3306/ai_schedulerdb";
        String username = "root";
        String password = "@84986730Pkl";

        // SQL 删除语句，这里以删除 Course_name 为 '示例课程' 的数据为例
        String deleteQuery = "DELETE FROM scheduling_task_final WHERE Year_semester = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            // 设置删除条件的值
            preparedStatement.setString(1, semester);

            // 执行删除操作
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("成功删除 " + rowsAffected + " 行数据。");
            return rowsAffected;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
