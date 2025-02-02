import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);

        switch (pattern) {
            case 'A' -> {
                int[][] matrix = fillPatternA(n);
                printMatrix(matrix);
            }
            case 'B' -> {
                int[][] matrix = fillPatternB(n);
                printMatrix(matrix);
            }
        }
    }

    private static int[][] fillPatternA(int n) {
        int[][] matrix = new int[n][n];
        int startingElement = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = startingElement;
                startingElement++;
            }
        }
        return matrix;
    }

    private static int[][] fillPatternB(int n) {
        int[][] matrix = new int[n][n];
        int startingElement = 1;

        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = startingElement;
                    startingElement++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = startingElement;
                    startingElement++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
