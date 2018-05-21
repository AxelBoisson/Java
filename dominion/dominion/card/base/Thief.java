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
		return super.toString() + " Effet: Tous vos adversaires dévoilent les 2 premières cartes de leur deck." + 
				" S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix." + 
				" Parmi ces cartes Trésor écartées, recevez celles de votre choix." + 
				" Les autres cartes dévoilées sont défaussées.\n";
	}
	
	public void play(Player p){
		// Initialisation des adversaire, de la décision, des listes de cartes du joueur, à écarter et trésors
		List<Player> adversary = new ArrayList<Player>();
		adversary = p.getGame().otherPlayers(p);
		
		CardList cardPlayer = new CardList();
		CardList cardTrashed = new CardList();
		CardList treasureCard = new CardList();
		String decision;
		
		
		// Pour chaque adversaires
		for(int i = 0; i<adversary.size();i++){
			// Si l'adversaire a dans sa main une carte Moat
			if(p.otherPlayers().get(i).cardsInHand().getCard("Moat") != null) {
				// On appelle la fonction reaction de la carte qui va demander a l'adversaire si il veut utiliser sa carte Moat
				if(!((Moat) p.otherPlayers().get(i).cardsInHand().getCard("Moat")).reaction(p.otherPlayers().get(i))) {
					// On récupere la pioche de l'adversaire
					cardPlayer = adversary.get(i).getDraw();
					
					// Pour les 2 premieres cartes de sa pioche
					for(int j = 0; j<2;j++){
						if(cardPlayer.get(j).getTypes().get(0) == CardType.Treasure){ // Si la carte est de type trésor
							treasureCard.add(cardPlayer.get(j)); // On stocke cette carte dans la liste des cartes trésors
						}
						else {
							adversary.get(i).addDiscard(cardPlayer.get(j)); // Sinon on défausse cette carte
						}
					}
					
					if(treasureCard.size() == 1){ // Si il n'y a qu'une carte trésor
						cardTrashed.add(treasureCard.get(0)); // On stocke cette carte dans la liste des cartes a écarter
						adversary.get(i).removeDraw(treasureCard.get(0).getName()); // On l'enve de la pioche de l'adversaire
					}
					
					else if(treasureCard.size() == 2){ // Si il y a 2 cartes trésors
						decision = p.chooseCard("Choisissez quelle carte vous voulez écarter", treasureCard, false);	
						cardTrashed.add(treasureCard.getCard(decision)); // On stocke celle que l'on veut écarter
						adversary.get(i).removeDraw(treasureCard.getCard(decision).getName()); // On l'a retire de la pioche de l'adversaire
						treasureCard.remove(treasureCard.getCard(decision)); // On retire de la liste des cartes trésors celle que l'on veut écarter
						adversary.get(i).removeDraw(treasureCard.get(0).getName()); // On retire de la pioche la seule carte trésor qui reste dans la liste des cartes trésors
						adversary.get(i).addDiscard(treasureCard.get(0)); // On défausse la carte restante
					}	
					treasureCard.clear(); // On vide la liste des cartes trésors
					cardPlayer.clear(); // On vide la liste des cartes de l'adversaire
				}
			}
			else {
				// On récupere la pioche de l'adversaire
				cardPlayer = adversary.get(i).getDraw();
				
				// Pour les 2 premieres cartes de sa pioche
				for(int j = 0; j<2;j++){
					if(cardPlayer.get(j).getTypes().get(0) == CardType.Treasure){ // Si la carte est de type trésor
						treasureCard.add(cardPlayer.get(j)); // On stocke cette carte dans la liste des cartes trésors
					}
					else {
						adversary.get(i).addDiscard(cardPlayer.get(j)); // Sinon on défausse cette carte
					}
				}
				
				if(treasureCard.size() == 1){ // Si il n'y a qu'une carte trésor
					cardTrashed.add(treasureCard.get(0)); // On stocke cette carte dans la liste des cartes a écarter
					adversary.get(i).removeDraw(treasureCard.get(0).getName()); // On l'enve de la pioche de l'adversaire
				}
				
				else if(treasureCard.size() == 2){ // Si il y a 2 cartes trésors
					decision = p.chooseCard("Choisissez quelle carte vous voulez écarter", treasureCard, false);	
					cardTrashed.add(treasureCard.getCard(decision)); // On stocke celle que l'on veut écarter
					adversary.get(i).removeDraw(treasureCard.getCard(decision).getName()); // On l'a retire de la pioche de l'adversaire
					treasureCard.remove(treasureCard.getCard(decision)); // On retire de la liste des cartes trésors celle que l'on veut écarter
					adversary.get(i).removeDraw(treasureCard.get(0).getName()); // On retire de la pioche la seule carte trésor qui reste dans la liste des cartes trésors
					adversary.get(i).addDiscard(treasureCard.get(0)); // On défausse la carte restante
				}	
				treasureCard.clear(); // On vide la liste des cartes trésors
				cardPlayer.clear(); // On vide la liste des cartes de l'adversaire
				
			}
			
		}
		
		
		int i = 0;
		
		// Si la liste des cartes écartés n'est pas vide
		if(!cardTrashed.isEmpty()) {
			// Tant qu'il reste des cartes dans cardTrashed
			while(i<cardTrashed.size()) {
				decision = p.chooseCard("Choisissez les cartes que vous voulez recevoir", cardTrashed, false);
				// On ajoute dans la défausse du joueur la carte choisit
				p.addDiscard(cardTrashed.getCard(decision));
				// On retire de la liste des cartes écartés celle que l'on a choisit
				cardTrashed.remove(cardTrashed.getCard(decision));	
				i++;
			}
		}
		
	}
}