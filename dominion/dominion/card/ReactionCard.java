package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Réaction
 * Rmq: les cartes Réaction sont toutes des cartes Action
 */
public abstract class ReactionCard extends ActionCard {
	
	CardType type;
		
	
	public ReactionCard(String name, int cost){
		super(name,cost);
		type = CardType.Reaction;
	}
	
	public String toString(){
		return super.toString() + type; 
	}
	
	public List<CardType> getTypes() {
		List<CardType> liste = super.getTypes();
		liste.add(type);
		return liste;
	}
	
}