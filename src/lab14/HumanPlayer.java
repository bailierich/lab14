package lab14;
import java.util.Scanner;

public class HumanPlayer extends Player {
	
	private Scanner scnr;

	public HumanPlayer(String name, Scanner scnr) {
		super(name);
		this.scnr = scnr;
	}

	@Override
	public Roshambo generateRoshambo() {
		// ask for a choice
		System.out.print("Rock, paper, or scissors? (R/P/S): ");
		// get choice
		String input = scnr.next().toLowerCase();
		// TODO... validate the choice
		// return corresponding Roshambo enum value
		if (input.startsWith("r")) {
			return Roshambo.ROCK;
		} else if (input.startsWith("p")) {
			return Roshambo.PAPER;
		} else {
			return Roshambo.SCISSORS;
		}
	}

}