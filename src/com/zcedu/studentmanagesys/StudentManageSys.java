package com.zcedu.studentmanagesys;
import java.util.Scanner;

public class StudentManageSys {
    public static void main(String[] args) {
        while (true) {
            Menu.printfMenu(); // 调用主菜单函数输出主菜单  
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();// 获取用户输入
            switch (input) {// 判断用户输入
                case "1" : {
                    if (Login.login() == 1) {//判断是否登陆成功
                        st_system.system();
                    }else {
                        System.out.println("登陆失败");
                    }
                    break;
                }
                case "2" : {
                    Regist.Regis();
                    break;
                }
                case "0" : {
                    System.out.println("退出成功");
                    System.exit(0);
                }
                default : {
                    System.out.println("输出错误，请重新输入！");
                    break;
                }
            }
        }
    }
}