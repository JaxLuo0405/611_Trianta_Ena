package src;
import java.util.*;

class Trianta_Ena implements Game {
	public TE_Player[] players; //index == player id
//	public int dealerId;
	public TE_Player dealer;
	public Table table;
	private Decks decks;
	private static final int deckNum = 2;
	private static final int targetSum = 31;
	
	public Trianta_Ena(){
		decks = new Decks(deckNum);
	}
	
	public void check_winner() {
		this.table.check_winner();
	}
		
	public void play_game() throws InvalidDeckPositionException{
		//ask for the number of player + dealer
		int playerNum = InOut.num_players();
		
		//initialize players & dealers
		this.players = new TE_Player[playerNum];
		for (int i=0;i<playerNum;i++) {
			this.players[i] = new TE_Player(i,this.targetSum);
		}

		int roundNum = 0;
		boolean anotherRound = true;

		//get dealer index for first round
		this.dealer = players[InOut.get_dealer(players.length)];

		while(anotherRound){
			this.table = new Table(this.players, this.dealer, this.decks, this.targetSum);

			//start round
			this.table.one_round(roundNum++);
			check_winner();
			if(this.dealer.get_money()<=0){
				InOut.end_game();
				return;
			}
			System.out.println("-------------------------------------");
			for (TE_Player player: this.players){
				System.out.println(player);
			}

			anotherRound = InOut.one_more_round();
			if(!anotherRound)
				break;

			for(TE_Player player: players){
				player.clear();
			}

			this.change_dealer();
		}


	}
	public static TE_Player[] getSortedArray(TE_Player[] playerArray, Comparator<TE_Player> comparator) {
		TE_Player[] sorted = playerArray.clone();
		Arrays.sort(sorted, comparator);

		return sorted;
	}
	public void change_dealer(){
		TE_Player[] sorted_players = getSortedArray(this.players, Comparator.comparing(TE_Player::get_money).reversed());

		for(TE_Player player : sorted_players){
			if (player.get_money() <= dealer.get_money()){
				break;
			}
			boolean decision = InOut.ask_to_change_dealer(player.get_name());
			if(decision){
				this.dealer = player;

				System.out.println("Dealer changed to "+player.get_name());
				break;
			}
		}
		System.out.println("Dealer unchanged.");
	}

	public static void main(String[] args) throws InvalidCardSuitException, InvalidCardValueNameException {
	}
}