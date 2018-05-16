package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {
	
	public Chapel() {
		super("Chapel",2);
	}
	
	public String toString() {
		return super.toString() + "Écartez jusqu'à 4 cartes de votre main.";
	}
	
	public void play(Player p) {
		
		int nbRemove = 0;
		String decision = "noChoice";
		CardList cardInHand = new CardList();
		for(Card c : p.cardsInHand()){
			if(c != null){
				cardInHand.add(c);
			}
		}
		CardList cardToRemove = new CardList();
		
		while(nbRemove < 4 && decision != "") {
			decision = p.chooseCard("Choisissez la carte que vous voulez écarter, pour arreter appuyez sur entrée directement", cardInHand, true);
			if(decision != "") {	
				cardToRemove.add(cardInHand.getCard(decision));
				nbRemove++;
			}
		}
		if(cardToRemove.size() != 0){
			for(int i = 0; i<cardToRemove.size();i++)
				p.removeHand(cardToRemove.get(i).getName());			
		}
	}
}





