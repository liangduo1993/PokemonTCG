package com.pokemon.Main;

import java.awt.Color;
import java.awt.Graphics;

public class GameInterface {
	public static CardSpot[] playerBench, enemyBench; // bench宠物
	public static CardSpot playerPoke, enemyPoke, playerDeck, enemyDeck; // 参战宠物，牌堆
	private Button endTurn;
	private int selected = -1, mouseOver = -1;
	private Player player;

	public GameInterface() {
		playerBench = new CardSpot[Game.BOARD_SIZE];
		enemyBench = new CardSpot[Game.BOARD_SIZE];

		int space = 25, hSpace = 20;
		int paddingLeft = (Game.WIDTH - (Game.BOARD_SIZE * Game.CARD_W * Game.CARD_SCALE + space * Game.BOARD_SIZE))
				/ 2;
		for (int i = 0; i < playerBench.length; i++) {
			playerBench[i] = new CardSpot(40 + paddingLeft + i * space + Game.CARD_W * Game.CARD_SCALE * i,
					Game.HEIGHT / 2 + hSpace / 2);
			// System.out.println(playerBench[0].x + "---" + playerBench[0].y);
		}
		for (int i = 0; i < enemyBench.length; i++) {
			enemyBench[i] = new CardSpot(40 + paddingLeft + i * space + Game.CARD_W * Game.CARD_SCALE * i,
					Game.HEIGHT / 2 - hSpace / 2 - Game.CARD_H * Game.CARD_SCALE);
		}
		playerPoke = new CardSpot(50, Game.HEIGHT / 2 + hSpace / 2);
		enemyPoke = new CardSpot(50, Game.HEIGHT / 2 - hSpace / 2 - Game.CARD_H * Game.CARD_SCALE);
		playerDeck = new CardSpot(Game.WIDTH - Game.CARD_H / 2 * Game.CARD_SCALE - 15,
				Game.HEIGHT / 2 + hSpace / 2 + 50, true);
		enemyDeck = new CardSpot(Game.WIDTH - Game.CARD_H / 2 * Game.CARD_SCALE - 15,
				Game.HEIGHT / 2 - hSpace / 2 - Game.CARD_W * Game.CARD_SCALE - 50, true);

		endTurn = new Button(Game.WIDTH - 72, Game.HEIGHT / 2 - 25, 50, "End Turn", Color.WHITE,
				new Color(49, 156, 12));

		player = ObjectHandler.getPlayer();

	}

	public void update() {
		endTurn.update();
		player.update();

		// 当前鼠标位置
		for (int i = player.getHand().size() - 1; i >= 0; i--) {
			if (player.getHand().get(i).getRect().intersects(Game.getMouseRect())) {
				if (selected <= -1)
					mouseOver = i;
				break;
			} else {
				if (selected <= -1)
					mouseOver = -1;
			}
		}

	}
	
	

	public void draw(Graphics g) {
		// 背景及框
		g.drawImage(Game.gameBackground, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		for (int i = 0; i < playerBench.length; i++) {
			playerBench[i].draw(g);
		}
		for (int i = 0; i < enemyBench.length; i++) {
			enemyBench[i].draw(g);
		}
		playerPoke.draw(g);
		enemyPoke.draw(g);
		playerDeck.draw(g);
		enemyDeck.draw(g);
		endTurn.draw(g);

		// 绘制手牌
		for (int i = 0; i < player.hand.size(); i++) {
			if (i != mouseOver && i != selected)
				player.hand.get(i).draw(g, 500 + 50 * i, 780);
		}

		if (selected > -1) {
			player.getHand().get(selected).draw(g, 480 + 50 * selected, 760 - Game.CARD_H);
		}
		if (mouseOver > -1) {
			player.getHand().get(mouseOver).draw(g, 500 + 50 * mouseOver, 780 - Game.CARD_H);
		}

	}
}
