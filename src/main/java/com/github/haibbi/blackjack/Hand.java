package com.github.haibbi.blackjack;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Hand {

	private final List<Card> cards = new LinkedList<>();
	private int aceCount = 0;
	private boolean over = false;

	public void add(Card card) {
		if (over) throw new IllegalStateException("Hand is over. Can't take any more cards.");
		cards.add(card);
		if (card.face() == Face.ACE) aceCount++;
		if (rank() >= 21) over = true;
	}

	public int hard() {
		return visibleCards().mapToInt(card -> card.face().rank()).sum();
	}

	public int soft() {
		if (aceCount == 0) return 0;
		int soft = hard() + 10;
		return soft > 21 ? 0 : soft;
	}

	public int rank() {
		if (isOver()) return hard();
		return Math.max(hard(), soft());
	}

	boolean isBlackjack() {
		if (cards.size() != 2) return false;
		if (aceCount != 1) return false;

		final Set<Face> mustHave = EnumSet.of(Face.TEN, Face.JACK, Face.QUEEN, Face.KING);

		return visibleCards()
			.map(Card::face)
			.anyMatch(mustHave::contains);
	}

	public boolean isOver() {
		return over;
	}

	public void openAll() {
		cards.stream().filter(c -> !c.isVisible()).forEach(Card::flip);
	}

	public boolean isBust() {
		return rank() > 21;
	}

	public void done() {
		this.over = true;
	}

	private Stream<Card> visibleCards() {
		return this.cards.stream().filter(Card::isVisible);
	}

	@Override
	public String toString() {
		final int hard = hard();
		final int soft = soft();
		final boolean blackjack = isBlackjack();
		final boolean bust = isBust();
		StringBuilder sb = new StringBuilder(cards.toString());
		sb.append(" ").append(hard);
		if (soft != 0) {
			sb.append("/").append(soft);
		}
		if (blackjack) {
			sb.append(" Blackjack");
		}
		if (bust) {
			sb.append(" Bust");
		}
		return sb.toString();
	}
}
