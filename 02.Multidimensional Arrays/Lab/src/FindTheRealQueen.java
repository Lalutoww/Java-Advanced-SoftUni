import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = 8;
        int cols = 8;

        char[][] chessTable = readMatrix(rows, cols, scan);

        for (int row = 0; row < chessTable.length; row++) {
            for (int col = 0; col < chessTable[row].length; col++) {
                char currentElement = chessTable[row][col];

                if (currentElement == 'q') {
                    if (check(chessTable, row, col)) {
                        System.out.print(row + " ");
                        System.out.print(col);

                    }

                }
            }
        }


    }

    private static char[][] readMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {

            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = line[col].charAt(0);
                matrix[row][col] = currentChar;
            }

        }


        return matrix;
    }

    private static boolean check(char[][] chessTable, int row, int col) {

        //Check the right horizontal line
        for (int i = col + 1; i < chessTable[row].length; i++) {
            char charToCheck = chessTable[row][i];

            if (charToCheck == 'q') {
                return false;
            }
        }

        //Check the left horizontal line
        for (int i = col - 1; i >= 0; i--) {
            char charToCheck = chessTable[row][i];

            if (charToCheck == 'q') {
                return false;
            }
        }

        //Check the down vertical line
        for (int i = row + 1; i < chessTable.length; i++) {
            char charToCheck = chessTable[i][col];

            if (charToCheck == 'q') {
                return false;
            }
        }

        //Check the up vertical line
        for (int i = row - 1; i >= 0; i--) {
            char charToCheck = chessTable[i][col];

            if (charToCheck == 'q') {
                return false;
            }
        }

        int upLeftElement = col - 1;

        //Check the Up Left Diagonal line
        for (int i = row - 1; i >= 0 && upLeftElement >= 0; i--, upLeftElement--) {
            char charToCheck = chessTable[i][upLeftElement];

            if (charToCheck == 'q') {
                return false;
            }
        }

        //Check the Up Right Diagonal line
        int upRightElement = col + 1;

        for (int i = row - 1; i >= 0 && upRightElement < chessTable[i].length; i--, upRightElement++) {
            char charToCheck = chessTable[i][upRightElement];

            if (charToCheck == 'q') {
                return false;
            }
        }


        //Check the Down Left Diagonal line
        int downLeftElement = col - 1;

        for (int i = row + 1; i < chessTable.length && downLeftElement >= 0; i++, downLeftElement--) {
            char charToCheck = chessTable[i][downLeftElement];

            if (charToCheck == 'q') {
                return false;
            }
        }

        //Check the Down Right Diagonal line
        int downRightElement = col + 1;

        for (int i = row + 1; i < chessTable.length && downRightElement < chessTable[row].length; i++, downRightElement++) {
            char charToCheck = chessTable[i][downRightElement];

            if (charToCheck == 'q') {
                return false;
            }
        }

        return true;
    }

}