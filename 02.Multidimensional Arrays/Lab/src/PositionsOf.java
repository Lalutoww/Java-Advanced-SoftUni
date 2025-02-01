import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixData[0];
        int cols = matrixData[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] rowData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowData;
        }

        int numberToSearch = Integer.parseInt(sc.nextLine());
        boolean haveFound = searchMatrix(matrix, numberToSearch);

        if (!haveFound) {
            System.out.println("not found");
        }
    }

    private static boolean searchMatrix(int[][] matrix, int numberToSearch) {
        boolean haveFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberToSearch) {
                    System.out.printf("%d %d %n", row, col);
                    haveFound = true;
                }
            }
        }
        return haveFound;
    }
}
