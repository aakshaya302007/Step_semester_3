package main.java.OOPSFundamentals.assignment_problems;

import java.util.*;

public class FantasyDraftRanking implements Comparable<FantasyDraftRanking> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public FantasyDraftRanking(String name, int matchesPlayed,
                               double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(FantasyDraftRanking other) {
        return Double.compare(
            other.battingAverage,
            this.battingAverage
        );
    }

    static String draftAndRank(FantasyDraftRanking[] players) {

        ArrayList<FantasyDraftRanking> draftable =
            new ArrayList<>();

        for (FantasyDraftRanking player : players) {

            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed, player.injured)) {

                draftable.add(player);
            }
        }

        FantasyDraftRanking[] draftableArray =
            draftable.toArray(
                new FantasyDraftRanking[0]
            );

        Arrays.sort(draftableArray);

        String result = "";

        for (int i = 0; i < draftableArray.length; i++) {

            result = result
                + (i + 1)
                + ". "
                + draftableArray[i].name;

            if (i < draftableArray.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FantasyDraftRanking[] players = {

            new FantasyDraftRanking("Virat", 15, 48.0, false),
            new FantasyDraftRanking("Rahul", 7, 55.0, false),
            new FantasyDraftRanking("Sameer", 3, 60.0, false),
            new FantasyDraftRanking("Dev", 12, 20.0, true)
        };

        System.out.println(
            draftAndRank(players)
        );
    }
}