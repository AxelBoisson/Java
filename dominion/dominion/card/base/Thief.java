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
		super("Thief",4);
	}
	
	public String toString() {
		return super.toString() + " Tous vos adversaires dévoilent les 2 premières cartes de leur deck.\n" + 
				" S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix.\n" + 
				" Parmi ces cartes Trésor écartées, recevez celles de votre choix.\n" + 
				" Les autres cartes dévoilées sont défaussées.";
	}
	
	public void play(Player p){
		List<Player> adversary = new ArrayList<Player>();
		adversary = p.getGame().otherPlayers(p);
		
		CardList cardPlayer = new CardList();
		CardList cardTrashed = new CardList();
		CardList treasureCard = new CardList();
		String decision;
		
		
		
		for(int i = 0; i<adversary.size();i++){
			cardPlayer = adversary.get(i).getDraw();
			
			for(int j = 0; j<2;j++){
				if(cardPlayer.get(j).getTypes().get(0) == CardType.Treasure){
					treasureCard.add(cardPlayer.get(j));
				}
				else {
					adversary.get(i).setDiscard(cardPlayer.get(j));
				}
			}
			
			if(treasureCard.size() == 1){
				cardTrashed.add(treasureCard.get(0));
				adversary.get(i).removeDraw(treasureCard.get(0).getName());
			}
			
			else if(treasureCard.size() == 2){
				decision = p.chooseCard("Choisissez quelle carte vous voulez écarter", treasureCard, false);	
				cardTrashed.add(treasureCard.getCard(decision));
				adversary.get(i).removeDraw(treasureCard.getCard(decision).getName());
				treasureCard.remove(treasureCard.getCard(decision));
				adversary.get(i).removeDraw(treasureCard.get(0).getName());
				adversary.get(i).setDiscard(treasureCard.get(0));
			}	
			treasureCard.clear();
			cardPlayer.clear();
			
			
		}
		
		if(!cardTrashed.isEmpty()) {	
			decision = p.chooseCard("Choisissez les cartes que vous voulez recevoir", cardTrashed, false);
			if(!decision.equalsIgnoreCase("")) {
				p.setDiscard(cardTrashed.getCard(decision));
				cardTrashed.remove(cardTrashed.getCard(decision));	
			}
		}
		
	}
}