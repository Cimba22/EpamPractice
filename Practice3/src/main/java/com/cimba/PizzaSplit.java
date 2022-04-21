package com.cimba;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder

        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = scanner.nextInt();
        int numberOfPieces = scanner.nextInt();

        System.out.println((lcm(numberOfPeople, numberOfPieces))/numberOfPieces);
    }

    public static int gcd(int numberOfPeople, int numberOfPieces) {
        if (numberOfPeople == 0 || numberOfPieces == 0) {
            return numberOfPeople + numberOfPieces;
        } else {
            int absNumberOfPeople = Math.abs(numberOfPeople);
            int absNumberOfPieces = Math.abs(numberOfPieces);
            int biggerValue = Math.max(absNumberOfPeople, absNumberOfPieces);
            int smallerValue = Math.min(absNumberOfPeople, absNumberOfPieces);
            return gcd(biggerValue % smallerValue, smallerValue);
        }
    }

    public static int lcm(int numberOfPeople, int numberOfPieces) {
        if (numberOfPeople == 0 || numberOfPieces == 0)
            return 0;
        else {
            int gcd = gcd(numberOfPeople, numberOfPieces);
            return Math.abs(numberOfPeople * numberOfPieces) / gcd;
        }
    }
}

