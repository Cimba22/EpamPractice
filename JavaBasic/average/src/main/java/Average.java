import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        ArrayList<Integer> array = new ArrayList<>();
        int number;
        do {
            number = scanner.nextInt() ;
            if(number == 0){
                continue;
            }else{
                array.add(number);
            }

        }while (number != 0);

        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println(sum / array.size());

    }

}