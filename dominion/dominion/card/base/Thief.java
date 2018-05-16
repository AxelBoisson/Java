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
		return super.toString() + "Tous vos adversaires dévoilent les 2 premières cartes de leur deck. \n" + 
				"S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. \n" + 
				"Parmi ces cartes Trésor écartées, recevez celles de votre choix. \n" + 
				"Les autres cartes dévoilées sont défaussées.";
	}
	
	public void play(Player p){
		List<Player> adversary = new ArrayList<Player>();
		adversary = p.getGame().otherPlayers(p);
		List<String> choice = new ArrayList<String>();
		choice.add("y");
		choice.add("n");
		CardList cardPlayer = new CardList();
		CardList cardTrashed = new CardList();
		CardList cardDevo[] = new CardList[adversary.size()];
		CardList treasureCard = new CardList();
		String decision;
		
		
		
		for(int i = 0; i<adversary.size();i++){
			
			for(int j = 0; j<2;j++){
				cardPlayer = adversary.get(j).totalCards();
				if(cardPlayer.get(j).getTypes().get(j) == CardType.Treasure){
					treasureCard.add(cardPlayer.get(j));
					cardPlayer.remove(cardPlayer.get(i));
				}	
			}
			
			if(treasureCard.size()<2){
				decision = adversary.get(i).choose("Voulez-vous écarter la carte de ce joueur ?", choice, false);
				if(decision.equals("y")){
					cardTrashed.add(treasureCard.get(i));
					cardPlayer.remove(cardPlayer.get(i));
				}	
			}
			
			if(treasureCard.size() == 2){
				decision = adversary.get(i).chooseCard("Choisissez quelle carte vous voulez écarter", treasureCard, true);
				if(!decision.equals("")){
					cardTrashed.add(treasureCard.getCard(decision));
				}	
			}
			cardDevo[i].addAll(cardPlayer);
			cardPlayer.clear();
			treasureCard.clear();
		}
		
		int i = 0;
		boolean stop = false;
		
		if(cardTrashed.size() != 0){
			while(i < cardTrashed.size() && stop == false){
				decision = p.chooseCard("Choisissez la carte que vous voulez garder", cardTrashed, true);
				if(!decision.equals("")){
					p.setHand(cardTrashed.getCard(decision));
				}
				else
					stop = true;
				i++;
			}
		}
		
		for(int j = 0; j<adversary.size();j++){
			adversary.get(j).setDiscard(cardDevo[j].get(j));
		}
	
	}
	
}