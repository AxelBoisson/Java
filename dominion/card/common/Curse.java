package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Malédiction (Curse)
 * 
 * -1 VP
 */
public class Curse extends CurseCard {
	
	private int victoryPoint;
	
	public Curse() { 
		super("Curse", 0);
	}
	
	public String toString() {
		return super.toString() + "1 Victoire";
	}
	
	public int victoryValue(Player p) {
	//	play(p);
		//return this.victoryPoint;
		return -1;
	}

	
	public void play(Player p) {
		/*CardList totalVictoryCard = new CardList();
		totalVictoryCard = p.getVictoryCards();
		int nbCurse = 0;
		for(int i = 0; i<totalVictoryCard.size();i++) {
			if(totalVictoryCard.get(i).getName() == "Curse")
				nbCurse = nbCurse + 3;
		}
		this.victoryPoint = nbCurse;*/
	}
}