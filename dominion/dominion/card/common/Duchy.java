package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Duché (Duchy)
 * 
 * 3 VP
 */
public class Duchy extends VictoryCard {
	
	private int victoryPoint;
	
	public Duchy() { 
		super("Duchy", 5);
	}
	
	public String toString() {
		return super.toString() + " +3 Victoires";
	}
	
	public int victoryValue(Player p) {
		//play(p);
		//return this.victoryPoint;
		return 3;
	}

	
	public void play(Player p) {
		/*CardList totalVictoryCard = new CardList();
		totalVictoryCard = p.getVictoryCards();
		int nbDuchy = 0;
		for(int i = 0; i<totalVictoryCard.size();i++) {
			if(totalVictoryCard.get(i).getName() == "Duchy")
				nbDuchy = nbDuchy + 3;
		}
		this.victoryPoint = nbDuchy;*/
		
	}
}