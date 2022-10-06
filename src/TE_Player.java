package src;

import java.util.*;

//	public choose_dealer(int d){ outside, make player with pid=d dealer, change money

/*To start each round, the Dealer deals one card to each player. The card that the Players are
dealt is kept face down and known only to each Player. The first card the Dealer is dealt
is kept face up and known to all the Players and the Dealer. After each player receives
their first card, they place their bet or choose to fold without betting. Once all bets have
been made, each player with a standing bet receives two more cards face up. After each
player has three cards (one down, two up), each Player in turn may either hit or stand */

class TE_Player extends Player{
	/*	public static int playerNum = 0;
	public String name; */
	private int winNum; 
	public boolean isDealer = false;
	private int pid;
	private int money;
	private int bet;
	private boolean stand = false;
	private ArrayList<Card> hand;
	private int handVal;
	
	public TE_Player(String pname){ //normal player
		money = 100;
		winNum = 0;
		name = pname;
		pid = playerNum;
		playerNum++;
		hand = new ArrayList<>();
	}
	
	public void set_dealer(){
		money = (playerNum-1)*100;
		isDealer = true;
	}
	
	public void fold(){
		//???
	}
	
	public void stand(){
		stand = true;
	}
	
	public int get_money(){
		return money;
	}
	
	public Card new_card(Card card){
		//todo
		//add new card to hand
		hand.add(card);
		handVal = add_hand();
		return null;
	}
	
	public int add_hand(){
		int totNum = 0;
		int aceFlag = 0;
		Card card;
		for(int c = 0; c<hand.size(); c++){
			card = hand.get(c);
			totNum += card.get_value();
			if(card.get_name()=="Ace" && aceFlag<2)
				aceFlag++;
		}
		for(int i=aceFlag;i>0;i++){
			if(totNum+10<=31)
				totNum += 10;
		}
		return totNum;
	}
	
	
	public static void main(String[] args) {
	}
}