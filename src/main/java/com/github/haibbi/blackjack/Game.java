package com.github.haibbi.blackjack;

public class Game {

	private final Deck deck;
	private final Hand dealer;
	private final Hand player;

	public Game(Deck deck) {
		this.deck = deck;
		this.player = new Hand();
		this.dealer = new Hand();

		this.player.add(deck.draw());
		this.dealer.add(deck.draw());

		this.player.add(deck.draw());
		this.dealer.add(deck.draw().flip());
	}

	public void execute(Command command) {
		command.execute(this.deck);
	}

	public Hand getDealer() {
		return dealer;
	}

	public Hand getPlayer() {
		return player;
	}

	public void displayGameState() {
		System.out.println("Dealer hand is " + dealer.toString());
		System.out.println("Player hand is " + player.toString());
	}

}
