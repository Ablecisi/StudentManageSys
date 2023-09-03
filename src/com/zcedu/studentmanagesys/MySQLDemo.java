package com.zcedu.studentmanagesys;

import java.sql.*;
import java.util.Objects;

public class MySQLDemo {

    private String
            // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
            JDBC_DRIVER = "com.mysql.cj.jdbc.Driver",
            DB_URL = "jdbc:mysql://localhost:3306",
            // 数据库的用户名与密码，需要根据自己的设置
            USER = "root",
            PASS = "root";

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void select(String id, String tableName) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(getJDBC_DRIVER());
            // 打开链接
            //System.out.println("连接数据库...");
            conn = DriverManager.getConnection(getDB_URL(),getUSER(),getPASS());
            // 执行查询
            //System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();

            String sql;
            int row;
            String[] columns;

            if(Objects.equals(tableName, "student")) {
                sql = "SELECT student_id ,student_name,gender,age,grade,sort FROM stm_sys.student where student_id = " + id;//做为语句的承载
                columns = new String[]{"student_id", "student_name", "gender", "age", "grade", "sort"};
                row=columns.length;
            } else if (Objects.equals(tableName, "class")) {
                sql = "SELECT class.class_name,counsellor,toll,faculties " +
                        "FROM stm_sys.class " + "left join stm_sys.student s " +
                        "on s.class_id = class.class_id where s.student_id = " + id;//做为语句的承载
                columns = new String[]{"class_name", "counsellor", "toll", "faculties"};
                row=columns.length;
            } else if (Objects.equals(tableName, "score")) {
                sql = "SELECT student_id ,student_name,grade" +
                        ",java_score,`data structures and algorithms_score`" +
                        ",`probability theory_score`,`electronic technology_score`" +
                        ",mysql_score,`situation and policy_score`,sport_score,`marxist theory_score`" +
                        " FROM stm_sys.score where student_id = " + id;//做为语句的承载
                columns = new String[]{"student_id", "student_name", "gender"};
                row=columns.length;
            } else if (Objects.equals(tableName, "subject")) {
                sql = "SELECT student_id ,subject01_name,subject02_name, " +
                        ",subject03_name,subject04_name,subject05_name," +
                        "subject06_name,subject07_name,subject08_name,subject09_name," +
                        "FROM stm_sys.subjects where student_id = " + id;//做为语句的承载
                columns = new String[]{"subject_name", "subjects_textbook"};
                row=columns.length;
            }
//            else if (Objects.equals(tableName, "user")) {
//                sql = "SELECT user_id ,user_name,password,phoneNum FROM stm_sys.user where user_id = " + id;//做为语句的承载
//                columns = new String[]{"student_id", "student_name", "gender", "age", "grade", "sort"};
//                row=columns.length;
//            }
            else {
                System.out.println("输入的id无法识别！请重新输入！");
                return;
            }

            ResultSet rs = stmt.executeQuery(sql);//在此方法中传入sql语句以达到执行数据库操作的目的
            // 展开结果集数据库
            while(rs.next()){
                for (int i = 0; i < row-1; i++) {
                    System.out.print(rs.getString(columns[i]) + " ");
                }
            }
            // 完成后关闭
            rs.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            System.out.println("处理JDBC错误" + se.getMessage());
        }catch(Exception e){
            // 处理 Class.forName 错误
            System.out.println("处理Class.forName错误" + e.getMessage());
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
                // 什么都不做
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                System.out.println("处理数据库关闭错误" + se.getMessage());
            }
        }
        //System.out.println("Goodbye!");
    }
}

