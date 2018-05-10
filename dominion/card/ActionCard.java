package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Action
 */
public abstract class ActionCard extends Card {
	
	CardType type;
	CardList action;
	
	private int numCard = 0;
	
	
	public ActionCard(String name, int cost){
		super(name,cost);
		type = CardType.Action;
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