import java.util.*;
import dominion.*;
import dominion.card.*;
import dominion.card.base.*;

/**
 * Classe pour l'exécution d'une partie de Dominion
 */
class Main {
	public static void main(String[] args) {
		// Noms des joueurs de la partie
		// (le nombre total de joueurs correspond au nombre de noms dans le 
		// tableau)
		String[] playerNames = new String[]{"Marco", "Polo"};
		// Prépare les piles "royaume" de la réserve (hors cartes communes)
		List<CardList> kingdomStacks = new ArrayList<CardList>();
		CardList village = new CardList();
		CardList cellar = new CardList();
		CardList market = new CardList();
		CardList militia = new CardList();
		CardList mine = new CardList();
		CardList moat = new CardList();
		CardList remodel = new CardList();
		CardList smithy = new CardList();
		CardList woodcutter = new CardList();
		CardList workshop = new CardList();
		
		
		for (int i = 0; i < 10; i++) {
			cellar.add(new Cellar());
			market.add(new Market());
			militia.add(new Militia());
			mine.add(new Mine());
			moat.add(new Moat());
			remodel.add(new Remodel());
			smithy.add(new Smithy());
			village.add(new Village());
			woodcutter.add(new Woodcutter());
			workshop.add(new Workshop());
		}
		
			kingdomStacks.add(cellar);
			kingdomStacks.add(market);
			kingdomStacks.add(militia);
			kingdomStacks.add(mine);
			kingdomStacks.add(moat);
			kingdomStacks.add(remodel);
			kingdomStacks.add(smithy);
			kingdomStacks.add(village);
			kingdomStacks.add(woodcutter);
			kingdomStacks.add(workshop);
	
		// Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		g.run();
	}
}