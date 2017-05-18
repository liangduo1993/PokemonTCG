package com.pokemon.Main;

import java.awt.Graphics;
import java.util.ArrayList;

public class Player extends GameObject {

	protected ArrayList<Card> allCards, deck, hand, bench, poke, graveyard; // 所有卡，牌堆，手牌，bench卡，场上卡，亡卡

	public Player() {
		allCards = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		bench = new ArrayList<Card>();
		poke = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
		
		for (int i = 0; i < 7; i++) {
			hand.add(new Card());
		}
	}
	
	
	
	public void update(){
		for(int i = 0; i < hand.size(); i++){
			hand.get(i).setX(500 + 50 * i);
			hand.get(i).setY(780);			
		}	
		
	}
	
	
	

	public void draw(Graphics g) {
			
		
	
	}

	
	
	
	public ArrayList<Card> getAllCards() {
		return allCards;
	}

	public void setAllCards(ArrayList<Card> allCards) {
		this.allCards = allCards;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<Card> getBench() {
		return bench;
	}

	public void setBench(ArrayList<Card> bench) {
		this.bench = bench;
	}

	public ArrayList<Card> getPoke() {
		return poke;
	}

	public void setPoke(ArrayList<Card> poke) {
		this.poke = poke;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	public void setGraveyard(ArrayList<Card> graveyard) {
		this.graveyard = graveyard;
	}
	
	

}
