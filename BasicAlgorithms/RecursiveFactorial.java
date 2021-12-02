package BasicAlgorithms;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        System.out.println(recursiveFactorial(number));
    }

    public static long recursiveFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * recursiveFactorial(number - 1);
    }
}
