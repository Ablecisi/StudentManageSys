package com.zcedu.studentmanagesys;

import java.util.Scanner;

public class ShowStudents {
   public static void showStudents(){
       MySQLDemo mySQLDemo = new MySQLDemo();
       Scanner scanner = new Scanner(System.in);

       System.out.println("请输入需显示的学生学号");
       String st_id = scanner.next();
       //创建sql语句
       mySQLDemo.select(st_id,"student");
       System.out.println();
       mySQLDemo.select(st_id,"class");
       System.out.println();
   }
}
