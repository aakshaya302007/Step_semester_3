package main.java.Programming_with_String.practise_problems;

import java.util.*;

class BMICalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    static void printWellnessReport(double[] h, double[] w) {
        System.out.println("Person\tHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < h.length; i++) {
            double bmi = w[i] / (h[i] * h[i]);

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
                    i + 1, h[i], w[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] height = new double[5];
        double[] weight = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter height and weight: ");
            height[i] = sc.nextDouble();
            weight[i] = sc.nextDouble();
        }

        printWellnessReport(height, weight);
        sc.close(); 
    }
}