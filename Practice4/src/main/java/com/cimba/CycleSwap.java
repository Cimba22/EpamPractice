package com.cimba;

class CycleSwap {

    static void cycleSwap(int[] array) {
        if(array.length != 0){
            int[] tmp = new int[array.length];

            for(int i = 0; i < array.length; i++) {
                int newPosition = (i + 1) % array.length;
                tmp[newPosition] = array[i];
            }
            System.arraycopy(tmp, 0, array, 0, tmp.length);
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if(array.length != shift && array.length != 0){
            int[] tmp = new int[array.length];

            for(int i = 0; i < array.length; i++) {
                int newPosition = (i + shift) % array.length;
                tmp[newPosition] = array[i];
            }
            System.arraycopy(tmp, 0, array, 0, tmp.length);

        }

    }
}

