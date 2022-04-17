package com.cimba;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        int value = scanner.nextInt();

        //String name;

        if (value == 0) {
            System.out.println("Oh, it looks like there is no one here");
        }else if(value < 0) {
            System.out.println("Seriously? Why so negative?");
        }else {
            String[] name = new String[value];
            for (int i = 0; i < value; i++ ) {
                name[i] = scan.nextLine();
            }

            for (int i = 0; i < value; i++) {
                System.out.println("Hello, " + name[i]);
            }

        }






    }
}
