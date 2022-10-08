package src;
import java.util.*;

class Trianta_Ena implements Game {
	public TE_Player[] players; //index == player id
	public Table table;
	public int dealerId;
	public Decks decks;
	
	public Trianta_Ena(){
		decks = new Decks();
	}
	
	public boolean check_winner() {
		return false;
	}
	
	//one card each player, face down. dealer one card face up
	// (default: card faces up)
	public void start_deal() throws InvalidDeckPositionException{
		decks.shuffle();
		for(int p=0; p<players.length; p++){
			if(p==dealerId)
				players[p].add_card(decks.next_card());
			else
				players[p].add_card(decks.next_card(false));
		}
	}
	
	public void ask_bet(){
		int betNum;
		for(int p=0; p<players.length; p++){
			if(p==dealerId)
				continue;
			betNum = InOut.ask_player_bet();
			if(betNum==0){ //fold
				table.remove_player(players[p]);
				continue;
			}
			players[p].set_bet(betNum);
		}
	}
	
	public void deal_two_cards(){
		TE_Player player;
		for(int p=0; p<players.length; p++){
			if(p==dealerId)
				continue;
			player = players[p];
			player.add_card(decks.next_card());
			player.add_card(decks.next_card());
			if(player.get_handVal()>31) //if bust --> pay banker, quit
				//pay banker and quit
				return;
		}
	}
	
	public void one_round(int roundInt) throws InvalidDeckPositionException{
		InOut.start_round(roundInt);
		
		table = new Table(players);
		
		//print everyones money
		//InOut.print_table(table){}
		
		//start dealng with one card each player, face down. dealer one card face up
		start_deal();
		
		
		//print table
		//InOut.print_table(table){}
		
		//ask player for bets: bet or fold
		ask_bet();
		
		//once everyone betted: player receive 2 cards face up
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
		dealerId = InOut.get_dealer();
		players[dealerId].set_dealer();
		
		int roundNum = 0;
		//start round
		//one_round(roundNum++);
		
	}
	
	public static void main(String[] args) {
	}
}