package src;
import java.util.*;

class TE_Player extends Player{
	private int playerNum;
	private String name;
	private int winNum;
	public boolean isDealer = false;
	private int pid;
	private int money;
	private int bet;
	private boolean stand = false;
	private ArrayList<Card> hand;
	private int handVal;
	
	public TE_Player(String pname){ //normal player
		this.money = 100;
		this.winNum = 0;
		this.name = pname;
		this.pid = playerNum;
		this.playerNum++;
		this.hand = new ArrayList<>();
	}
	
	public TE_Player(int pname){
		this(String.valueOf(pname));
	}
	
	public void set_dealer(){
		this.money = (playerNum-1)*100;
		this.isDealer = true;
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
		this.bet = betNum;
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
	
	public String get_hand(){
		String str = "";
		return str;
	}
	
	public Card new_card(Card card){
		//todo
		//add new card to hand
		hand.add(card);
		handVal = calc_hand();
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
			str += "Player's hand: " + this.get_bet() + "\n";
			str += "Player's hand total values: " + this.get_handVal() + "\n";
			
			return str;
		}
		else{
			String str= "";
			str += "Dealer's name: " + this.get_name() + "\n";
			str += "Dealer's id: " + this.get_id() + "\n";
			str += "Dealer's money: " + this.get_money() + "\n";
			str += "Dealer's bet: " + this.get_bet() + "\n";
			str += "Dealer's hand: " + this.get_bet() + "\n";
			str += "Dealer's hand total values: " + this.get_handVal() + "\n";
			
			return str;
		}
		
	}
	
	public static void main(String[] args) {
		TE_Player jax = new TE_Player("Jax");
		System.out.println(jax);
	}
}
