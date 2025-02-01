import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        String[][] firstMatrix = createMatrix(rows, cols, sc);
        String[][] secondMatrix = createMatrix(rows, cols, sc);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String firstMatrixElement = firstMatrix[row][col];
                String secondMatrixElement = secondMatrix[row][col];
                if (firstMatrixElement.equals(secondMatrixElement)) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static String[][] createMatrix(int rows, int cols, Scanner sc) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] rowData = sc.nextLine().split("\\s+");
            matrix[row] = rowData;
        }
        return matrix;
    }
}
