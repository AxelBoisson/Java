package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {
	
	CardType type;
	
	private int numCard = 0;
	private int treasurValue;
	
	public CurseCard(String name, int cost){
		super(name,cost);
		type = CardType.Curse;
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