package com.zcedu.studentmanagesys;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Regist extends Login{
    public static void Regis() {
        Regist log = new Regist();
        DataComparison dataComparison = new DataComparison();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入注册账号：");
        String user_name = sc.next();
        if (dataComparison.compareDataWithDatabase("user",user_name,"user_name")) {
            System.out.println("该账号已存在，请重新输入！");
            Regist.Regis();
        }
        System.out.println("请输入密码：");
        String password = sc.next();
        System.out.println("请再次输入密码：");
        String password1 = sc.next();
        System.out.println("请输入手机号码：");
        long phoneNum = sc.nextLong();
        if (phoneNum >= 99999999999L) {
            System.out.println("请输入正确的手机号码！");
            Regis();
        }
        if (password.equals(password1)) {
            log.regist(user_name, password, phoneNum);
            System.out.println("注册成功！");
        } else {
            System.out.println("两次密码输入不一致，请重新输入！");
            Regis();
        }
    }
    public void regist(String user_name, String password, long phoneNum){
        Connection co = null;
        PreparedStatement prs = null;
        Random r = new Random();
        DataComparison dataComparison = new DataComparison();
        try {
            Class.forName(getJDBC_DRIVER());
            co = DriverManager.getConnection(getDB_URL(), getUSER(), getPASS());

            String user_id = String.valueOf((int)(Math.random()*(1000000000)));
            //String user_id = String.valueOf((r.longs()));
            if (dataComparison.compareDataWithDatabase("user", user_id, "user_id")) {
                user_id = String.valueOf((int)(Math.random()*1000000000));
                //user_id = String.valueOf((r.longs()));
            }

            String sql = ("INSERT INTO stm_sys.user (user_id, user_name, password, phoneNum)  " +
                    "VALUES (" + "'" +user_id+ "'" + ", "+ "'"+user_name+"'" +", " +"'"+password+"'"+ ", " +"'" +phoneNum+ "'"+")" );
            //System.out.println(sql);测试
            prs = co.prepareStatement(sql);
            prs.executeUpdate();
            //System.out.println(prs);测试

        }catch (SQLException e){
            System.out.println("处理JDBC错误" +e.getMessage());
        }catch (Exception se){
            System.out.println("处理Class.forName错误" +se.getMessage());
        }finally {
            try {
                if (co!=null) co.close();
            }catch (SQLException e){
                System.out.println("关闭连接错误" +e.getMessage());
            }
            try {
                if (prs!=null) prs.close();
            }catch (SQLException se){
                //什么都不做
            }
        }

    }
}
