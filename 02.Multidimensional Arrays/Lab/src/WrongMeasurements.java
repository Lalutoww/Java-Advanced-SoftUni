import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] inputMatrix = new int[n][];

        for (int row = 0; row < n; row++) {
            int[] rowData = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            inputMatrix[row] = rowData;
        }

        int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = coordinates[0];
        int y = coordinates[1];
        int wrongValue = inputMatrix[x][y];

        int[][] resultMatrix = new int[n][];

        for (int row = 0; row < n; row++) {
            resultMatrix[row] = inputMatrix[row].clone();
        }


        for (int row = 0; row < n; row++) {
            for (int col = 0; col < inputMatrix[row].length; col++) {
                if (resultMatrix[row][col] == wrongValue) {
                    resultMatrix[row][col] = getSum(inputMatrix, row, col, wrongValue);
                }
            }
        }

        printResultMatrix(resultMatrix);
    }

    private static void printResultMatrix(int[][] resultMatrix) {
        for (int row = 0; row < resultMatrix.length; row++) {
            for (int col = 0; col < resultMatrix[row].length; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] inputMatrix, int row, int col, int wrongValue) {
        int sum = 0;

        if (row - 1 >= 0 && inputMatrix[row - 1][col] != wrongValue) {
            sum += inputMatrix[row - 1][col];
        }
        if (row + 1 < inputMatrix.length && inputMatrix[row + 1][col] != wrongValue) {
            sum += inputMatrix[row + 1][col];
        }
        if (col - 1 >= 0 && inputMatrix[row][col - 1] != wrongValue) {
            sum += inputMatrix[row][col - 1];
        }
        if (col + 1 < inputMatrix[row].length && inputMatrix[row][col + 1] != wrongValue) {
            sum += inputMatrix[row][col + 1];
        }
        return sum;
    }
}
