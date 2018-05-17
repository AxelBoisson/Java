package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Domaine (Estate)
 * 
 * 1 VP
 */
public class Estate extends VictoryCard {
	
	private int victoryPoint;
	
	public Estate() { 
		super("Estate", 2);		
	}
	
	public String toString() {
		return super.toString() + " +1 Victoire";
	}
	
	public int victoryValue(Player p) {
		//play(p);
		//return this.victoryPoint;
		return 1;
	}

	public void play(Player p) {
		/*CardList totalVictoryCard = new CardList();
		totalVictoryCard = p.getVictoryCards();
		int nbEstate = 0;
		for(int i = 0; i<totalVictoryCard.size();i++) {
			if(totalVictoryCard.get(i).getName() == "Estate")
				nbEstate = nbEstate + 1;
		}
		this.victoryPoint = nbEstate;*/
		
	}
}