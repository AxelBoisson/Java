package dominion.card;
import java.util.*;
import dominion.*;
import dominion.card.base.Village;

/**
 * Les cartes Trésor
 */
public abstract class TreasureCard extends Card {
	
	CardType type;
	
	public TreasureCard(String name, int cost){
		super(name,cost);
		type = CardType.Treasure;
	}
	
	public String toString(){
		return super.toString() + " " + type;
	}
	
	public List<CardType> getTypes() {
		List<CardType> liste = super.getTypes();
		liste.add(type);
		return liste;
	}
	
}