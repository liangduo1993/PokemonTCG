package com.pokemon.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Card extends GameObject {

	protected int maxHp, hp, hpLimit, maxAttack, attack, attackLimit, cost, range, maxRange, id;
	protected String name, description;
	protected BufferedImage icon, cardImage;

	public Card() {
		this.w = Game.CARD_W;
		this.h = Game.CARD_H;
		cardImage = new BufferedImage(Game.cardImg.getWidth() * Game.CARD_SCALE,
				Game.cardImg.getHeight() * Game.CARD_SCALE, BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = cardImage.getGraphics();
		g2.drawImage(Game.cardImg, 0, 0, cardImage.getWidth(), cardImage.getHeight(), null);

		ObjectHandler.addCard(this);
	}

	public void update() {

	}

	public void draw(Graphics g, int x, int y) {
		draw(g, x, y, 0);
	}

	public void draw(Graphics g, int x, int y, double angle) {
		this.x = x;
		this.y = y;
		Animation.drawCard(g, this, x, y, angle);
		this.w = cardImage.getWidth();
		this.h = cardImage.getHeight();

		g.setColor(Color.WHITE);
		g.setFont(new Font("DorFont02", Font.PLAIN, 32));

	}

	public BufferedImage getIcon() {
		return icon;
	}

	public void setIcon(BufferedImage icon) {
		this.icon = icon;
	}

	public BufferedImage getCardImage() {
		return cardImage;
	}

	public void setCardImage(BufferedImage cardImage) {
		this.cardImage = cardImage;
	}

}
