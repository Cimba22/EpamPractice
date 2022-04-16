package com.cimba;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        //put you code here
        Scanner scanner = new Scanner(System.in);
        int password = scanner.nextInt();

        switch (password){
            case PASSWORD:
                System.out.println("Hello, Agent");
                break;
            default:
                System.out.println("Access denied");
        }

    }
}
