package com.github.haibbi.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void blackjackMustBeOver() {
        Hand hand = new Hand();

        hand.add(new Card(Face.ACE, Suit.HEARTS));
        hand.add(new Card(Face.KING, Suit.HEARTS));

        assertTrue(hand.isOver(), "A blackjack must be mark as done.");
    }

    @Test
    void twentyOneMustTakeNoLongerNewCard() {
        Hand hand = new Hand();

        hand.add(new Card(Face.EIGHT, Suit.HEARTS));
        hand.add(new Card(Face.EIGHT, Suit.HEARTS));
        hand.add(new Card(Face.FIVE, Suit.HEARTS));
        // hand value is now 21

        assertThrows(IllegalStateException.class, () -> hand.add(new Card(Face.TWO, Suit.HEARTS)));
    }
}