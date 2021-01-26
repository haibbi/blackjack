package com.github.haibbi.blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class DeckTest {

	@Test
	void deckMustThrowOutOfCardWhenNoCardsLeft() {
		Deck deck = new Deck();

		IntStream.range(0, 52).forEach(i -> deck.draw());

		Assertions.assertThrows(OutOfCardException.class, deck::draw);
	}

}
