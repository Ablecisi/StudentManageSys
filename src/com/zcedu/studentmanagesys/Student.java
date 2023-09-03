package com.zcedu.studentmanagesys;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        MySQLDemo mySQLDemo = new MySQLDemo();
        Scanner scan = new Scanner(System.in);
        String student_id = scan.next();
        mySQLDemo.select(student_id,"student");
    }
}
