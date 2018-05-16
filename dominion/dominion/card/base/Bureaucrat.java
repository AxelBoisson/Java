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
		super("Bureaucrat",4);
	}
	
	public String toString() {
		return super.toString()+"Recevez une carte Argent; placez-la sur votre deck.\n" + 
				" * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).";
	}
	
	public void play(Player p){
		
		List<Player> adversary = new ArrayList<Player>();
		adversary = p.getGame().otherPlayers(p);
		CardList victoryCardPlayer = new CardList();
		String decision = "noChoice";
		
		p.setDraw(p.getGame().getFromSupply("Silver"));
		
		for(int i = 0; i<adversary.size(); i++){
			victoryCardPlayer = adversary.get(i).getVictoryCards();
			if(victoryCardPlayer.size() != 0){
				decision = adversary.get(i).chooseCard("Choisissez la carte trésor que vous voulez dévoiler puis placer là sur votre deck", victoryCardPlayer, false);
				adversary.get(i).setDraw(victoryCardPlayer.getCard(decision));
				adversary.get(i).removeHand(victoryCardPlayer.getCard(decision).getName());
			}
			
		}		
		
	}
}