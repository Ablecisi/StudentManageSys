package com.zcedu.studentmanagesys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataComparison {

//    public static void main(String[] args) {
//        String inputData = "Hello, World!";
//        compareDataWithDatabase(inputData);
//    }

    public boolean compareDataWithDatabase(String table, String inputData,String id) {
        String databaseUrl = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "root";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 创建一个数据库连接
            connection = DriverManager.getConnection(databaseUrl, username, password);

            // 2. 编写一个查询，用于根据输入数据fetch数据库中的数据
            String query = "SELECT * FROM stm_sys." + table +" WHERE "+ id + "= ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, inputData);

            // 3. 执行查询并存储结果在变量中
            resultSet = preparedStatement.executeQuery();

            // 4. 比较结果和输入数据
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}

