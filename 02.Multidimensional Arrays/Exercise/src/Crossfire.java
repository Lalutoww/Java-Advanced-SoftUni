import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<Integer>> matrix = readMatrix(sc);

        String input = sc.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] tokens = input.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            matrix = processExplosion(matrix, row, col, radius);

            input = sc.nextLine();
        }

        printResult(matrix);
    }

    private static List<List<Integer>> readMatrix(Scanner sc) {

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(count++);
            }
            matrix.add(row);
        }

        return matrix;
    }

    private static List<List<Integer>> processExplosion(List<List<Integer>> matrix, int row, int col, int radius) {
        List<List<Integer>> newMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> newRow = new ArrayList<>();
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (!((i >= row - radius && i <= row + radius && j == col) ||
                        (j >= col - radius && j <= col + radius && i == row))) {
                    newRow.add(matrix.get(i).get(j));
                }
            }
            if (!newRow.isEmpty()) {
                newMatrix.add(newRow);
            }
        }
        return newMatrix;
    }

    private static void printResult(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
