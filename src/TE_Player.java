package src;

import java.sql.SQLOutput;
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
	
	public TE_Player(int pname){
		this(String.valueOf(pname));
	}
	
	public void set_dealer(){
		money = (playerNum-1)*100;
		isDealer = true;
	}
	
	public void fold(){
		
	}

	public int get_id(){
		return this.pid;
	}
	public String get_name(){
		return this.name;
	}



	
	public void set_bet(int betNum){
		//if(bet<money)
		bet = betNum;
	}
	

	public void stand(){
		stand = true;
	}
	
	public int get_money(){
		return this.money;
	}


	public int get_bet(){
		return this.bet;
	}

	public void print_hand() {//print hands' cards and values
		int val = 0;


		while (this.hand.size() > val) {

			System.out.println(this.hand.get(val));
			val++;
		}
		System.out.println("Total values:" + " " +this.add_hand());

	}

	public Card new_card(Card card){
		//todo
		//add new card to hand
		hand.add(card);
		handVal = add_hand();
		return null;
	}
	
	public int get_handVal(){
		return handVal;
	}
	
	public void add_card(Card card){

		//todo
		//add new card to hand
		hand.add(card);
		handVal = calc_hand();
	}
	
	public int calc_hand(){
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
	public String toString(){
		if (this.isDealer){
			String str= "";
			str += "Player's name: " + this.get_name() + "\n";
			str += "Player's id: " + this.get_id() + "\n";
			str += "Player's money: " + this.get_money() + "\n";
			str += "Player's bet: " + this.get_bet() + "\n";
			str += "Player's hand: ";
			this.print_hand();
			return str;
		}
		else{
			String str= "";
			str += "Dealer's name: " + this.get_name() + "\n";
			str += "Dealer's id: " + this.get_id() + "\n";
			str += "Dealer's money: " + this.get_money() + "\n";
			str += "Dealer's bet: " + this.get_bet() + "\n";
			str += "Dealer's hand: ";
			this.print_hand();
			return str;
		}

	}
	
	public static void main(String[] args) {
		TE_Player jax = new TE_Player("Jax");
		System.out.println(jax);
	}
}