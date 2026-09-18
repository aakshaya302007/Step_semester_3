package main.java.OOPSFundamentals.practise_problems;

import java.util.*;

public class PlacementRankingEngine implements Comparable<PlacementRankingEngine> {

    private String name;
    private double cgpa;
    private int codingScore;

    public PlacementRankingEngine(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    @Override
    public int compareTo(PlacementRankingEngine other) {
        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    static String shortlistAndRank(PlacementRankingEngine[] candidates) {

        ArrayList<PlacementRankingEngine> shortlisted =
            new ArrayList<>();

        for (PlacementRankingEngine candidate : candidates) {

            if (isEligible(candidate.cgpa) ||
                isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted.add(candidate);
            }
        }

        PlacementRankingEngine[] shortlistedArray =
            shortlisted.toArray(
                new PlacementRankingEngine[0]
            );

        Arrays.sort(shortlistedArray);

        String result = "";

        for (int i = 0; i < shortlistedArray.length; i++) {

            result = result
                + (i + 1)
                + ". "
                + shortlistedArray[i].name
                + " ("
                + shortlistedArray[i].getCompositeScore()
                + ")";

            if (i < shortlistedArray.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        PlacementRankingEngine[] candidates = {

            new PlacementRankingEngine("Aisha", 8.2, 40),
            new PlacementRankingEngine("Rohit", 6.8, 65),
            new PlacementRankingEngine("Meena", 6.0, 90),
            new PlacementRankingEngine("Karan", 7.5, 20)
        };

        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}