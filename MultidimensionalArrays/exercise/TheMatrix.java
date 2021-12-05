package MultidimensionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        char fillChar = scan.nextLine().charAt(0);
        int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startRow = coordinates[0];
        int startCol = coordinates[1];
        char startChar = matrix[startRow][startCol];

        int currentRow = startRow;
        int currentCol = startCol;
        while (currentRow >= 0 && matrix[currentRow][currentCol] == startChar) {
//            matrix[currentRow][currentCol] = fillChar;
            currentRow--;
        }
        int beginIndexRow = currentRow + 1;
        if (startRow + 1 < rows) {
            currentRow = startRow + 1;
        } else {
            currentRow = startRow;
        }
        while (currentRow < rows && matrix[currentRow][currentCol] == startChar) {
//            matrix[currentRow][currentCol] = fillChar;
            currentRow++;
        }
        int endIndexRow = currentRow - 1;
        currentRow = startRow;


        while (currentCol >= 0 && matrix[currentRow][currentCol] == startChar) {
//            matrix[currentRow][currentCol] = fillChar;
            currentCol--;
        }
        int beginIndexCol = currentCol + 1;
        if (startCol + 1 < cols) {
            currentCol = startCol + 1;
        } else {
            currentCol = startCol;
        }
        while (currentCol < cols && matrix[currentRow][currentCol] == startChar) {
//            matrix[currentRow][currentCol] = fillChar;
            currentCol++;
        }
        int endIndexCol = currentCol - 1;
        currentCol = startCol;

        for (int i = beginIndexCol; i <= endIndexCol; i++) {
            for (int j = startRow; j < matrix.length - 1; j++) {
                if (matrix[j][i] == startChar && matrix[j + 1][i] == startChar) {
                    if (j + 1 > endIndexRow) {
                        endIndexRow = j + 1;
                    }
                } else {
                    break;
                }
            }
            if (endIndexRow == matrix.length - 1) {
                break;
            }
        }
        for (int i = beginIndexCol; i <= endIndexCol; i++) {
            for (int j = startRow; j > 0; j--) {
                if (matrix[j][i] == startChar && matrix[j - 1][i] == startChar) {
                    if (j - 1 < beginIndexRow) {
                        beginIndexRow = j - 1;
                    }
                } else {
                    break;
                }
            }
            if (beginIndexRow == 0) {
                break;
            }
        }
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = startCol; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] == startChar && matrix[i][j + 1] == startChar) {
                    if (j + 1 > endIndexCol) {
                        endIndexCol = j + 1;
                    }
                } else {
                    break;
                }
            }
            if (endIndexCol == matrix[0].length - 1) {
                break;
            }
        }
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = startCol; j > 0; j--) {
                if (matrix[i][j] == startChar && matrix[i][j - 1] == startChar) {
                    if (j - 1 < beginIndexCol) {
                        beginIndexCol = j - 1;
                    }
                } else {
                    break;
                }
            }
            if (beginIndexCol == 0) {
                break;
            }
        }
        for (int i = endIndexCol; i > 0; i--) {
            for (int j = beginIndexRow; j <= endIndexRow; j++) {
                if (matrix[j][i] == startChar && matrix[j][i - 1] == startChar) {
                    if (i - 1 < beginIndexCol) {
                        beginIndexCol = i - 1;
                    }
                } else {
                    break;
                }
            }
            if (beginIndexCol == 0) {
                break;
            }
        }
        for (int i = beginIndexCol; i <= endIndexCol; i++) {
            for (int j = startRow; j < matrix.length - 1; j++) {
                if (matrix[j][i] == startChar && matrix[j + 1][i] == startChar) {
                    if (j + 1 > endIndexRow) {
                        endIndexRow = j + 1;
                    }
                } else {
                    break;
                }
            }
            if (endIndexRow == matrix[0].length - 1) {
                break;
            }
        }
        for (int i = endIndexRow; i >= beginIndexRow; i--) {
            for (int j = endIndexCol; j > 0; j--) {
                if (matrix[i][j] == startChar && matrix[i][j - 1] == startChar) {
                    if (j - 1 < beginIndexCol) {
                        beginIndexCol = j - 1;
                    }
                } else {
                    break;
                }
            }
            if (beginIndexCol == 0) {
                break;
            }
        }
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = matrix[0].length - 1; j > beginIndexCol; j--) {
                if (matrix[i][j] == startChar && matrix[i][j - 1] == startChar) {
                    if (j > endIndexCol) {
                        endIndexCol = j;
                    }
                } else {
                    break;
                }
            }
            if (endIndexCol == matrix[0].length - 1) {
                break;
            }
        }
        for (int i = beginIndexRow; i < matrix.length; i++) {
            for (int j = endIndexCol; j > 0; j--) {
                if (matrix[i][j] == startChar && matrix[i][j - 1] == startChar) {
                    if (j - 1 < beginIndexCol) {
                        beginIndexCol = j - 1;
                    }
                } else {
                    break;
                }
            }
            if (beginIndexCol == 0) {
                break;
            }
        }
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = startCol; j > 0; j--) {
                if (matrix[i][j] == startChar && matrix[i][j - 1] == startChar) {
                    if (j - 1 < beginIndexCol) {
                        beginIndexCol = j - 1;
                    }
                } else {
                    break;
                }
            }
            if (beginIndexCol == 0) {
                break;
            }
        }
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = startCol; j > matrix[0].length - 1; j++) {
                if (matrix[i][j] == startChar && matrix[i][j + 1] == startChar) {
                    if (j + 1 > endIndexCol) {
                        endIndexCol = j + 1;
                    }
                } else {
                    break;
                }
            }
            if (endIndexCol == matrix[0].length - 1) {
                break;
            }
        }
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = startCol; j > 0; j--) {
                if (matrix[i][j] == startChar && matrix[i][j - 1] == startChar) {
                    if (j - 1 < beginIndexCol) {
                        beginIndexCol = j - 1;
                    }
                } else {
                    break;
                }
            }
            if (beginIndexCol == 0) {
                break;
            }
        }
        for (int i = beginIndexCol; i <= endIndexCol; i++) {
            for (int j = startRow; j > 0; j--) {
                if (matrix[j][i] == startChar && matrix[j - 1][i] == startChar) {
                    if (j - 1 < beginIndexRow) {
                        beginIndexRow = j - 1;
                    }
                } else {
                    break;
                }
            }
            if (beginIndexRow == 0) {
                break;
            }
        }
        for (int i = beginIndexCol; i <= endIndexCol; i++) {
            for (int j = startRow; j < matrix.length - 1; j++) {
                if (matrix[j][i] == startChar && matrix[j + 1][i] == startChar) {
                    if (j + 1 > endIndexRow) {
                        endIndexRow = j + 1;
                    }
                } else {
                    break;
                }
            }
            if (endIndexRow == matrix.length - 1) {
                break;
            }
        }
        char[][] matrix2 = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = matrix[i][j];
            }
        }
        fillMatrixRow(matrix, matrix2, fillChar, startChar, startRow, startCol, beginIndexRow, endIndexRow, beginIndexCol, endIndexCol);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%c", matrix2[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrixRow(char[][] matrix1, char[][] matrix2, char fillChar, char startChar, int startRow, int startCol, int beginIndexRow, int endIndexRow, int beginIndexCol, int endIndexCol) {
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = beginIndexCol; j <= endIndexCol; j++) {
                if (matrix1[i][j] == startChar) {
                    matrix2[i][j] = fillChar;
                } else {
                    break;
                }
            }
        }
        for (int i = endIndexRow; i >= beginIndexRow; i--) {
            for (int j = endIndexCol; j >= beginIndexCol; j--) {
                if (matrix1[i][j] == startChar) {
                    matrix2[i][j] = fillChar;
                } else {
                    break;
                }
            }
        }
        for (int i = beginIndexCol; i <= endIndexCol; i++) {
            for (int j = startRow; j >= 0; j--) {
                if (matrix1[j][i] == startChar) {
                    matrix2[j][i] = fillChar;
                } else {
                    break;
                }
            }
        }
        for (int i = beginIndexCol; i <= endIndexCol; i++) {
            for (int j = startRow; j < matrix1.length; j++) {
                if (matrix1[j][i] == startChar) {
                    matrix2[j][i] = fillChar;
                } else {
                    break;
                }
            }
        }
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = startCol; j >= 0; j--) {
                if (matrix1[i][j] == startChar) {
                    matrix2[i][j] = fillChar;
                } else {
                    break;
                }
            }
        }
        for (int i = beginIndexRow; i <= endIndexRow; i++) {
            for (int j = startCol; j < matrix1[0].length; j++) {
                if (matrix1[i][j] == startChar) {
                    matrix2[i][j] = fillChar;
                } else {
                    break;
                }
            }
        }

    }
}
