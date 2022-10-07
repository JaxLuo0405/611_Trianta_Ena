package src;
import java.util.*;

class Trianta_Ena implements Game {
	public TE_Player[] players;
	public int dealerInd;
	
	
	public boolean check_winner() {
		return false;
	}
	
	public void one_round(){}
	
	public void play_game(){
		//ask for the number of player + dealer
		int playerNum = InOut.num_players();
		
		//initialize players & dealers
		players = new TE_Player[playerNum];
		for (int i=0;i<playerNum;i++) {
			players[i] = new TE_Player(i);
		}
		
		//get dealer index
		dealerInd = InOut.get_dealer();
		
		one_round();
		//start round
			//print everyones money
			//start dealng with one card each player, face down. dealer one card face up
			//print table
			//ask player for bets: bet or fold
			//once everyone betted: player receive 2 cards face up
				//if bust --> pay banker, quit
			//then start turn:
				//each player can hit or stand
				//if hit --> if bust --> pay banker, quit
			//if for a turn all players stand or busted --> dealer reveal face down card???
				//dealer gets hit until their hand >=27
			//the players with hand value > dealer but <= 31 win
		
		
	}
	
	public static void main(String[] args) {
	}
}