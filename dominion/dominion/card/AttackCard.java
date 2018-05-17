package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Attaque
 * Rmq: les cartes Attaque sont toutes des cartes Action
 */
public abstract class AttackCard extends ActionCard {
	
	CardType type;
	
	public AttackCard(String name, int cost){
		super(name,cost);
		type = CardType.Attack;	
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