package dominion.card;
import java.util.*;
import dominion.*;
import dominion.card.base.Village;

/**
 * Les cartes Trésor
 */
public abstract class TreasureCard extends Card {
	
	CardType type;
	
	private int numCard = 0;
	
	public TreasureCard(String name, int cost){
		super(name,cost);
		type = CardType.Treasure;
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