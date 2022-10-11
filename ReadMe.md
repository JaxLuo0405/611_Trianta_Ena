 CS611-Assignment #2
## Trianta Ena
---------------------------------------------------------------------------
Qingyan (Jessica) Chen  
qychen@bu.edu  
U89340835

Shengyao (Jax) Luo
jaxluo@bu.edu
U18543513


## Files
---------------------------------------------------------------------------
All .java files package cs611pa2.
**Cards.java


## Notes
---------------------------------------------------------------------------
N/A


## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "611_Trianta_Ena" after unzipping the files
2. Run the following instructions:
```
javac src/Main.java
java src.Main
```


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
Dealer's money: 100
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
Dealer's money: 100
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
Dealer's money: 100
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
Dealer's money: 150
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
Dealer's money: 110
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
