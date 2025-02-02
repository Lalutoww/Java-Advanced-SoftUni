import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        String[][] palindromeMatrix = new String[rows][cols];

        fillPalindromeMatrix(palindromeMatrix);

        printMatrix(palindromeMatrix);
    }

    private static void fillPalindromeMatrix(String[][] palindromeMatrix) {
        char startingElement = 'a';
        for (int row = 0; row < palindromeMatrix.length; row++) {
            for (int col = 0; col < palindromeMatrix[row].length; col++) {
                char middleElement = (char) (startingElement + col);
                String palindrome = "" + startingElement + middleElement + startingElement;
                palindromeMatrix[row][col] = palindrome;
            }
            startingElement = (char) (startingElement + 1);
        }
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
