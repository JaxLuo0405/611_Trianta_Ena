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
		ArrayList<TE_Player> folders = new ArrayList<>();
		for(TE_Player player:this.curPlayers){
			betNum = InOut.ask_player_bet(player.get_money());
			if(betNum==0) //fold
				folders.add(player);
			player.set_bet(betNum);
		}
		lose(folders);
	}
	
	public void deal_two_cards(){
		TE_Player player;
		for(int p=0; p<this.curPlayers.size(); p++){
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
	
	//@return: false means lost; true means stand
	public boolean turn(TE_Player player){
		boolean hit;
		while(!player.get_stand()){
			hit = InOut.hit_or_stand();
			if(!hit){
				player.stand();
				continue;
			}
			player.add_card(this.decks.next_card());
			if(player.get_handVal()>31)
				return false;
		}
		return true;
	}
	
	public void take_turns(){
		ArrayList<TE_Player> losers = new ArrayList<>();
		for(TE_Player player : this.curPlayers){
			turn(player);
			if(!player.get_stand()) //lost
				losers.add(player);
		}
		lose(losers);
	}
	
	public void dealer_turn(){
		//dealer reveal face down card
		for(TE_Player player : this.curPlayers){
			player.show_card();
		}
		//dealer gets hit until their hand >= 27
		while(this.dealer.get_handVal()<27){
			this.dealer.add_card(this.decks.next_card());
		}
	}
	
	//@return: winners as an arraylist
	public ArrayList<TE_Player> get_winners(){
		ArrayList<TE_Player> winners = new ArrayList<>();
		if(this.dealer.get_handVal()>31)// || this.dealer.natural_win())
			return this.curPlayers;
		for(TE_Player player : this.curPlayers){
			if(player.get_handVal()>this.dealer.get_handVal())
				winners.add(player);
			/*else if(player.natural_win()){
				winner.add(player);
			}*/
		}
		return winners;
	}
	
	public void pay_bet(ArrayList<TE_Player> winners){
		for(TE_Player player: this.curPlayers){
			if(winners.contains(player)){ //a winner
				dealer.pay(player.get_bet());
				player.gain();
			}
			else{ //lost
				player.pay();
				dealer.gain(player.get_bet());
			}
		}
		
	}
	
	public void check_winner(){
		ArrayList<TE_Player> winners = get_winners();
		pay_bet(winners);
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
		this.curPlayers.remove(this.dealer);
		
		//print table
		//InOut.print_table(table){}
		
		//ask player for bets: bet or fold
		ask_bet();
		
		//once everyone betted: player receive 2 cards face up
		deal_two_cards();
		
		//then start turn:
			//each player can hit or stand
			//if hit --> if bust --> pay banker, quit
			//after this method, all players stand or lose
		take_turns();
		
		//dealer reveal face down card???
			//dealer gets hit until their hand >= 27
		dealer_turn();
			
		//return to TE, the players with hand value > dealer but <= 31 win
			//check_winner
	}
	
	public static void main(String[] args) {
	}
}