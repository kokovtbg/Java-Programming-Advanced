package MultidimensionalArrays.exercise;

import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        List<String> list = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            list.add(input);

            input = scan.nextLine();
        }
        int maxLength = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > maxLength) {
                maxLength = list.get(i).length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < maxLength) {
                String text = list.get(i);
                while (text.length() < maxLength) {
                    text += " ";
                }
                list.set(i, text);
            }
        }
        char[][] matrix = new char[list.size()][maxLength];
        for (int i = 0; i < list.size(); i++) {
            matrix[i] = list.get(i).toCharArray();
        }

        int degrees = Integer.parseInt(command.substring(7, command.indexOf(")")));
        //810 = 90 * 9 = 90 * (4 * 2 + 1)
        //360 = 90 * 4
        if (degrees / 90 % 4 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i]);
            }
        } else if (degrees / 90 % 4 == 3) {//270 = 90 * 3
            char[][] matrixToPrint = new char[maxLength][matrix.length];

            int count = 0;
            for (int i = matrixToPrint.length - 1; i >= 0; i--) {
                char[] chars = new char[matrix.length];
                for (int k = 0; k < matrix.length; k++) {
                    chars[k] = matrix[k][count];
                }
                matrixToPrint[i] = chars;
                count++;
                if (count == maxLength) {
                    break;
                }
            }
            for (int i = 0; i < matrixToPrint.length; i++) {
                for (int j = 0; j < matrixToPrint[0].length; j++) {
                    System.out.printf("%c", matrixToPrint[i][j]);
                }
                System.out.println();
            }
        } else if (degrees / 90 % 4 == 2) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = maxLength - 1; j >= 0; j--) {
                    System.out.printf("%c", matrix[i][j]);
                }
                System.out.println();
            }
        } else if (degrees / 90 % 4 == 1) {
            char[][] matrixToPrint = new char[maxLength][matrix.length];
            for (int i = 0; i < matrixToPrint.length; i++) {
                char[] chars = new char[matrix.length];
                int count = 0;
                for (int j = matrix.length - 1; j >= 0; j--) {
                    chars[count] = matrix[j][i];
                    count++;
                }
                matrixToPrint[i] = chars;
            }
            for (int i = 0; i < maxLength; i++) {
                for (int j = 0; j < matrixToPrint[0].length; j++) {
                    System.out.printf("%c", matrixToPrint[i][j]);
                }
                System.out.println();
            }
        }
    }
}
