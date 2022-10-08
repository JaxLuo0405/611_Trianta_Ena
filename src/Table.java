package src;
import java.util.*;

class Table {
	public ArrayList<TE_Player> playersOnTable;
	public int dealerInd;
	
	public Table(TE_Player[] players){
		playersOnTable = new ArrayList<>();
		for(int i=0; i<players.length; i++){
			playersOnTable.add(players[i]);
		}
	}
	
	//get players on table as an array
	public TE_Player[] get_players(){
		return (TE_Player[]) playersOnTable.toArray();
	}
	
	//folds or loses
	public void remove_player(Player player){
		playersOnTable.remove(player);
	}
	
	
	
	//public String toString(){}
	
	public static void main(String[] args) {
	}
}