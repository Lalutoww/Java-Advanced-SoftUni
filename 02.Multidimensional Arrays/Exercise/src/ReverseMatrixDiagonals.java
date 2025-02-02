import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];
        int[][] matrix = createMatrix(sc, rows);

        for (int col = cols - 1; col >= 0; col--) {
            int rowIndex = rows - 1;
            for (int currentCol = col; currentCol < cols && rowIndex >= 0; currentCol++) {
                System.out.print(matrix[rowIndex--][currentCol] + " ");
            }
            System.out.println();
        }

        for (int row = rows - 2; row >= 0; row--) {
            int rowIndex = row;
            for (int col = 0; col <= row && col < cols; col++) {
                System.out.print(matrix[rowIndex--][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createMatrix(Scanner sc, int rows) {

        int[][] matrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            int[] rowData = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }

        return matrix;
    }
}
