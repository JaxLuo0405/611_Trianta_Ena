package src;
import java.util.*;

class Table {
	private ArrayList<TE_Player> curPlayers; //only players, no dealer
	private TE_Player dealer;
	private Decks decks;
	
	public Table(TE_Player[] players, TE_Player dealer){
		decks = new Decks();
		this.dealer = dealer;
		this.curPlayers = new ArrayList<>();
		int totMoney = 0;
		for(TE_Player player:players) {
			if (player.equals(dealer))
				continue;
			totMoney += player.get_money();
			(this.curPlayers).add(player);
		}
		this.dealer.set_dealer(totMoney);
	}
	
	//get players on table as an array
	public TE_Player[] get_players(){
		return (TE_Player[]) this.curPlayers.toArray();
	}
	
	// one card each player, face down. dealer one card face up
	// (default: card faces up)
	public void start_deal() throws InvalidDeckPositionException{
		System.out.println("Start dealing the first card to each player.");
		this.decks.shuffle();
		for(TE_Player player : this.curPlayers){
			player.add_card(this.decks.next_card(false)); //face down
		}
		dealer.add_card(this.decks.next_card()); //face up
	}
	
	public void ask_bet(){
		System.out.println(dealer);
		int betNum;
		ArrayList<TE_Player> folders = new ArrayList<>();
		for(TE_Player player:this.curPlayers){
			betNum = InOut.ask_player_bet(player);
			if(betNum==0) //fold
				folders.add(player);
			player.set_bet(betNum);
		}
		lose(folders);
	}
	
	public void deal_two_cards(){
		System.out.println("Giving two more cards to each player who has bet.");
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
			hit = InOut.hit_or_stand(player);
			if(!hit){
				player.stand();
				continue;
			}
			player.add_card(this.decks.next_card());
			if(player.get_handVal()>31){
				System.out.println("You busted. LOSER.");
				InOut.see_hand(player);
				System.out.println("-------------------------------------");
				return false;
			}
		}
		System.out.println("-------------------------------------");
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
		System.out.println("Dealer's turn!");
		//dealer reveal face down card
		for(TE_Player player : this.curPlayers){
			player.show_card();
		}
		//dealer gets hit until their hand >= 27
		while(this.dealer.get_handVal()<27){
			this.dealer.add_card(this.decks.next_card());
		}
		System.out.println(dealer);
		System.out.println(dealer.get_handVal());
	}
	
	//@return: winners as an arraylist
	public ArrayList<TE_Player> get_winners(){
		ArrayList<TE_Player> winners = new ArrayList<>();
		if(this.dealer.get_handVal()>31)
			return this.curPlayers;
		if(this.dealer.natural_win())
			return winners;
		for(TE_Player player : this.curPlayers){
			if(player.get_handVal()>this.dealer.get_handVal())
				winners.add(player);
			else if(player.natural_win()){
				winners.add(player);
			}
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
		System.out.println("Here is the current table situation:");
		System.out.println("-------------------------------------");
		String str = "";
		str += this.dealer.toString() + "\n";
		for(TE_Player player:this.curPlayers){
			str += player.toString()+"\n";
		}
		str += "-------------------------------------";
		return str;
	}
	
	public void one_round(int roundInt) throws InvalidDeckPositionException{
		InOut.start_round(roundInt);


		System.out.println(this);
		//InOut.print_table(table){}
		
		//start dealng with one card each player, face down. dealer one card face up
		start_deal();

		//ask player for bets: bet or fold
		ask_bet();

		//once everyone betted: player receive 2 cards face up
		deal_two_cards();

		System.out.println(this);

		
		//then start turn:
			//each player can hit or stand
			//if hit --> if bust --> pay banker, quit
			//after this method, all players stand or lose
		take_turns();


		
		//dealer reveal face down card???
			//dealer gets hit until their hand >= 27
		if(curPlayers.size()>0)
			dealer_turn();
			
		//return to TE, the players with hand value > dealer but <= 31 win
			//check_winner
	}
	
	public static void main(String[] args) {
	}
}