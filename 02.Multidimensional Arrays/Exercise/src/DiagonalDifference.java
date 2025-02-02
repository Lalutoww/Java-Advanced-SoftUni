import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = fillMatrix(n, sc);

        int sumPrimaryDiagonal = getSumOfPrimaryDiagonal(matrix);

        int sumSecondaryDiagonal = getSumOfSecondaryDiagonal(matrix);

        int difference = Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal);
        System.out.println(difference);
    }

    private static int getSumOfSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - 1 - row) {
                    sum += matrix[row][col];
                }
            }

        }
        return sum;
    }

    private static int getSumOfPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int[][] fillMatrix(int n, Scanner sc) {
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] rowData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }

        return matrix;
    }
}
