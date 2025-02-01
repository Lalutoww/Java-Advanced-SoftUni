import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] firstMatrixData = sc.nextLine().split("\\s+");
        int[][] firstMatrix = createNewMatrix(sc, firstMatrixData);

        String[] secondMatrixData = sc.nextLine().split("\\s+");
        int[][] secondMatrix = createNewMatrix(sc, secondMatrixData);

        if (checkIfMatricesAreEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean checkIfMatricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                int firstMatrixElement = firstMatrix[row][col];
                int secondMatrixElement = secondMatrix[row][col];

                if (firstMatrixElement != secondMatrixElement) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] createNewMatrix(Scanner sc, String[] matrixData) {
        int matrixRows = Integer.parseInt(matrixData[0]);
        int matrixCols = Integer.parseInt(matrixData[1]);
        int[][] matrix = new int[matrixRows][matrixCols];

        for (int row = 0; row < matrixRows; row++) {
            int[] rowData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }
        return matrix;
    }
}
