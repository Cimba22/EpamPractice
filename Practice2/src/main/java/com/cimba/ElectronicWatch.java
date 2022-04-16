package com.cimba;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int h, mm, ss;  // hours, minutes, seconds

        h = seconds % 86_400 / 3600;
        mm = seconds / 60 % 60;
        ss = seconds / 1 % 60;

        System.out.printf("%01d:%02d:%02d", h, mm, ss);

    }
}
