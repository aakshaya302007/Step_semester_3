package main.java.Programming_with_String.practise_problems;

import java.util.*;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        if (original.length() == typed.length()) {
            double accuracy = (matched * 100.0) / original.length();

            if (firstMismatch == -1) {
                System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                        matched, original.length(), accuracy);
            } else {
                System.out.printf(
                        "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                        matched, original.length(), accuracy,
                        firstMismatch + 1,
                        original.charAt(firstMismatch),
                        typed.charAt(firstMismatch));
            }
        } else {
            int total = Math.max(original.length(), typed.length());
            double accuracy = (matched * 100.0) / total;

            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | Lengths are different%n",
                    matched, total, accuracy);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);
        sc.close();
    }
}
