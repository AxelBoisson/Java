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
		boolean stopGame = false;
		boolean endGame = false;
		
		
		while(stopGame == false) {
			
			// Prépare les piles "royaume" de la réserve (hors cartes communes)		
			List<CardList> kingdomStacks = new ArrayList<CardList>();
			
			// Les cartes royaume de base pour une partie classique
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
			
			// Le reste des cartes pour une partie complète
			CardList adventurer = new CardList();
			CardList bureaucrat = new CardList();
			CardList chancellor = new CardList();
			CardList chapel = new CardList();
			CardList councilroom = new CardList();
			CardList feast = new CardList();
			CardList festival = new CardList();
			CardList gardens = new CardList();
			CardList laboratory = new CardList();
			CardList library = new CardList();
			CardList moneylender = new CardList();
			CardList spy = new CardList();
			CardList thief = new CardList();
			CardList throneroom = new CardList();
			CardList witch = new CardList();
			
			// Possibilité de choisir entre une partie normale ou complête (toutes les cartes)
			System.out.println("Voulez vous effectuer une partie classique ou complète ? Tapez 1 pour classique et 2 pour complète");
			System.out.print("> ");
			Scanner clavier1 = new Scanner(System.in);
			String decision1 = clavier1.nextLine();	
			
			if(decision1.equalsIgnoreCase("1")) {
			
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
			
				// Instancie et exécute une partie normale
				Game g = new Game(playerNames, kingdomStacks);
				g.run();
				endGame = g.isFinished();
				
			}
			
			else {
				//Partie avec toutes les cartes
				for (int i = 0; i < 10; i++) {
					adventurer.add(new Adventurer());
					bureaucrat.add(new Bureaucrat());
					chancellor.add(new Chancellor());
					chapel.add(new Chapel());
					councilroom.add(new CouncilRoom());
					feast.add(new Feast());
					festival.add(new Festival());
					gardens.add(new Gardens());
					laboratory.add(new Laboratory());
					library.add(new Library());
					moneylender.add(new Moneylender());
					spy.add(new Spy());
					thief.add(new Thief());
					throneroom.add(new ThroneRoom());
					witch.add(new Witch());
				}
				
				kingdomStacks.add(adventurer);
				kingdomStacks.add(bureaucrat);
				kingdomStacks.add(chancellor);
				kingdomStacks.add(chapel);
				kingdomStacks.add(councilroom);
				kingdomStacks.add(feast);
				kingdomStacks.add(festival);
				kingdomStacks.add(gardens);
				kingdomStacks.add(laboratory);
				kingdomStacks.add(library);
				kingdomStacks.add(moneylender);
				kingdomStacks.add(spy);
				kingdomStacks.add(thief);
				kingdomStacks.add(throneroom);
				kingdomStacks.add(witch);
				
				Game g = new Game(playerNames, kingdomStacks);
				g.run();
				endGame = g.isFinished();
			}
			
			
			if(endGame == true) {
				System.out.println("Voulez-vous rejouer une partie ? Tapez y pour oui et n pour non");
				System.out.print("> ");
				Scanner clavier2 = new Scanner(System.in);
				String decision2 = clavier2.nextLine();	
				
				if(decision2.equalsIgnoreCase("y")) {
					kingdomStacks.clear();
				}
				else
					stopGame = true;
			}
		}
		
		System.out.println("Merci d'avoir jouer !");
	}
}