package com.zcedu.studentmanagesys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SqlAction {
/**
    private String sql = null;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
*/
private static final String
    JDBC_DRIVER = "com.mysql.cj.jdbc.Driver",
    DB_URL      = "jdbc:mysql://localhost:3306",
    DB_USER     = "root",
    DB_PASS     = "root";

    public static void sqlSet(String sql, String cls){
        Connection con = null;
        PreparedStatement prs =  null;
        DataComparison dataComparison = new DataComparison();
        Scanner sc = new Scanner(System.in);
        MySQLDemo mySQLDemo = new MySQLDemo();

        String clsR =  cls.substring(cls.lastIndexOf(".")+1);
        //System.out.println(sql+" "+clsR);

        try {
            //加载驱动
            Class.forName(JDBC_DRIVER);
            //连接数据库
            con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASS);
            switch (clsR){
                case "ShowStudents" :{
                    System.out.println("请输入需查询的学生学号");
                    String st_id = sc.next();
                    //创建sql语句
                    mySQLDemo.select(st_id,"student");
                    System.out.println();
                    mySQLDemo.select(st_id,"class");
                    break;
                }
                case "b" :{

                }
                case "c" :{

                }
                default: {

                }

            }


        }catch (SQLException e){
            System.out.println("错误" + e.getMessage());
        }catch (Exception se){
            System.out.println("失败" + se.getMessage());
        }finally {
            try {
                if (prs != null) {
                    prs.close();
                }
            } catch (SQLException e) {
                System.out.println("什么也没发生");
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("数据库关闭失败" + e.getMessage());
            }
        }

    }




}
