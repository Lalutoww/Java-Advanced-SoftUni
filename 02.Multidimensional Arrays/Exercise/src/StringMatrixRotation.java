import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        //TODO: READ INPUT
        Scanner sc = new Scanner(System.in);
        int degrees = Integer.parseInt(sc.nextLine().split("[()]")[1]);


        //TODO: TURN THE TEXT INTO A MATRIX OF CHARACTERS (MUST BE RECTANGULAR, ADD SPACES IF NEEDED)
        String text = sc.nextLine();
        List<String> allWords = new ArrayList<>();

        while (!text.equals("END")) {
            allWords.add(text);
            text = sc.nextLine();
        }

        //? Gets the length of the longest word which lets you know how many spaces to add to each word in order to make the matrix rectangular
        int biggestWordLength = allWords.stream().sorted((a, b) -> Integer.compare(b.length(), a.length())).toList().getFirst().length();

        char[][] matrixOfWords = new char[allWords.size()][biggestWordLength];
        fillMatrix(allWords, matrixOfWords);

        //TODO: WRITE A METHOD WHICH ROTATES THE MATRIX BY DEGREES
        char[][] rotatedMatrix = rotateMatrix(degrees, matrixOfWords);

        //TODO: AFTER RECEIVING COMMAND "END" -> PRINT THE MATRIX
        printMatrix(rotatedMatrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(row);
        }
    }

    private static void fillMatrix(List<String> allWords, char[][] matrixOfWords) {
        for (int row = 0; row < matrixOfWords.length; row++) {
            String currentWord = allWords.get(row);
            for (int col = 0; col < matrixOfWords[row].length; col++) {
                if (col < currentWord.length()) {
                    matrixOfWords[row][col] = currentWord.charAt(col);
                } else {
                    matrixOfWords[row][col] = ' ';
                }
            }
        }
    }

    private static char[][] rotateMatrix(int degrees, char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] newMatrix;

        //? THIS ENSURES THAT ALL THE DEGREES ARE HANDLED CORRECTLY
        degrees %= 360;

        if (degrees == 90) {
            newMatrix = new char[cols][rows];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    newMatrix[col][rows - 1 - row] = matrix[row][col];
                }
            }
            return newMatrix;
        } else if (degrees == 180) {
            newMatrix = new char[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    newMatrix[rows - 1 - row][cols - 1 - col] = matrix[row][col];
                }
            }
            return newMatrix;
        } else if (degrees == 270) {
            newMatrix = new char[cols][rows];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    newMatrix[cols - 1 - col][row] = matrix[row][col];
                }
            }
            return newMatrix;
        } else {
            return matrix;
        }
    }
}
