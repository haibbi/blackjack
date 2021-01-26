package com.github.haibbi.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private final List<Card> cards;

	public Deck() {
		this.cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Face face : Face.values()) {
				Card card = new Card(face, suit);
				this.cards.add(card);
			}
		}
		Collections.shuffle(cards);
	}

	public Card draw() {
		if (this.cards.isEmpty()) throw new OutOfCardException();

		return this.cards.remove(0);
	}

}
