package main.java.JavaFundamentals.practise_problems;

import java.util.*;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int original = n;
        int sum = 0;
        int digits = 0;

        int temp = n;

        while (temp > 0) {
            digits++;
            temp = temp / 10;
        }

        temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            sum = sum + (int)Math.pow(digit, digits);
            temp = temp / 10;
        }

        if (sum == original) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
        sc.close();
    }
}
