package lab14;

import java.util.Scanner;

public class Lab14App {

	private static Scanner scnr = new Scanner(System.in);
	private static int Play1Score = 0;
	private static int Play2Score = 0;
	private static int gamesPlayed = 0;
	private static boolean toContinue = false;
	
	public static void main(String[] args) {
		// Let the user pick their name and create the human player
		Player player1 = createHumanPlayer();
		// Select your opponent
		Player player2 = selectOpponent();

		

		do {
			// loop to play multiple rounds...
			Roshambo hand1 = player1.generateRoshambo();
			Roshambo hand2 = player2.generateRoshambo();

			// TODO compare. to find winner
			System.out.println(player1.getName() + " played " + hand1.toString());
			System.out.println(player2.getName() + " played " + hand2.toString());

			if (hand1 == Roshambo.ROCK) {
				if (hand2 == Roshambo.ROCK) {
					System.out.println("It's a tie :(");
				} else if (hand2 == Roshambo.SCISSORS) {
					System.out.print(player1.getName() + " is the winner!");
					Play1Score++;
				} else if (hand2 == Roshambo.PAPER) {
					System.out.println(player2.getName() + " is the winner!");
					Play2Score++;
				}
			} else if (hand1 == Roshambo.PAPER) {
				if (hand2 == Roshambo.PAPER) {
					System.out.println("It's a tie :(");
				} else if (hand2 == Roshambo.ROCK) {
					System.out.print(player1.getName() + " is the winner!");
					Play1Score++;
				} else if (hand2 == Roshambo.SCISSORS) {
					System.out.println(player2.getName() + " is the winner!");
					Play2Score++;
				}
			} else if (hand1 == Roshambo.SCISSORS) {
				if (hand2 == Roshambo.SCISSORS) {
					System.out.println("It's a tie :(");
				} else if (hand2 == Roshambo.PAPER) {
					System.out.print(player1.getName() + " is the winner!");
					Play1Score++;
				} else if (hand2 == Roshambo.ROCK) {
					System.out.println(player2.getName() + " is the winner!");
					Play2Score++;
				}
			}
			
			gamesPlayed++;
			playAgain();
		} while (toContinue);

		System.out.println("Here's how you did: ");
		System.out.println("You Played " + gamesPlayed + " games.");
		System.out.println("You won " + Play1Score + " game(s) and lost " + Play2Score + " game(s)!");
		
		System.out.println("\nCome play again soon!");

	}

	private static Player selectOpponent() {
		System.out.println("Would you like to face Albert or Bertha?");
		String input = scnr.nextLine().toUpperCase();
		// TODO... validation!
		if (input.startsWith("A")) {
			return new RockPlayer("Albert");
		} else if (input.startsWith("B")) {
			// NOTE! You will have RandomPlayer, not PaperPlayer
			return new PaperPlayer("Bertha");
		} else {
			System.out.println("You didn't enter a valid Player. Try Again.");
			return selectOpponent();
		}

	}

	private static HumanPlayer createHumanPlayer() {
		// Pick name
		System.out.print("What's your name? ");
		String name = scnr.nextLine();
		// Create player
		return new HumanPlayer(name, scnr);
	}
	private static boolean playAgain(){
		System.out.println("\n\nWould you like to play again (y/n)");
		String answer = scnr.next();
		if (answer.equalsIgnoreCase("y")) {
			return toContinue = true;
		} else if (answer.equalsIgnoreCase("n")) {
			return toContinue = false;
		}else {
			System.out.println("Oops! That isn't a valid answer!");
			return playAgain();
		}
	}
}
