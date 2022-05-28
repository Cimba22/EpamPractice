package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){

        //put your code here
        List <Integer> localMax = new ArrayList<>();

        //fist element
        if(array[0] <= array[1] )
            localMax.add(array[0]);

        for (int i = 1; i < array.length - 1; i++) {
             if ((array[i] <= array[i + 1]) || (array[i] <= array[i - 1]))
                localMax.add(array[i]);
        }
        //last element
        if (array[array.length - 1] <= array[array.length - 2])
            localMax.add(array[array.length - 1]);


        int[] result = new int[localMax.size()];

        for (int i = 0; i < localMax.size(); i++) {
            result[i] = localMax.get(i);
        }
        return result;
        //throw new UnsupportedOperationException();
    }
}
