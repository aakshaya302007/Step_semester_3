package main.java.JavaFundamentals.practise_problems;

import java.util.*;

public class PrimeNumberCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println("Is the number " + number + " a Prime number? " + isPrime);
        sc.close();
    }
}
