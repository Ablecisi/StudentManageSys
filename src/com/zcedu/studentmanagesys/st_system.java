package com.zcedu.studentmanagesys;

import java.util.Scanner;

public class st_system {
    public static void  system(){
        System.out.println("欢迎使用学生管理系统");
        sys();
    }

    public static void sys() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("------------菜单------------");
            System.out.println("=============================");
            System.out.println("=1.学生端             2.教师端=");
            System.out.println("=3.退出系统                  =");
            System.out.println("=============================");
            System.out.println("请选择端：");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    do {
                        System.out.println("\n1.添加学生信息");
                        System.out.println("2.显示学生信息页面");
                        System.out.println("3.查询学生信息页面");
                        System.out.println("4.删除学生信息页面");
                        System.out.println("5.修改学生信息页面");
                        System.out.println("6.考试信息查询页面");
                        System.out.println("7.退出系统\n\n");
                        System.out.println("请选择功能：");
                        input = scanner.nextLine();

                        switch (input) {
                            case "1" -> {
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/ /*菜单*/
                                System.out.println("===============");
                                System.out.println("=添加学生信息页面=");
                                System.out.println("===============");
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/
                                //addStudent(WLW);
                            }//添加学生
                            case "2" -> {
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/ /*菜单*/
                                System.out.print("===============\n");
                                System.out.print("=显示学生信息页面=\n");
                                System.out.print("===============\n");
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/
                                //showStudent(WLW);
                            }//显示学生
                            case "3" -> {
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/ /*菜单*/
                                System.out.print("===============\n");
                                System.out.print("=查询学生信息页面=\n");
                                System.out.print("===============\n");
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/
                                //findStudent(WLW);//查询学生
                            }
                            case "4" -> {
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/ /*菜单*/
                                System.out.print("===============\n");
                                System.out.print("=删除学生信息页面=\n");
                                System.out.print("===============\n");
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/
                                //removeStudent(WLW);//删除学生
                            }
                            case "5" -> {
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/ /*菜单*/
                                System.out.print("===============\n");
                                System.out.print("=修改学生信息页面=\n");
                                System.out.print("===============\n");
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/
                                //changeStudent(WLW);//修改学生
                            }
                            case "6" -> {
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/ /*菜单*/
                                System.out.print("===================\n");
                                System.out.print("=查询学生考试信息页面=\n");
                                System.out.print("===================\n");
                                /*+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-*/
                                // (WLW);//查询学生考试信息
                            }
                            case "7" -> {
                                return;
                            }default -> System.out.println("输出错误，请重新输入！");

                        }
                    } while (!input.equals("7"));
                }
                case "2" -> System.out.println("\n      --系统还未开发--\n\n");
                default -> System.out.println("输出错误，请重新输入！");
            }
        } while (true);
    }
}