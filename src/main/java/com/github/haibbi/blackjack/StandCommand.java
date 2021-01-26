package com.github.haibbi.blackjack;

public class StandCommand extends Command {

	public StandCommand(Hand hand) {
		super(hand);
	}

	@Override
	void execute(Deck deck) {
		hand.done();
	}

}
