package dominion;
import java.util.*;


import dominion.card.*;
import dominion.card.common.Copper;
import dominion.card.common.Estate;

/**
 * Un joueur de Dominion
 */
public class Player {
	/**
	 * Nom du joueur
	 */
	private String name;
	
	/**
	 * Nombre d'actions disponibles
	 */
	private int actions;
	
	/**
	 * Nombre de pièces disponibles pour acheter des cartes
	 */
	private int money;
	
	/**
	 * Nombre d'achats disponibles
	 */
	private int buys;
	
	/**
	 * Référence vers la partie en cours
	 */
	private Game game;
	
	/**
	 * Liste des cartes dans la main du joueur
	 */
	private CardList hand;
	
	/**
	 * Liste des cartes dans la défausse du joueur
	 */
	private CardList discard;
	
	/**
	 * Liste des cartes dans la pioche du joueur
	 */
	private CardList draw;
	
	/**
	 * Listes des cartes qui ont été jouées pendant le tour courant
	 */
	private CardList inPlay;
	
	/**
	 * Constructeur
	 * 
	 * Initialise les différentes piles de cartes du joueur, place 3 cartes
	 * Estate et 7 cartes Copper dans la défausse du joueur puis fait piocher 5
	 * cartes en main au joueur.
	 * 
	 * @param name: le nom du joueur
	 * @param game: le jeu en cours
	 * 
	 * Indications: On peut utiliser la méthode {@code this.endTurn()} pour 
	 * préparer la main du joueur après avoir placé les cartes dans la défausse.
	 */
	public Player(String name, Game game) {
		this.name = name;
		this.game = game;
		
		this.hand = new CardList();
		this.discard = new CardList();
		this.draw = new CardList();
		this.inPlay = new CardList();
		
		Estate estate=new Estate();
		Copper copper=new Copper();
		
		for(int i=0; i<3; i++) 
			discard.add(estate);
		
		for(int i=0; i<7; i++) 
			discard.add(copper);
		
		for(int i=0; i<5; i++) 
			drawCard();
	}

	/**
	 * Getters et setters
	 */
	public String getName() {
		return this.name;
	}
	
