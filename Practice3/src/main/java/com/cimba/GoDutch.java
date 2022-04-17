package com.cimba;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scanner = new Scanner(System.in);

        int bill, valueOfFriends;

        if ((bill = scanner.nextInt()) < 0)
            System.out.println("Bill total amount cannot be negative");

        else if ((valueOfFriends = scanner.nextInt()) <= 0)
            System.out.println("Number of friends cannot be negative or zero");
        else{
            if(!(valueOfFriends>bill)){
                double tips = (bill/valueOfFriends)*0.1 ;
                System.out.println((int)(bill/valueOfFriends + tips));
            }else if(bill == 0) {
                System.out.println("0");
            }else {
                System.out.println("1");
            }
        }
    }
}
