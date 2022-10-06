package src;

//	public choose_dealer(int d){ outside, make player with pid=d dealer, change money

//extends player
class TE_Player extends Player{
	/*	public static int playerNum = 0;
	public String name; */
	private int winNum; 
	public boolean isDealer = false;
	private int pid;
	private int money;
	private int bet;
	private Card[] hand;
	private int handVal;
	
	public TE_Player(String pname){ //normal player
		money = 100;
		winNum = 0;
		name = pname;
		pid = playerNum;
		playerNum++;
	}
	
	public void set_dealer(){
		money = (playerNum-1)*100;
		isDealer = true;
	}
	
	public int get_money(){
		return money;
	}
	
	public Card new_card(){
		//todo
		return null;
	}
	
	public int add_hand(){
		int totNum = 0;
		for(int c = 0; c<hand.length; c++){
			totNum += hand[c].getValue();
		}
		handVal = totNum;
		return totNum;
	}
	
	
	
	
	public static void main(String[] args) {
	}
}