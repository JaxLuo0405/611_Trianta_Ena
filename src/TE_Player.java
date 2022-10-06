package src;

//	public choose_dealer(int d){ outside, make player with pid=d dealer, change money

//extends player
class TE_Player {
	/*	public static int playerNum = 0;
	public String name;
	private int winNum; */
	public boolean isDealer = false;
	private int pid;
	private int money;
	private Card[] hand;
	
	public TE_Player(String pname){ //normal player
		money = 100;
		winNum = 0;
		name = pname;
		pid = playerNum;
		playerNum++;
	}
	
	public void set_dealer_money(){
		money = (playerNum-1)*100;
	}
	
	public int get_money(){
		return money;
	}
	
	public Card new_card(){
		//todo
		return null;
	}
	
	public int add_cards(){
		//todo add the value of the deck of cards
		return 0;
	}
	
	
	
	
	public static void main(String[] args) {
	}
}