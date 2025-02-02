import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[][] parkingLot = createParkingLot(sc);

        String command = sc.nextLine();

        while (!command.equals("stop")) {
            int[] coordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = coordinates[0];
            int positionRow = coordinates[1];
            int positionCol = coordinates[2];

            int distance = Math.abs(entryRow - positionRow) + 1;
            int tempColLeft = 0 >= positionCol - 1 ? 1 : positionCol - 1;
            int tempColRight = positionCol + 1 >= parkingLot[0].length - 1 ? positionCol : positionCol + 1;

            while (parkingLot[positionRow][tempColLeft]) {
                if (tempColLeft == 0) {
                    break;
                }
                tempColLeft--;
            }

            while (parkingLot[positionRow][tempColRight]) {
                if (tempColRight == parkingLot[0].length - 1) {
                    break;
                }
                tempColRight++;
            }

            if (isRowFull(positionRow, parkingLot)) {
                System.out.printf("Row %d full\n", positionRow);
                command = sc.nextLine();
                continue;
            }

            if (!parkingLot[positionRow][positionCol]) {
                parkingLot[positionRow][positionCol] = true;
                distance += positionCol;
                System.out.println(distance);
                command = sc.nextLine();
                continue;
            } else {
                if ((positionCol - tempColLeft) > (Math.abs(tempColRight - positionCol))) {
                    positionCol = tempColRight;
                } else {
                    positionCol = tempColLeft;
                }
            }

            if (positionCol <= 1 && parkingLot[positionRow][positionCol]) {
                positionCol = tempColRight;
            }

            if (parkingLot[positionRow][positionCol] && tempColRight == parkingLot[0].length - 1) {
                positionCol = tempColLeft;
            }

            parkingLot[positionRow][positionCol] = true;
            distance += positionCol;
            System.out.println(distance);

            command = sc.nextLine();
        }
    }

    public static boolean isRowFull(int row, boolean[][] parkingLot) {

        for (int col = 1; col < parkingLot[0].length; col++) {
            if (!parkingLot[row][col]) {
                return false;
            }
        }

        return true;
    }

    private static boolean[][] createParkingLot(Scanner sc) {
        int[] parkingLotData = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        boolean[][] parkingLot = new boolean[parkingLotData[0]][parkingLotData[1]];
        for (int row = 0; row < parkingLot.length; row++) {
            parkingLot[row][0] = true;
        }

        return parkingLot;
    }
}