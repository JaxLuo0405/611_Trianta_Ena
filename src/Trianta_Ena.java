package src;
import java.util.*;

class Trianta_Ena implements Game {
	public TE_Player[] players;
	public Table table;
	public int dealerInd;
	public Decks decks;
	
	public Trianta_Ena(){
		decks = new Decks();
	}
	
	public boolean check_winner() {
		return false;
	}
	
	//one card each player, face down. dealer one card face up
	//default card faces up
	public void start_deal(){
		decks.shuffle();
		for(int p=0; p<players.length; p++){
			if(p==dealerInd)
				players[p].add_card(decks.nextCard());
			else
				players[p].add_card(decks.nextCard(false));
		}
	}
	
	public void ask_bet(){
		int betNum;
		for(int p=0; p<players.length; p++){
			if(p==dealerInd)
				continue;
			betNum = InOut.ask_player_bet();
			if(betNum==0){ //fold
				//table.remove_player(p);
				continue;
			}
			players[p].set_bet(betNum);
		}
	}
	
	public void deal_two_cards(){
		Player player;
		for(int p=0; p<players.length; p++){
			if(p==dealerInd)
				continue;
			player = players[p];
			player.add_card(decks.nextCard());
			player.add_card(decks.nextCard());
			if(player.get_handVal()>31)
				//pay banker and quit
				return;
		}
	}
	
	public void one_round(int roundInt){
		InOut.start_round(roundInt);
		
		//print everyones money
		//InOut.print_table(table){}
		
		//start dealng with one card each player, face down. dealer one card face up
		start_deal();
		
		//print table
		//InOut.print_table(table){}
		
		//ask player for bets: bet or fold
		ask_bet();
		
		//once everyone betted: player receive 2 cards face up
			//if bust --> pay banker, quit
		deal_two_cards();
		
		//then start turn:
			//each player can hit or stand
			//if hit --> if bust --> pay banker, quit
		//if for a turn all players stand or busted --> dealer reveal face down card???
			//dealer gets hit until their hand >=27
		//the players with hand value > dealer but <= 31 win
	}
	
	public void play_game(){
		//ask for the number of player + dealer
		int playerNum = InOut.num_players();
		
		//initialize players & dealers
		players = new TE_Player[playerNum];
		for (int i=0;i<playerNum;i++) {
			players[i] = new TE_Player(i);
		}
		//table = new Table(players);
		
		//get dealer index
		dealerInd = InOut.get_dealer();
		players[dealerInd].set_dealer();
		
		int roundNum = 0;
		//start round
		one_round(roundNum++);
		
	}
	
	public static void main(String[] args) {
	}
}