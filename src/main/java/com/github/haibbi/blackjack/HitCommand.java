package com.github.haibbi.blackjack;

public class HitCommand extends Command {

	public HitCommand(Hand hand) {
		super(hand);
	}

	@Override
	public void execute(Deck deck) {
		Card card = deck.draw();
		hand.add(card);

		if (hand.rank() >= 21) {
			hand.done();
		}
	}

}
