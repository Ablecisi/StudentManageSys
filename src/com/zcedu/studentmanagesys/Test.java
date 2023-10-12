package com.zcedu.studentmanagesys;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        //String sc =  scan.next();
        String b = bf.readLine();
        int a = b.lastIndexOf('\n');
        String c = b.substring((b.length()));
        System.out.println(b.length() +" "+ a );
        System.out.println(c.length());
    }
}