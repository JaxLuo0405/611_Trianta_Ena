package src;
import java.util.*;

class Table {
	public ArrayList<TE_Player> players;
	public int dealerId;
	public Decks decks;
	
	public Table(TE_Player[] players){
		decks = new Decks();
		this.players = new ArrayList<>();
		for(int i=0; i<players.length; i++){
			(this.players).add(players[i]);
		}
	}
	
	//get players on table as an array
	public TE_Player[] get_players(){
		return (TE_Player[]) players.toArray();
	}
	
	//folds or loses
	public void remove_player(Player player){
		players.remove(player);
	}
	
	// one card each player, face down. dealer one card face up
	// (default: card faces up)
	public void start_deal() throws InvalidDeckPositionException{
		decks.shuffle();
		for(int p=0; p<players.size(); p++){
			if(p==dealerId)
				//check for correctness
				players.get(p).add_card(decks.next_card());
			else
				players.get(p).add_card(decks.next_card(false));
		}
	}
	
	public void ask_bet(){
		int betNum;
		for(int p=0; p<players.size(); p++){
			if(p==dealerId)
				continue;
			betNum = InOut.ask_player_bet();
			if(betNum==0){ //fold
				this.remove_player(players.get(p));
				continue;
			}
			
			
			players.get(p).set_bet(betNum);
		}
	}
	
	public void deal_two_cards(){
		TE_Player player;
		for(int p=0; p<players.size(); p++){
			if(p==dealerId)
				continue;
			player = players.get(p);
			player.add_card(decks.next_card());
			player.add_card(decks.next_card());
			if(player.get_handVal()>31) //if bust --> pay banker, quit
				//pay banker and quit
				return;
		}
	}
	
	public void one_round(int roundInt) throws InvalidDeckPositionException{
		InOut.start_round(roundInt);
		
		//get dealer index
		dealerId = InOut.get_dealer();
		players.get(dealerId).set_dealer();
		
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
	
	public static void main(String[] args) {
	}
}