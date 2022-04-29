package com.cimba;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){

        //put your code here
        boolean[] checkResult = new boolean[array.length];

        checkResult[0] = false;
        checkResult[1] = false;

        for (int i = 2; i < array.length; i++) {
            if(array[i - 1] + array[i - 2] == array[i]){
                checkResult[i] = true;
            }else {
                checkResult[i] = false;
            }
        }
        return checkResult;


        //throw new UnsupportedOperationException();
    }
}

