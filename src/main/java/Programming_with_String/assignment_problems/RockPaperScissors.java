package main.java.Programming_with_String.assignment_problems;

import java.util.*;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Player Move (Rock/Paper/Scissors): ");
            String player = sc.next();

            String computer = moves[(int)(Math.random() * 3)];

            String result = playRound(player, computer);

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            System.out.println("Round " + (i + 1) + " - Player: " + player +
                    ", Computer: " + computer);
            System.out.println(result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\nFinal Summary");
        System.out.println("Round\tPlayer Move\tComputer Move\tResult");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "\t" + playerMoves[i] + "\t\t" +
                    computerMoves[i] + "\t\t" + results[i]);
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win % = " + winPercentage + "%");

        sc.close();
    }
}
