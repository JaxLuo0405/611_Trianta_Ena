package src;
import java.io.Serializable;
import java.util.*;
import java.util.Random;

public class Decks extends Exception implements Serializable{// This class is for the 2 decks of the card
    private int nextCardIndex;
    private int deckNum; //number of decks

    Card[] decks = new Card[104];

    public Decks(int n) {
        if(n<=0)
            throw new IllegalArgumentException("Number of decks must be at least one.");
        this.deckNum = n;
        int count = 0;
        String[] values = new String[]{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        List<String> valuesList = new ArrayList<>(Arrays.asList(values));
        try { // add two decks
            for (int i = 0; i <= 12; i++) {
                for(int d=0; d<deckNum; d++){
                    decks[count++] = new Card('H', valuesList.get(i));
                }
            }
            for (int i = 0; i <= 12; i++) {
                for(int d=0; d<deckNum; d++){
                    decks[count++] = new Card('S', valuesList.get(i));
                }
            }
            for (int i = 0; i <= 12; i++) {
                for(int d=0; d<deckNum; d++){
                    decks[count++] = new Card('C', valuesList.get(i));
                }
            }
            for (int i = 0; i <= 12; i++) {
                for(int d=0; d<deckNum; d++){
                    decks[count++] = new Card('D', valuesList.get(i));
                }
            }
        } catch (InvalidCardValueNameException | InvalidCardSuitException exp1) {

        }
        nextCardIndex = 0;
    }
    
    public Decks(){
        this(1);
    }
    
    
    private void is_index_good(int index) throws InvalidDeckPositionException {// this is to make sure the deck index is correct
        if (index < 0 || index > 103) {
            throw new InvalidDeckPositionException(index);
        }
    }
    
    
    public String toString(){
        String str = "";

        for (int i = 0; i < decks.length; i++) {
            str +=	decks[i].toString() + "\n";
            // break;
        }
        return str;
    }

    //helper function for shuffle()
    private void swap_cards(int index1, int index2) throws InvalidDeckPositionException {// server for randomized process
        is_index_good(index1);
        is_index_good(index2);
        Card hold = decks[index1];
        decks[index1] = decks[index2];
        decks[index2] = hold;
    }

    public void shuffle() throws InvalidDeckPositionException {
        Random rn = new Random();
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < decks.length; j++) {
                swap_cards(i, rn.nextInt(104));
            }
        }
        nextCardIndex = 0;
    }

    public Card get_card(int index) throws InvalidDeckPositionException {
        is_index_good(index);
        return decks[index];
    }

    public boolean compareTo(Decks otherDeck) throws InvalidDeckPositionException {
        for (int i=0; i < decks.length; i++){
            if (! decks[i].compareTo(otherDeck.get_card(i)) ) {
                return false;
            }
        }
        return true;
    }

    public Card next_card(boolean isShow) {
        if (nextCardIndex < 0 || nextCardIndex > 103) {
            System.out.println("Future exception goes here");
        }
        Card nextCard = decks[nextCardIndex++];
        nextCard.set_show(isShow);
        return nextCard;
    }
    
    public Card next_card() {
        return next_card(true);
    }

//    public static void main(String[] args) throws InvalidDeckPositionException {
//        Decks jax  = new Decks();
//
//        System.out.println(jax);
//        jax.shuffle();
//        System.out.println(jax);
//    }
}
