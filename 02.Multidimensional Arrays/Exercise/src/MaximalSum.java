import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixData[0];
        int cols = matrixData[1];

        int[][] matrix = fillMatrix(rows, cols, sc);

        Map<int[][], Integer> matricesSum = getMatricesSum(rows, cols, matrix);

        //? Sort the entries by sum and get the first one (with the biggest sum)
        Map.Entry<int[][], Integer> maxSumMatrix = matricesSum.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).toList().getFirst();


        System.out.println("Sum = " + maxSumMatrix.getValue());
        printMatrix(maxSumMatrix.getKey());
    }

    private static int[][] fillMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] rowData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }

        return matrix;
    }

    private static Map<int[][], Integer> getMatricesSum(int rows, int cols, int[][] matrix) {
        Map<int[][], Integer> matricesSum = new LinkedHashMap<>();
        //? 5rows -> iterates only to the 3rd row; 4rows -> iterates only to the 2nd row; etc...
        for (int row = 0; row < (rows - 3) + 1; row++) {
            //? 5columns -> iterates only to the 3rd col; 4columns -> iterates only to the 2nd col; etc...
            for (int col = 0; col < (cols - 3) + 1; col++) {
                int sum;
                int[][] currentMatrix = new int[3][3];
                //?This has to be done because it creates a new matrix every single row
                //?so I have to put the elements before a new matrix is created
                currentMatrix[0][0] = matrix[row][col];
                currentMatrix[0][1] = matrix[row][col + 1];
                currentMatrix[0][2] = matrix[row][col + 2];
                currentMatrix[1][0] = matrix[row + 1][col];
                currentMatrix[1][1] = matrix[row + 1][col + 1];
                currentMatrix[1][2] = matrix[row + 1][col + 2];
                currentMatrix[2][0] = matrix[row + 2][col];
                currentMatrix[2][1] = matrix[row + 2][col + 1];
                currentMatrix[2][2] = matrix[row + 2][col + 2];

                sum = currentMatrix[0][0] + currentMatrix[0][1] + currentMatrix[0][2] + currentMatrix[1][0] + currentMatrix[1][1] + currentMatrix[1][2] + currentMatrix[2][0] + currentMatrix[2][1] + currentMatrix[2][2];

                matricesSum.put(currentMatrix, sum);
            }
        }
        return matricesSum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

