import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] matrixDimensions = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        String[][] matrix = createMatrix(rows, cols, sc);

        String command = sc.nextLine();

        while (!command.equals("END")) {
            if (isValid(command, rows, cols)) {
                String[] commandData = command.split("\\s+");

                int row1 = Integer.parseInt(commandData[1]);
                int col1 = Integer.parseInt(commandData[2]);
                int row2 = Integer.parseInt(commandData[3]);
                int col2 = Integer.parseInt(commandData[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            command = sc.nextLine();
        }
    }

    private static boolean isValid(String command, int rows, int cols) {
        String[] commandData = command.split("\\s+");
        if (commandData.length != 5) {
            return false;
        }

        if (!commandData[0].equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(commandData[1]);
        int col1 = Integer.parseInt(commandData[2]);
        int row2 = Integer.parseInt(commandData[3]);
        int col2 = Integer.parseInt(commandData[4]);

        return row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols;

    }

    private static String[][] createMatrix(int rows, int cols, Scanner sc) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] rowData = sc.nextLine().split("\\s+");
            matrix[row] = rowData;
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
