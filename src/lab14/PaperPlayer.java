package lab14;
public class PaperPlayer extends Player {

	public PaperPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.getRandomLetter();
	}

}