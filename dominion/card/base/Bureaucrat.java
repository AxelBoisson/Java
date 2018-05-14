package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {
	
	public Bureaucrat(){
		super("Bureaucrate",4);
	}
	
	public String toString() {
		return super.toString()+"Recevez une carte Argent; placez-la sur votre deck.\n" + 
				" * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).";
	}
	
	public void play(Player p){
		
		List<Player> adversary = new ArrayList<Player>();
		adversary = p.getGame().otherPlayers(p);
		CardList victoryCardPlayer = new CardList();
		CardList cardInHand = new CardList();
		String decision;
		Card c;
		c = p.gain("Silver");
		p.setDraw(c);
		
		for(int i = 0; i<adversary.size(); i++){
			victoryCardPlayer = adversary.get(i).getTreasureCards();
			if(!victoryCardPlayer.isEmpty()){
				decision = adversary.get(i).chooseCard("Choisissez la carte trésor que vous voulez dévoiler puis placer là sur votre deck", victoryCardPlayer, false);
				
				adversary.get(i).setDraw(victoryCardPlayer.getCard(decision));
			}
			else{
				cardInHand = adversary.get(i).cardsInHand();
				for(int j = 0; j<cardInHand.size();j++){
					
				}
			}
		}
		
		
	}
}