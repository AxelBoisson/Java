package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {
	
	CardType type;
	
	private int numCard = 0;
	
	
	public VictoryCard(String name, int cost){
		super(name,cost);
		type = CardType.Victory;
		this.numCard = this.numCard + 1;
		
	}
	
	public String toString(){
		return super.toString() + this.numCard; 
	}
	
	public List<CardType> getTypes() {
		List<CardType> liste = super.getTypes();
		liste.add(type);
		return liste;
	}
	
}