package com.cimba;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        Scanner scanner = new Scanner(System.in);

        int a;
        a = scanner.nextInt();
        int b;
        b = scanner.nextInt();
        int h;
        h = scanner.nextInt();


        int days = 0;
        if (h <= 0 || (b == a && a < h) || (b > a && a < h)) {
            System.out.println("Impossible");
        }else if (h - a <= 0){
            System.out.println("1");
        }else {
            for (int i = 0; ; i -= b) {
                i += a;
                ++days;
                if (i >= h) {
                    System.out.println("Impossible");
                    break;
                }
            }
            System.out.println(days);
        }

    }
}
