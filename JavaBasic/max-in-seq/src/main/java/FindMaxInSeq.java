import java.util.*;

public class FindMaxInSeq {
    public static int max() {

        // Put your code here
        Scanner scanner = new Scanner(System.in);
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



        return Collections.max(array);
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
