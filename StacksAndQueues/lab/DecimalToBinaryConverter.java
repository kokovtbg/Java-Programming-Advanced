package StacksAndQueues.lab;

import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        if (number == 0) {
            System.out.println("0");
        }
        StringBuilder binaryNumberLastToFirst = new StringBuilder();
        while (number != 0) {
            double numberToManipulate = number * 1.0 / 2;
            String numberString = numberToManipulate + "";
            if (numberString.charAt(numberString.indexOf(".") + 1) == '0') {
                binaryNumberLastToFirst.append("0");
            } else {
                binaryNumberLastToFirst.append("1");
            }
            number /= 2;
        }
        StringBuilder binaryNumber = new StringBuilder();
        for (int i = binaryNumberLastToFirst.toString().length() - 1; i >= 0; i--) {
            binaryNumber.append(binaryNumberLastToFirst.toString().charAt(i));
        }
        System.out.println(binaryNumber);
    }
}
