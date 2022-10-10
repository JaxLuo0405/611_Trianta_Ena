package src;
import java.util.*;

class Table {
	private ArrayList<TE_Player> curPlayers;
	private TE_Player dealer;
	private int dealerId;
	private Decks decks;
	
	public Table(TE_Player[] players){
		decks = new Decks();
		this.curPlayers = new ArrayList<>();
		for(int i=0; i<players.length; i++){
			(this.curPlayers).add(players[i]);
		}
	}
	
	//get players on table as an array
	public TE_Player[] get_players(){
		return (TE_Player[]) curPlayers.toArray();
	}
	
	// one card each player, face down. dealer one card face up
	// (default: card faces up)
	public void start_deal() throws InvalidDeckPositionException{
		decks.shuffle();
		for(int p=0; p<curPlayers.size(); p++){
			if(curPlayers.get(p).get_id()==dealerId) //face down
				curPlayers.get(p).add_card(decks.next_card());
			else
				curPlayers.get(p).add_card(decks.next_card(false));
		}
	}
	
	public void ask_bet(){
		int betNum;
		for(int p=0; p<curPlayers.size(); p++){
			if(p==dealerId)
				continue;
			betNum = InOut.ask_player_bet();
			if(betNum==0){ //fold
				curPlayers.remove(p);
				continue;
			}
			curPlayers.get(p).set_bet(betNum);
		}
	}
	
	public void deal_two_cards(){
		TE_Player player;
		for(int p=0; p<this.curPlayers.size(); p++){
			if(p==dealerId)
				continue;
			player = this.curPlayers.get(p);
			player.add_card(this.decks.next_card());
			player.add_card(this.decks.next_card());
		}
	}
	
	//pay banker & quit
	public void lose(TE_Player loser){
		loser.pay();
		this.dealer.gain(loser.get_bet());
		this.curPlayers.remove(loser);
	}
	
	public void lose(ArrayList<TE_Player> losers){
		for(TE_Player loser : losers)
			lose(loser);
	}
	
	//@return: false means lost
	public boolean turn(TE_Player player){
		boolean hit = InOut.hit_or_stand();
		if(!hit){
			player.stand();
			return true;
		}
		player.add_card(this.decks.next_card());
		if(player.get_handVal()>31)
			return false;
		return true;
	}
	
	public void one_turn(){
		ArrayList<TE_Player> losers = new ArrayList<>();
		for(TE_Player player : this.curPlayers){
			if(player.get_stand())
				continue;
			if(!turn(player)) //lost
				losers.add(player);
		}
		lose(losers);
	}
	
	// to print the table
	public String toString(){
		return null;
	}
	
	public void one_round(int roundInt) throws InvalidDeckPositionException{
		InOut.start_round(roundInt);
		
		//get dealer index
		this.dealerId = InOut.get_dealer(curPlayers.size());
		this.dealer = this.curPlayers.get(this.dealerId);
		this.curPlayers.get(this.dealerId).set_dealer();
		
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
		one_turn();
		
		
		
		//if for a turn all players stand or busted --> dealer reveal face down card???
			//dealer gets hit until their hand >=27
		//the players with hand value > dealer but <= 31 win
	}
	
	public static void main(String[] args) {
	}
}