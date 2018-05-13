package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {
	
	public Workshop() {
		super("Atelier",2);
	}
	
	public void play(Player p) {
		String reponse;
		CardList supplyCard = new CardList();
		supplyCard = p.getGame().availableSupplyCards();
		CardList cardAvailable = new CardList();
		
		for(int i = 0; i<supplyCard.size();i++) {
			if(supplyCard.get(i).getCost()<=4) {
				cardAvailable.add(supplyCard.get(i));
			}
		}
		
		System.out.println("Voici les cartes disponibles");
		for(int i = 0; i<cardAvailable.size();i++) {
			System.out.println(cardAvailable.get(i).getName());
		}
		
		reponse = p.chooseCard("Choisissez la carte parmis celle disponible", cardAvailable, false);
		p.gain(reponse);
				
		
	}
	
}