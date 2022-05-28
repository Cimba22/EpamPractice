import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double x1 = 0, x2 = 0;
        double d = (b * b) - (4 * a * c);

        if (d < 0 ){
            System.out.println("no roots");
        }else if (d == 0){
            x1 = -b / (2 * a);
            System.out.printf("%2f",x1);
        }else {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.printf("%2f %2f", x1, x2);
        }

    }

}