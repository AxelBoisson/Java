package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Province
 * 
 * 6 VP
 */
public class Province extends VictoryCard {
	
	private int victoryPoint;
	
	public Province() { 
		super("Province", 8);			
	}
	
	public String toString() {
		return super.toString() + "+6 Victoires";
	}
	
	public int victoryValue(Player p) {
		play(p);
		return this.victoryPoint;
	}

	public void play(Player p) {
		CardList totalVictoryCard = new CardList();
		totalVictoryCard = p.getVictoryCards();
		int nbProvince = 0;
		for(int i = 0; i<totalVictoryCard.size();i++) {
			if(totalVictoryCard.get(i).getName() == "Province")
				nbProvince = nbProvince + 6;
		}
		this.victoryPoint = nbProvince;
		
	}
}