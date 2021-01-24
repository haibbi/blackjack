package com.github.haibbi.blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.List;

class GameTest {

    @Test
    void gameMustDrawFourCardsOnStart() throws Exception {
        Deck deck = new Deck();
        Game game = new Game(deck);
        int size = ReflectionUtils.tryToReadFieldValue(Deck.class, "cards", deck)
                .andThen((o) -> {
                    List<Card> cards = (List<Card>) o;
                    return Try.success(cards.size());
                })
                .get();

        Assertions.assertEquals(52 - 4, size);
    }

    @Test
    void dealerLastCardMustBeInvisible() throws Exception {
        Game game = new Game(new Deck());
        Hand dealer = game.getDealer();

        List<Card> cards = ReflectionUtils.tryToReadFieldValue(Hand.class, "cards", dealer)
                .andThen((o) -> Try.success((List<Card>) o))
                .get();

        Assertions.assertEquals(2, cards.size());
        Assertions.assertEquals(1, cards.stream().filter(Card::isVisible).count());
    }

}