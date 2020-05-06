package lab14;

import java.util.Random;

public enum Roshambo {
	
	ROCK, PAPER, SCISSORS;

	// push the Roshambo values to an array then makes a random choice of a value based on the size of the array
	private final static Roshambo[] VALUES = values();
	private final static int SIZE = VALUES.length;
	private final static Random RANDOM = new Random();

	public static Roshambo getRandomLetter() {
		return VALUES[RANDOM.nextInt(SIZE)];
	}


	@Override // changes the ROCK to rock etc. 
	  public String toString() {
	    switch(this) {
	      case ROCK: return "Rock";
	      case PAPER: return "Paper";
	      case SCISSORS: return "Scissors";
	      default: throw new IllegalArgumentException();
	    }

}
}
