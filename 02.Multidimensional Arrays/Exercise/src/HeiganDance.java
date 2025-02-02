import java.util.Scanner;

public class HeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double heiganHealth = 3000000;

        int playerHealth = 18500;
        int playerRow = 7;
        int playerCol = 7;
        double playerDamage = Double.parseDouble(sc.nextLine());

        boolean isActiveCloud = false;
        String lastSpell = "";


        while (playerHealth > 0) {
            heiganHealth -= playerDamage;

            if (isActiveCloud) {
                playerHealth -= 3500;
                isActiveCloud = false;
                if (playerHealth <= 0) {
                    break;
                }
            }

            if (heiganHealth <= 0) {
                break;
            }

            String input = sc.nextLine();
            String[] tokens = input.split("\\s+");
            String spell = tokens[0];
            int spellRow = Integer.parseInt(tokens[1]);
            int spellCol = Integer.parseInt(tokens[2]);

            boolean[][] spellInGameField = createSpellInGameField(spellRow, spellCol);

            if (spellInGameField[playerRow][playerCol]) {
                if (isAbleToMoveUpDown(spellInGameField, playerRow - 1) && !spellInGameField[playerRow - 1][playerCol]) {
                    playerRow--;
                } else if (isAbleToMoveRightLeft(spellInGameField, playerCol + 1) && !spellInGameField[playerRow][playerCol + 1]) {
                    playerCol++;
                } else if (isAbleToMoveUpDown(spellInGameField, playerRow + 1) && !spellInGameField[playerRow + 1][playerCol]) {
                    playerRow++;
                } else if (isAbleToMoveRightLeft(spellInGameField, playerCol - 1) && !spellInGameField[playerRow][playerCol - 1]) {
                    playerCol--;
                }


                if (spellInGameField[playerRow][playerCol]) {
                    if (spell.equals("Cloud")) {
                        playerHealth -= 3500;
                        isActiveCloud = true;
                        lastSpell = "Plague Cloud";

                    } else if (spell.equals("Eruption")) {
                        playerHealth -= 6000;
                        lastSpell = spell;
                    }
                }
            }
        }

        System.out.println(heiganHealth > 0 ? String.format("Heigan: %.2f", heiganHealth) : "Heigan: Defeated!");
        System.out.println(playerHealth > 0 ? "Player: " + playerHealth : "Player: Killed by " + lastSpell);
        System.out.printf("Final position: %d, %d", playerRow, playerCol);

    }

    private static boolean[][] createSpellInGameField(int spellPositionRow, int spellPositionCol) {

        boolean[][] spellInGameField = new boolean[15][15];
        for (int i = spellPositionRow - 1; i <= spellPositionRow + 1; i++) {
            if (validateIndex(i, spellInGameField)) {
                for (int j = spellPositionCol - 1; j <= spellPositionCol + 1; j++) {
                    if (validateIndex(i, j, spellInGameField)) {
                        spellInGameField[i][j] = true;
                    }
                }
            }
        }

        return spellInGameField;
    }

    private static boolean isAbleToMoveUpDown(boolean[][] spellInGameField, int playerRow) {

        return playerRow >= 0 && playerRow < spellInGameField[playerRow].length;
    }

    private static boolean isAbleToMoveRightLeft(boolean[][] spellInGameField, int playerCol) {

        return playerCol >= 0 && playerCol < spellInGameField.length;
    }

    private static boolean validateIndex(int row, int col, boolean[][] spellInGameField) {

        return col >= 0 && col < spellInGameField[row].length;
    }

    private static boolean validateIndex(int row, boolean[][] spellInGameField) {

        return row >= 0 && row < spellInGameField.length;
    }
}
