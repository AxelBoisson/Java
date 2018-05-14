package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck. 
 * S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. 
 * Parmi ces cartes Trésor écartées, recevez celles de votre choix. 
 * Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {
	
	public Thief(){
		super("Voleur",4);
	}
	
	public String toString() {
		return super.toString() + "Tous vos adversaires dévoilent les 2 premières cartes de leur deck. \n" + 
				" * S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. \n" + 
				" * Parmi ces cartes Trésor écartées, recevez celles de votre choix. \n" + 
				" * Les autres cartes dévoilées sont défaussées.";
	}
	
	public void play(Player p){
		List<Player> adversary = new ArrayList<Player>();
		adversary = p.getGame().otherPlayers(p);
		CardList cardPlayer = new CardList();
		CardList cardDiscard = new CardList();
		CardList cardDraw = new CardList();
		CardList treasureCard = new CardList();
		
		for(int i = 0; i<adversary.size();i++){
			
			for(int j = 0; j<2;j++){
				cardPlayer = adversary.get(j).totalCards();
				if(cardPlayer.get(j).getTypes().get(j) == CardType.Treasure){
					treasureCard.add(cardPlayer.get(j));
				}
					
			}
			
			
		}
		
		
		
		
		
	}
	
}