	public int getActions() {
		return this.actions;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public int getBuys() {
		return this.buys;
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public void setHand(Card c) {
		this.hand.add(c);
	}
	
	public void setDiscard(Card c) {
		this.discard.add(c);
	}
	
	public void setDraw(Card c){
		this.draw.add(c);
	}
	/**
	 * Incrémente le nombre d'actions du joueur
	 * 
	 * @param n nombre d'actions à ajouter (ce nombre peut être négatif si l'on
	 * souhaite diminuer le nombre d'actions)
	 */
	public void incrementActions(int n) {
		this.actions = this.actions + n;
	}
	
	/**
	 * Incrémente le nombre de pièces du joueur
	 * 
	 * @param n nombre de pièces à ajouter (ce nombre peut être négatif si l'on
	 * souhaite diminuer le nombre de pièces)
	 */
	public void incrementMoney(int n) {
		this.money = this.money + n;
	}
	
	/**
	 * Incrémente le nombre d'achats disponibles du joueur
	 * 
	 * @param n nombre d'achats à ajouter (ce nombre peut être négatif si l'on
	 * souhaite diminuer le nombre d'achats)
	 */
	public void incrementBuys(int n) {
		this.buys = this.buys + n;
	}

	/**
	 * Renvoie une liste des cartes que le joueur a en main.
	 * La liste renvoyée doit être une nouvelle {@code CardList} dont les 
	 * éléments sont les mêmes que ceux de {@code this.hand}.
	 */
	public CardList cardsInHand() {
		CardList hand = new CardList();
		hand = this.hand;
		return hand;
	}
	
	/**
	 * Renvoie une liste de toutes les cartes possédées par le joueur
	 * (le deck complet c'est-à-dire toutes les cartes dans la main, la
	 * défausse, la pioche et en jeu)
	 */
	public CardList totalCards() {
		CardList total = new CardList();
		total.addAll(hand);
		total.addAll(discard);
		total.addAll(draw);
		total.addAll(inPlay);
		return total;
		
	}
	
	/**
	 * Renvoie le nombre total de points de victoire du joueur
	 * 
	 * Ce total est calculé en ajoutant les valeurs individuelles de toutes les
	 * cartes dans le deck du joueur (en utilisant la méthode
	 * {@code victoryValue()}) des cartes
	 */
	public int victoryPoints() {
		int victoire = 0;
		CardList total = new CardList();
		total = totalCards();
		for(int i = 0; i<total.size();i++){
			victoire = total.get(i).victoryValue(this);
		}
			return victoire;
	}
	
	/**
	 * Renvoie une liste des autres joueurs de la partie.
	 * 
	 * Les adversaires sont listés dans l'ordre de jeu, c'est-à-dire que le
	 * premier de la liste est celui qui joue immédiatement après le joueur,
	 * puis le suivant, et ainsi de suite jusqu'au joueur qui joue immédiatement
	 * avant le joueur.
	 * 
	 * Rmq: Cette méthode fait appel à la méthode {@code otherPlayers(Player p)}
	 * de la classe {@code Game}.
	 */
	public List<Player> otherPlayers() {
		List<Player> other = new ArrayList<Player>();
		other =  this.game.otherPlayers(this);
		return other;
	}
	
	/**
	 * Pioche une carte dans la pioche du joueur.
	 * 
	 * Si la pioche du joueur est vide, on commence par mélanger la défausse
	 * et transférer toutes les cartes de la défausse dans la pioche.
	 * On retire et renvoie ensuite la première carte de la pioche si elle n'est
	 * pas vide (sinon la méthode ne fait rien et renvoie {@code null})
	 * 
	 * @return la carte piochée, {@code null} si aucune carte disponible
	 */
	public Card drawCard() {
		Card draw;
		if(this.draw == null){
			this.discard.shuffle();
			this.draw.addAll(discard);
			this.discard.clear();
		}
		draw = this.draw.get(0);
		this.draw.remove(0);
		return draw;
	}
	
	/**
	 * Renvoie une représentation de l'état du joueur sous forme d'une chaîne
	 * de caractères.
	 * 
	 * Cette représentation comporte
	 * - le nom du joueur
	 * - le nombre d'actions, de pièces et d'achats du joueur
	 * - le nombre de cartes dans la pioche et dans la défausse du joueur
	 * - la liste des cartes en jeu du joueur
	 * - la liste des cartes dans la main du joueur
	 */
	public String toString() {
		String r = String.format("     -- %s --\n", this.name);
		r += String.format("Actions: %d     Money: %d     Buys: %d     Draw: %d     Discard: %d\n", this.actions, this.money, this.buys, this.draw.size(), this.discard.size()); 
		r += String.format("In play: %s\n", this.inPlay.toString());
		r += String.format("Hand: %s\n", this.hand.toString());
		return r;
	}
	
	/**
	 * Renvoie la liste de toutes les cartes Trésor dans la main du joueur
	 */
	public CardList getTreasureCards() {
		CardList treasureCards = new CardList();
		List<CardType> type = new ArrayList<CardType>();
		for(int i = 0; i<cardsInHand().size();i++){
			type = cardsInHand().get(i).getTypes();
			if(type.get(i) == CardType.Treasure)
				treasureCards.add(cardsInHand().get(i));
		}
		return treasureCards;
		
	}
	
	/**
	 * Renvoie la liste de toutes les cartes Action dans la main du joueur
	 */
	public CardList getActionCards() {
		CardList actionCards = new CardList();
		List<CardType> type = new ArrayList<CardType>();
		for(int i = 0; i<cardsInHand().size();i++){
			type = cardsInHand().get(i).getTypes();
			if(type.get(i) == CardType.Action)
				actionCards.add(cardsInHand().get(i));
		}
		return actionCards;
	}
	
	/**
	 * Renvoie la liste de toutes les cartes Victoire dans la main du joueur
	 */
	public CardList getVictoryCards() {
		CardList victoryCards = new CardList();
		List<CardType> type = new ArrayList<CardType>();
		for(int i = 0; i<cardsInHand().size();i++){
			type = cardsInHand().get(i).getTypes();
			if(type.get(i) == CardType.Victory)
				victoryCards.add(cardsInHand().get(i));
		}
		return victoryCards;
	}
	
	/**
	 * Joue une carte de la main du joueur.
	 * 
	 * @param c carte à jouer
	 * 
	 * Cette méthode ne vérifie pas que le joueur a le droit de jouer la carte,
	 * ni même que la carte se trouve effectivement dans sa main.
	 * La méthode retire la carte de la main du joueur, la place dans la liste
	 * {@code inPlay} et exécute la méthode {@code play(Player p)} de la carte.
	 */
	public void playCard(Card c) {
		
		this.inPlay.add(c);
		this.hand.remove(c);
		c.play(this);
		
	}
	
	/**
	 * Joue une carte de la main du joueur.
	 * 
	 * @param cardName nom de la carte à jouer
	 * 
	 * S'il existe une carte dans la main du joueur dont le nom est égal au
	 * paramètre, la carte est jouée à l'aide de la méthode 
	 * {@code playCard(Card c)}. Si aucune carte ne correspond, la méthode ne
	 * fait rien.
	 */
	public void playCard(String cardName) {
		CardList inHand = new CardList();
		inHand = cardsInHand();
		int i = 0;
		boolean cardFind = false;
		while(i < cardsInHand().size() && cardFind == false) {
			if(inHand.get(i).getName() == cardName) {
				playCard(inHand.get(i));
				cardFind = true;
			}
			i++;
		}
	}
	
	/**
	 * Le joueur gagne une carte.
	 * 
	 * @param c carte à gagner (éventuellement {@code null})
	 * 
	 * Si la carte n'est pas {@code null}, elle est placée sur la défausse du
	 * joueur. On suppose que la carte a correctement été retirée de son 
	 * emplacement précédent au préalable.
	 */
	public void gain(Card c) {
		if(c != null) {
			this.discard.add(c);
		}
	}
	
	/**
	 * Le joueur gagne une carte de la réserve
	 * 
	 * @param cardName nom de la carte à gagner. S'il existe une carte dans la 
	 * réserve ayant ce nom, cette carte est retirée de la réserve et placée 
	 * sur la défausse du joueur.
	 * @return la carte qui a été ajoutée à la défausse du joueur, ou {@code 
	 * null} si aucune carte n'a été prise dans la réserve.
	 */
	public Card gain(String cardName) {
		Card gain;
		gain = this.game.getFromSupply(cardName);
		discard.add(gain);
		gain = this.game.removeFromSupply(cardName);
		return gain;
	}
	
	/**
	 * Le joueur achète une carte de la réserve
	 * 
	 * La méthode cherche une carte dans la réserve dont le nom est égal au
	 * paramètre, puis vérifie que le joueur a assez de pièces pour l'acheter 
	 * et au moins un achat disponible.
	 * Si le joueur peut acheter la carte, le coût de la carte est soustrait à
	 * l'argent du joueur, le nombre d'achats disponibles est décrémenté de 1 
	 * et la carte est gagnée par le joueur.
	 * 
	 * @param cardName nom de la carte à acheter
	 * @return la carte qui a été gagnée ou {@code null} si l'achat n'a pas eu 
	 * lieu
	 */
	public Card buyCard(String cardName) {
		Card buy;
		buy = this.game.getFromSupply(cardName);
		int cost;
		cost = buy.getCost();
		if(this.money >= cost && getBuys()<=1) {
			incrementMoney(-cost);
			incrementMoney(-1);
			return gain(cardName);
		}
		return null;
		
	}
	
	/**
	 * Attend une entr�e de la part du joueur (au clavier) et renvoie le choix
	 *  du joueur.
	 * 
	 * @param instruction message � afficher � l'�cran pour indiquer au joueur
	 * la nature du choix qui est attendu
	 * @param choices une liste de cha�nes de caract�res correspondant aux
	 * choix valides attendus du joueur (la liste sera convertie en ensemble 
	 * par la fonction pour �liminer les doublons, ce qui permet de compter 
	 * correctement le nombre d'options disponibles)
	 * @param canPass bool�en indiquant si le joueur a le droit de passer sans
	 * faire de choix. S'il est autoris� � passer, c'est la cha�ne de
	 * caract�res vide ("") qui signifie qu'il d�sire passer.
	 * 
	 * @return la m�thode lit l'entr�e clavier jusqu'� ce qu'un choix valide
	 * soit entr� par l'utilisateur (un �l�ment de {@code choices} ou
	 * �ventuellement la cha�ne vide si l'utilisateur est autoris� � passer).
	 * Lorsqu'un choix valide est obtenu, il est renvoy�.
	 * 
	 * Si l'ensemble {@code choices} ne comporte qu'un seul �l�ment et que
	 * {@code canPass} est faux, l'unique choix valide est automatiquement
	 * renvoy� sans lire l'entr�e de l'utilisateur.
	 * 
	 * Si l'ensemble des choix est vide, la cha�ne vide ("") est 
	 * automatiquement renvoy�e par la m�thode (ind�pendamment de la valeur de 
	 * {@code canPass}).
	 * 
	 * Exemple d'utilisation pour demander � un joueur de r�pondre � une 
	 * question :
	 * <pre>
	 * {@code
	 * List<String> choices = Arrays.asList("y", "n");
	 * String input = p.choose("Do you want to ...? (y/n)", choices, false);
	 * }
	 * </pre>
	 */
	public String choose(String instruction, List<String> choices, boolean canPass) {
		// La liste de choix est convertie en ensemble pour �viter les doublons
		Set<String> choiceSet = new HashSet<String>();
		for (String c: choices) {
			choiceSet.add(c);
		}
		if (choiceSet.isEmpty()) {
			// Aucun choix disponible
			return "";
		} else if (choiceSet.size() == 1 && !canPass) {
			// Un seul choix possible (renvoyer cet unique �l�ment)
			return choiceSet.iterator().next();
		} else {
			String input;
			// Lit l'entr�e de l'utilisateur jusqu'� obtenir un choix valide
			while (true) {
				System.out.print("\n\n");
				// affiche l'�tat du jeu
				System.out.print(this.game);
				System.out.print("\n");
				// affiche l'�tat du joueur
				System.out.print(this);
				System.out.print("\n");
				// affiche l'instruction
				System.out.println(">>> " + instruction);
				System.out.print("> ");
				// lit l'entr�e de l'utilisateur au clavier
				input = this.game.readLine();
				if (choiceSet.contains(input) || (canPass && input.equals(""))){
					// si une r�ponse valide est obtenue, elle est renvoy�e
					return input;
				}
			}
		}
	}
	
	/**
	 * Attend une entrée de la part du joueur et renvoie le choix du joueur.
	 * Dans cette méthode, la liste des choix est donnée sous la forme d'une 
	 * liste de cartes et le joueur doit choisir le nom d'une de ces cartes.
	 * 
	 * @param instruction message à afficher à l'écran pour indiquer au joueur
	 * la nature du choix qui est attendu
	 * @param choices liste de cartes parmi lesquelles il faut en choisir une
	 * parmi lesquelles l'utilisateur doit choisir
	 * @param canPass booléen indiquant si le joueur a le droit de passer sans
	 * faire de choix. S'il est autorisé à passer, c'est la chaîne de
	 * caractères vide ("") qui signifie qu'il désire passer.
	 * 
	 * La méthode commence par construire une liste de tous les noms des cartes 
	 * dans {@code choices} puis appelle la méthode précédente pour faire 
	 * choisir un nom parmi cette liste à l'utilisateur.
	 * 
	 * Exemple d'utilisation pour faire choisir le nom d'une carte Action de sa
	 * main à un joueur (dans cet exemple le joueur n'a pas le droit de passer 
	 * s'il a au moins une carte Action en main, mais la méthode peut quand 
	 * même renvoyer {@code ""} s'il n'a aucune carte Action en main) :
	 * <pre>
	 * {@code
	 * CardList choices = new CardList();
	 * for (Card c: p.cardsInHand()) {
	 *   if (c.getTypes().contains(CardType.Action)) {
	 *     choices.add(c);
	 *   }
	 * }
	 * String input = p.chooseCard("Choose an Action card.", choices, false);
	 * </pre>
	 */
	public String chooseCard(String instruction, CardList choices, boolean canPass) {
		// liste de noms de cartes
		List<String> stringChoices = new ArrayList<String>();
		for (Card c: choices) {
			// tous les noms sont ajoutés à l'ensemble
			stringChoices.add(c.getName());
		}
		// appel de la méthode précédente en passant l'ensemble de noms
		return this.choose(instruction, stringChoices, canPass);
	}
	
	/**
	 * Démarre le tour du joueur
	 * 
	 * Les compteurs d'actions et achats sont mis à 1
	 */
	public void startTurn() {
		this.actions = 1;
		this.buys = 1;
	}
	
	/**
	 * Termine le tour du joueur
	 * 
	 * - Les compteurs d'actions, argent et achats du joueur sont remis à 0
	 * - Les cartes en main et en jeu sont défaussées
	 * - Le joueur pioche 5 cartes en main
	 */
	public void endTurn() {
		this.actions = 0;
		this.money = 0;
		this.buys = 0;
			
		this.hand.addAll(discard);
		this.hand.clear();
		this.inPlay.addAll(discard);
		this.inPlay.clear();
		
		for(int i=0; i<5; i++) 
			drawCard();
	}
	
	/**
	 * Exécute le tour d'un joueur
	 * 
	 * Cette méthode exécute successivement les 5 phases du tour d'un joueur:
	 * 
	 * 1. (Préparation) la méthode {@code startTurn()} est appelée
	 * 
	 * 2. (Action) Tant que le joueur a des actions disponibles, on lui demande 
	 * de choisir le nom d'une carte Action de sa main à jouer. Il peut passer à
	 * tout moment à la phase suivante (soit de manière forcée s'il n'a plus de 
	 * carte Action en main soit volontairement en entrant la chaîne vide). 
	 * Lorsqu'il joue une carte Action, la fonction décrémente son nombre 
	 * d'actions puis joue la carte.
	 * 
	 * 3. (Trésor) Le joueur joue toutes les cartes Trésor de sa main 
	 * automatiquement (dans le jeu de base il n'y a aucune raison de ne pas 
	 * jouer tous les trésors automatiquement).
	 * 
	 * 4. (Achat) Tant que le joueur a au moins un achat disponible, on lui 
	 * demande de choisir le nom d'une carte de la réserve qu'il veut acheter. 
	 * Il ne peut acheter que des cartes dont le prix est inférieur à l'argent 
	 * dont il dispose. Le joueur peut passer (et terminer son tour) à tout 
	 * moment pendant cette phase.
	 * 
	 * 5. (Fin) La méthode {@code endTurn()} est appelée pour terminer le tour 
	 * du joueur
	 */
	public void playTurn() {
		
		CardList actionsCard = new CardList();
		CardList treasuresCard = new CardList();
		
		
		startTurn();	
	
		String decision = "noChoice";
		actionsCard = getActionCards();
		while(this.actions != 0 && actionsCard.size()>0 && decision != "") {
			decision = chooseCard("Choisissez une carte action de votre main",actionsCard, true);
			if(decision != "") {
				incrementActions(-1);
				playCard(decision);
			}
		}
		
		treasuresCard = getTreasureCards();
		for(int i = 0; i<treasuresCard.size();i++)
			playCard(treasuresCard.get(i));
		
		decision = "noChoice";
		while(this.buys >= 1 && decision != "") {
			decision = chooseCard("Choisissez la carte dans la r�serve que vous souhaitez acheter", this.game.availableSupplyCards(),true);
			if(decision != "") {
				buyCard(decision);
				incrementBuys(-1);	
			}	
		}
		
		endTurn();
		
	}
}
