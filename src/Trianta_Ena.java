package src;
import java.util.*;

class Trianta_Ena implements Game {
	public TE_Player[] players; //index == player id
	public Table table;
	
	
	public Trianta_Ena(){
		
	}
	
	public boolean check_winner() {
		return false;
	}
		
	public void play_game() throws InvalidDeckPositionException{
		//ask for the number of player + dealer
		int playerNum = InOut.num_players();
		
		//initialize players & dealers
		players = new TE_Player[playerNum];
		for (int i=0;i<playerNum;i++) {
			players[i] = new TE_Player(i);
		}
		
		table = new Table(players);
		
		int roundNum = 0;
		//start round
		table.one_round(roundNum++);
	}
	
	public static void main(String[] args) {
	}
}