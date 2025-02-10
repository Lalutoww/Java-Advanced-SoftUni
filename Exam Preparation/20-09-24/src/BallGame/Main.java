package BallGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> strengthValues = new ArrayList<>(Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toList());
        List<Integer> accuracyValues = new ArrayList<>(Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toList());

        int goals = 0;
        while (!strengthValues.isEmpty() && !accuracyValues.isEmpty()) {
            int strengthValue = strengthValues.getLast();
            int accuracyValue = accuracyValues.getFirst();
            int sum = strengthValue + accuracyValue;

            if (sum == 100) {
                goals++;
                strengthValues.removeLast();
                accuracyValues.removeFirst();
            } else if (sum < 100) {
                if (strengthValue < accuracyValue) {
                    strengthValues.removeLast();
                } else if (accuracyValue < strengthValue) {
                    accuracyValues.removeFirst();
                } else {
                    strengthValues.set(strengthValues.size() - 1, sum);
                    accuracyValues.removeFirst();
                }
            } else {
                strengthValues.set(strengthValues.size() - 1, strengthValue - 10);
                accuracyValues.removeFirst();
                accuracyValues.addLast(accuracyValue);
            }
        }
        if (goals == 3) {
            System.out.println("Paul scored a hat-trick!");
            System.out.println("Goals scored: " + goals);
        } else if (goals == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (goals > 3) {
            System.out.println("Paul performed remarkably well!");
            System.out.println("Goals scored: " + goals);
        } else {
            System.out.println("Paul failed to make a hat-trick.");
            System.out.println("Goals scored: " + goals);

        }

        if (!strengthValues.isEmpty()) {
            System.out.println("Strength values left: " + String.join(", ", strengthValues.stream().map(String::valueOf).toList()));
        } else if (!accuracyValues.isEmpty()) {
            System.out.println("Accuracy values left: " + String.join(", ", accuracyValues.stream().map(String::valueOf).toList()));
        }
    }
}
