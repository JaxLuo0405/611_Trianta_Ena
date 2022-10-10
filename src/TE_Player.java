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
	
	public boolean get_stand(){
		return stand;
	}
	
	public int get_money(){
		return this.money;
	}
	
	public int get_bet(){
		return this.bet;
	}
	
	public int get_handVal(){
		return handVal;
	}
	
	public void show_card(){
		this.hand.get(0).set_show(true);
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

	public String get_hand(){
		String str = "";
		for(int i = 0; i < this.hand.size(); i++){
			str += this.hand.get(i).toString() + "\n";

		}
		return str;
	}

	public void pay(int betAmount){
		this.money -= betAmount;
	}
	
	public void pay(){
		pay(this.bet);
	}

	public void gain(int betAmount){
		this.money += betAmount;
	}
	
	public void gain(){
		gain(this.bet);
	}
	
	public boolean natural_win(){
		if(this.handVal!=31)
			return false;
		if(this.hand.size()!=3)
			return false;
		int faceNum = 0;
		for(Card card: hand){
			if(card.get_name().equals("Jack") || card.get_name().equals("Queen") || card.get_name().equals("King"))
				faceNum ++;
		}
		if(faceNum==2)
			return true;
		return false;
	}
	
	public String toString() {
		String string = "";
		String start_str;
		if(this.isDealer)
			start_str = "Player's ";
		else
			start_str = "Dealer's ";

		string += start_str+"name: " + this.get_name() + "\n";
		string += start_str+"id: " + this.get_id() + "\n";
		string += start_str+"money: " + this.get_money() + "\n";
		string += start_str+"bet: " + this.get_bet() + "\n";
		string += start_str+"hand: \n \n" + this.get_hand() + "\n";
		string += start_str+"hand total values: " + this.get_handVal() + "\n";

		return string;
	}

	
	public static void main(String[] args) throws InvalidCardSuitException, InvalidCardValueNameException {
		ArrayList<String> str = new ArrayList<>();
		str.add("a");
		str.add("b");
		str.add("c");
		str.add("d");
		for(String s : str){
			if(str.indexOf(s)==1){
				str.remove(s);
			}
			System.out.println(s);
		}
	}
}