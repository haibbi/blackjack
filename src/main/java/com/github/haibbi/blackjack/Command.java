package com.github.haibbi.blackjack;

public abstract class Command {

	protected final Hand hand;

	Command(Hand hand) {
		this.hand = hand;
	}

	abstract void execute(Deck deck);

}
