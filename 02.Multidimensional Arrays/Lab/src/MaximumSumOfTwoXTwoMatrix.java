import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumSumOfTwoXTwoMatrix {
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

        Map<int[][], Integer> allMatricesSum = getMatricesSum(rows, cols, matrix);

        Map.Entry<int[][], Integer> maxSumMatrix = allMatricesSum.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .toList().getFirst();

        printOutput(maxSumMatrix);
    }

    private static void printOutput(Map.Entry<int[][], Integer> maxSumMatrix) {
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(maxSumMatrix.getKey()[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSumMatrix.getValue());
    }

    private static Map<int[][], Integer> getMatricesSum(int rows, int cols, int[][] matrix) {
        Map<int[][], Integer> allMatricesSum = new LinkedHashMap<>();

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int[][] currentMatrix = new int[2][2];
                currentMatrix[0][0] = matrix[row][col];
                currentMatrix[0][1] = matrix[row][col + 1];
                currentMatrix[1][0] = matrix[row + 1][col];
                currentMatrix[1][1] = matrix[row + 1][col + 1];

                int sum = currentMatrix[0][0] + currentMatrix[0][1] + currentMatrix[1][0] + currentMatrix[1][1];
                allMatricesSum.put(currentMatrix, sum);
            }
        }
        return allMatricesSum;
    }
}
