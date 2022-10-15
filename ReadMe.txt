 CS611-Assignment #2
## Trianta Ena
---------------------------------------------------------------------------
Qingyan (Jessica) Chen  
qychen@bu.edu  
U89340835

Shengyao (Jax) Luo
jaxluo@bu.edu
U18543513

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "611_Trianta_Ena" after unzipping the files
2. Run the following instructions:
```
javac src/Main.java
java src.Main
```
You can also git clone our codes by running 
```
git clone git@github.com:JaxLuo0405/611_Trianta_Ena.git
```

java SDK setting:  Oracle OpenJDK version 19
## Teamwork demonstration
---------------------------------------------------------------------------
We created a github repo for this prohject and the progress is reflected in the commit messages. 
https://github.com/JaxLuo0405/611_Trianta_Ena


## Files
---------------------------------------------------------------------------
### Card.java:
This class depicts the card object used in Trianta Ena game. It contains information of one card like suit, value, and name. Additionally, we also give each card a boolean called show to declare it's face down or up. We add one emoji 🃏 to print the face down card, which is pretty fun :)

### Decks.java:
This class depicts two decks of card objects. This mainly includes the mechanism to shuffle the decks to make sure the players will get random cards in the game. it contains swap_cards used for shuffle decks and next_card for players to acquire cards each time. We also add the cardDict variable in Decks, which will be passed as an input parameters to the Card constructor to make name:value pair assignments more concise.

### InOut.java:
This class depicts the main block of the print messages in the terminal block during the game, which contains several methods like num_players(), get_dealer(),start_round(),see_hand(), ask_player_bet(), hit_or_stand(), one_more_round(),ask_to_change_dealer().

### Player.java:
This class is one of the classes from Jessica's PA1. It has three variables: name, playerNum and winNum.

### TE_Player.java
This class depicts the human player of the Trianta Ena game. We give it a boolean variable IsDealer to declare if this TE_Player is a dealer or a normal player. Besides we have String variable name, integer variables playerNum and winNum extended from Player.java; We also have player id, and player money, player bet. Finally, we have an arraylist of Card objects called hand to record the current cards that one TE_Player holds.

### InvalidCardSuitException.java/InvalidCardValueNameException.java/InvalidDeckPositionException.java
These three classes are all extended from Exception class, which is also a common way to handle the exception output cases. We use these three cases to test the card and decks classes output. Each exception class handles the error message as its name literally says.

### Table.java
This class depicts the table of the current Trianta Ena game. It has three variables: curPlayers records the current list of players still playing in the table. dealer is the current dealer as a TE_Player object. Decks as the decks object are the two decks used for the table. This class contains methods of handling the process of the game like start-deal, ask_bet, deal_two_cards ... 

### Game.java
This class is a simple interface which contains checkwinner(), one_round(), and play_game() methods from Jax's PA1. 

### Trianta_Ena.java
This class is implemented from Game.java and hold the whole progress of the Trianta Ena game. It has several variables: TE_Player[] players as all the players entering the whole game.  TE_Player dealer is the dealer. Table table is the game table object. it has one more change_dealeer function served for the functionality of switiching dealers if needed.

### Main.java 
This class is just to initalize a Trianta_Ena class and run that play_game method in it.
## Notes
---------------------------------------------------------------------------
Extendibility of PA1 is partly mentioned in this txt. For more information, there is one hw_design pdf which includes the initial design, paragraphs of explaining extendibility, and graph of extendibility demonstration.



## Input/Output Example
---------------------------------------------------------------------------
Output:
Welcome to play Trianta Ena! Please enter the number of players (including dealer):
Input: 3
Output:
Which player index would you like to be the dealer?
Input: 0
Output:
Round 0 starts!
Here is the current table situation:
-------------------------------------
Dealer's name: Player 0
Dealer's id: 0
Dealer's money: 200
Dealer's bet: 0
Dealer's hand: 

Player's name: Player 1
Player's id: 1
Player's money: 100
Player's bet: 0
Player's hand: 

Player's name: Player 2
Player's id: 2
Player's money: 100
Player's bet: 0
Player's hand: 

-------------------------------------
Start dealing the first card to each player.
Dealer's name: Player 0
Dealer's id: 0
Dealer's money: 200
Dealer's bet: 0
Dealer's hand: 
Spades Queen


Here is your current hand, Player 1:
Hearts Jack

Your current hand value is: 10
Here is your current hand values: 10
Here is your current money: 100
Here is your current bet: 0
Player 1, would you like to bet or fold? (b/f)
Input: b
Output:
How much would you like to bet?
Input: 50
Output:
Here is your current hand, Player 2:
Diamonds Seven

Your current hand value is: 7
Here is your current hand values: 7
Here is your current money: 100
Here is your current bet: 0
Player 2, would you like to bet or fold? (b/f)
Input: b
Output:
How much would you like to bet?
Input: 40
Output:
Giving two more cards to each player who has bet.
Here is the current table situation:
-------------------------------------
Dealer's name: Player 0
Dealer's id: 0
Dealer's money: 200
Dealer's bet: 0
Dealer's hand: 
Spades Queen

Player's name: Player 1
Player's id: 1
Player's money: 100
Player's bet: 50
Player's hand: 
🃏
Clubs Seven
Diamonds Nine

Player's name: Player 2
Player's id: 2
Player's money: 100
Player's bet: 40
Player's hand: 
🃏
Spades Four
Spades Eight

-------------------------------------

Here is your current hand, Player 1:
Hearts Jack
Clubs Seven
Diamonds Nine

Your current hand value is: 26
Player 1, would you like to hit or stand? (h/s)
Input: h
Output:
You busted. LOSER.

Here is your current hand, Player 1:
Hearts Jack
Clubs Seven
Diamonds Nine
Spades Ten

Your current hand value is: 36
-------------------------------------

Here is your current hand, Player 2:
Diamonds Seven
Spades Four
Spades Eight

Your current hand value is: 19
Player 2, would you like to hit or stand? (h/s)
Input: h
Output:
Here is your current hand, Player 2:
Diamonds Seven
Spades Four
Spades Eight
Hearts Ten

Your current hand value is: 29
Player 2, would you like to hit or stand? (h/s)
Input: s
Output:
-------------------------------------
Player 1 pays 50 to the dealer 
Dealer's turn!
Dealer's name: Player 0
Dealer's id: 0
Dealer's money: 250
Dealer's bet: 0
Dealer's hand: 
Spades Queen
Spades Jack
Clubs Five
Spades Queen

35
Player 2 gets 40 from the dealer 
-------------------------------------
Dealer's name: Player 0
Dealer's id: 0
Dealer's money: 210
Dealer's bet: 0
Dealer's hand: 
Spades Queen
Spades Jack
Clubs Five
Spades Queen

Player's name: Player 1
Player's id: 1
Player's money: 50
Player's bet: 50
Player's hand: 
🃏
Clubs Seven
Diamonds Nine
Spades Ten

Player's name: Player 2
Player's id: 2
Player's money: 140
Player's bet: 40
Player's hand: 
Diamonds Seven
Spades Four
Spades Eight
Hearts Ten

Would you like to play one more round?(y/n)
Input: n
Output: End of Trianta Ena. Bye!
