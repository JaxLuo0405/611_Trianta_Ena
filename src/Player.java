package src;

/*The class for a player, from Jessica's PA1========================================================*/
class Player{
	public static int playerNum = 0;
	public String name;
	public String piece;
	private int winNum;
	
	public Player(String p){
		playerNum ++;
		winNum = 0;
		piece = p;
		name = "Player "+p;
	}
	
	public void set_name(String pname){
		name = pname;
	}
	
	public void update_win(){
		winNum++;
	}
	
	public int get_win(){
		return winNum;
	}
	
	public void reset_win(){
		winNum = 0;
	}
}
/*=====================================================================*/