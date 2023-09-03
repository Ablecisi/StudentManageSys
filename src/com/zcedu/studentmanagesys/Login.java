package com.zcedu.studentmanagesys;

import java.sql.*;
import java.util.Scanner;

public class Login {
    private int row = -1;
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void select(String user_name, String password){

        Connection con = null;
        Statement stm1 = null;
        Statement stm2 = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(getJDBC_DRIVER());
            // 打开链接
            //System.out.println("连接数据库...");
            con = DriverManager.getConnection(getDB_URL(),getUSER(),getPASS());
            // 执行查询
            //System.out.println("实例化Statement对象...");
            stm1 = con.createStatement();
            stm2 = con.createStatement();


            String sql1 = "SELECT user_name FROM stm_sys.user s WHERE user_name = " + "'" + user_name + "'";
            ResultSet rs1 = stm1.executeQuery(sql1);//在此方法中传入sql语句以达到执行数据库操作的目的

            String sql2 = "SELECT password FROM stm_sys.user s WHERE user_name = " + "'" + user_name + "'";
            ResultSet rs2 = stm2.executeQuery(sql2);//在此方法中传入sql语句以达到执行数据库操作的目的

            // 展开结果集数据库
//            System.out.println(rs1.next());
//            System.out.println(rs2.next());//测试
            if (rs1.next() && rs2.next()) {
                if (rs1.getString("user_name").equals(user_name) && rs2.getString("password").equals(password)){
                    setRow(1);
                }else {
                    System.out.println("密码或用户输入错误，请重新输入");
                    Regist.Regis();
                    setRow(0);
                }
            }else {
                System.out.println("未检测出该用户，请先注册");
                Regist.Regis();
                setRow(1);
            }
            // 完成后关闭
            rs1.close();
            rs2.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            System.out.println("处理JDBC错误" + se.getMessage());
        }catch(Exception e) {
            // 处理 Class.forName 错误
            System.out.println("处理Class.forName错误" + e.getMessage());
        }finally{
            // 关闭资源
            try{
                if(stm1!=null) stm1.close();
                if(stm2!=null) stm2.close();
            }catch(SQLException se2){
                // 什么都不做
            }
            try{
                if(con!=null) con.close();
            }catch(SQLException se){
                System.out.println("处理数据库关闭错误" + se.getMessage());
            }
        }
    }
    public static int login() {
        Scanner scan = new Scanner(System.in);
        Login log = new Login();
        boolean flag = true;
        boolean flag2 = true;
        do {
            do {
                System.out.println("请输入用户名:");
                String user_name = scan.next();
//                if (user_name.length() < 8) {
//                    System.out.println("用户名长度必须大于8");
//                    break;
//                }
                System.out.println("请输入密码:");
                String password = scan.next();
//                if (password.length() < 8) {
//                    System.out.println("密码长度必须大于8");
//                    break;
//                }
                log.select(user_name,password);
                return log.getRow();
            }while (flag2);
            //System.out.println("请重新输入");
        }while (flag);
        //return -1;
    }

}
