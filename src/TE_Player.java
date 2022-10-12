package src;
import java.util.*;

class TE_Player extends Player{
	private static int playerNum;
	private static int targetSum;
	private String name;
	private int winNum;
	private boolean isDealer = false;
	private int pid;
	private int money;
	private int bet;
	private boolean stand = false;
	private ArrayList<Card> hand;
	private int handVal;

	public void clear(){
		this.handVal = 0;
		this.bet = 0;
		this.hand = new ArrayList<Card>();
		this.stand = false;
		this.isDealer = false;
	}
	
	public TE_Player(String pname, int sum){ //normal player
		this.targetSum = sum;
		this.money = 100;
		this.winNum = 0;
		this.name = pname;
		this.pid = playerNum;
		this.playerNum++;
		this.hand = new ArrayList<Card>();
	}
	
	public TE_Player(int pname, int sum){
		this("Player "+String.valueOf(pname), sum);
	}

	public void init_dealer(){
		this.money = 100*(playerNum-1);
		this.isDealer = true;
	}
	
	public void set_dealer(){
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
		//add new card to hand
		this.hand.add(card);
		this.handVal = this.calc_hand();
	}
	
	public int calc_hand(){
		int totNum = 0;
		int aceFlag = 0;
		Card card;
		for(int c = 0; c<this.hand.size(); c++){
			card = this.hand.get(c);
			totNum += card.get_value();
			if(card.get_name()=="Ace" && aceFlag<2)
				aceFlag++;
		}
		for(int i=aceFlag;i>0;i--){
			if(totNum+10<=this.targetSum)
				totNum += 10;
		}
		return totNum;
	}

	public String get_hand_player(){
		String str = "";
		for(Card card: this.hand){
			str += card.toString() + "\n";
		}
		return str;
	}

	public String get_hand(){
		String str = "";
		for(Card card : this.hand){
			if(card.get_show())
				str += card.toString() + "\n";
			else
				str += "🃏\n" ;
		}
		return str;
	}
	public ArrayList<Card> return_hand(){
		return this.hand;
	}
	public void pay(int betAmount){
		this.money -= betAmount;
	}
	
	public void pay(){
		System.out.println(this.name+ " pays " + this.bet + " to the dealer ");
		pay(this.bet);
	}

	public void gain(int betAmount){
		this.money += betAmount;
	}
	
	public void gain(){
		System.out.println(this.name+ " gets " + this.bet + " from the dealer ");
		gain(this.bet);
	}
	
	public boolean natural_win(){
		if(this.handVal!=this.targetSum)
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

	public boolean equals(TE_Player otherPlayer){
		if(this.pid==otherPlayer.get_id())
			return true;
		return false;
	}

	public String toString() {
		String string = "";
		String start_str;
		if(this.isDealer)
			start_str = "Dealer's ";
		else
			start_str = "Player's ";

		string += start_str+"name: " + this.get_name() + "\n";
		string += start_str+"id: " + this.get_id() + "\n";
		string += start_str+"money: " + this.get_money() + "\n";
		string += start_str+"bet: " + this.get_bet() + "\n";
		string += start_str+"hand: \n" + this.get_hand();
//		string += start_str+"hand total values: " + this.get_handVal() + "\n";

		return string;
	}


	
	public static void main(String[] args) throws InvalidCardSuitException, InvalidCardValueNameException {
		TE_Player jax = new TE_Player("Jax");
		jax.add_card(new Card('H',"Two"));
		System.out.println(jax.get_handVal());
		jax.add_card(new Card('S',"Queen"));
		System.out.println(jax.get_handVal());
		jax.add_card(new Card('D',"Five"));
		System.out.println(jax.get_handVal());
		jax.add_card(new Card('D',"Ten"));
		System.out.println(jax.get_handVal());
	}
}