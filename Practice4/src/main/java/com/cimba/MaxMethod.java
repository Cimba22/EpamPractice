package com.cimba;

public class MaxMethod {
    public static int max(int[] values) {
        //throw new UnsupportedOperationException();
        int maxElement = values[0];
        for (int element: values) {
            if(maxElement < element){
                maxElement = element;
            }
        }
        return maxElement;
    }


    public static void main(String[] args) {
        int[] values = new int[]{ -2, 0, 10, 5 };
        int result = MaxMethod.max(values);
        System.out.println(result == 10);
    }
}
