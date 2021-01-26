package com.github.haibbi.blackjack;

import java.util.Scanner;

public class Engine {

	private final Game game;

	public Engine() {
		Deck deck = new Deck();
		game = new Game(deck);
		game.displayGameState();
	}

	public static void main(String[] args) {
		Engine engine = new Engine();
		engine.play();
	}

	void play() {
		Hand playerHand = game.getPlayer();
		while (!playerHand.isOver()) {
			String command = getPlayerCommand();
			if ("s".equals(command)) {
				game.execute(new StandCommand(playerHand));
			} else {
				game.execute(new HitCommand(playerHand));
				game.displayGameState();
			}
		}

		Hand dealerHand = game.getDealer();
		dealerHand.openAll();

		if (!playerHand.isBust()) {
			while (dealerHand.rank() < 17) {
				game.execute(new HitCommand(dealerHand));
			}
			if (!dealerHand.isOver()) {
				game.execute(new StandCommand(dealerHand));
			}
		}

		System.out.println();
		System.out.println("=== Final Result ===");
		game.displayGameState();

		if (playerHand.isBust()) {
			System.out.println("You Busted.");
		} else if (dealerHand.isBust()) {
			System.out.println("Dealer went bust, Player wins! 💵");
		} else {
			int dealHandRank = dealerHand.rank();
			int playerHandRank = playerHand.rank();

			if (dealHandRank < playerHandRank) {
				System.out.println("You beat the Dealer! 💵");
			} else if (dealHandRank == playerHandRank) {
				System.out.println("Push");
			} else {
				System.out.println("You lost to the Dealer. 💸");
			}
		}
	}

	String getPlayerCommand() {
		System.out.println("[H]it or [S]tand?");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().toLowerCase();
	}

}
