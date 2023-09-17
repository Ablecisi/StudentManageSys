package com.zcedu.studentmanagesys;

import java.util.Scanner;

public class ShowStudents {
   public static void showStudents(){
       MySQLDemo mySQLDemo = new MySQLDemo();
       DataComparison dataComparison = new DataComparison();
       Scanner scanner = new Scanner(System.in);

       System.out.println("请输入需显示的学生学号");
       String st_id = scanner.next();
       if(dataComparison.compareDataWithDatabase("student",st_id,"student_id")) {
           //创建sql语句
           mySQLDemo.select(st_id, "student");
           System.out.println();
           mySQLDemo.select(st_id, "class");
           System.out.println();
       }else{
           System.out.println("学号不存在,请重新输入");
           showStudents();
       }
   }
}
