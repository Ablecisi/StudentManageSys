package com.zcedu.studentmanagesys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddStudents {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver",
            DB_URL = "jdbc:mysql://localhost:3306",
            DB_USER = "root",
            DB_PASS = "root";

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASS() {
        return DB_PASS;
    }
    public static void addstudent(){
        DataComparison dataComparison = new DataComparison();
        Scanner scan = new Scanner(System.in);
        AddStudents ads = new AddStudents();
        System.out.println("请输入学生学号：");
        String stu_id = scan.nextLine();
        if(dataComparison.compareDataWithDatabase("student",stu_id, "student_id")){
            System.out.println("学生已经存在，请重新输入");
            return;
        }
        System.out.println("请输入学生姓名：");
        String stu_name = scan.nextLine();
        System.out.println("请输入学生性别：");
        String stu_sex = scan.nextLine();
        System.out.println("请输入学生年龄：");
        String stu_age = scan.nextLine();
        System.out.println("请输入学生班级：");
        String stu_class = scan.nextLine();
        ads.addStudents(stu_id,stu_name,stu_sex,stu_age,stu_class);

    }
    public void addStudents(String stu_id,String stu_name,String stu_sex,String stu_age,String stu_class){
        Connection conn =  null;
        PreparedStatement prs =  null;
        DataComparison dataComparison = new DataComparison();

        String class_id = String.valueOf((int)(Math.random()*(100000)));
        //String user_id = String.valueOf((r.longs()));
        if (dataComparison.compareDataWithDatabase("student", class_id , "class_id")) {
            class_id = String.valueOf((int)(Math.random()*100000));
            //user_id = String.valueOf((r.longs()));
        }
        String sql = "insert into stm_sys.student(student_id, student_name, gender, age, class_id, class_name) " +
                "VALUES (" + "'" +stu_id+ "'" + ", "+ "'"+stu_name+"'" +", " +"'"+stu_sex+"'"+ ", " +"'" +stu_age+ "'"+", " +"'" +class_id+ "'"+ ", " +"'" +stu_class+ "'"+ ")";
        try {
            //加载驱动
            Class.forName(getJDBC_DRIVER());
            //连接数据库
            conn = DriverManager.getConnection(getDB_URL(),getDB_USER(), getDB_PASS());
            prs = conn.prepareStatement(sql);
            prs.executeUpdate();

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
                //
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("数据库关闭失败" + e.getMessage());
            }
        }

    }

}
