import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixData = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixData[0];
        int cols = matrixData[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] rowData = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }

        int sum = getSum(rows, cols, matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int getSum(int rows, int cols, int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
}
