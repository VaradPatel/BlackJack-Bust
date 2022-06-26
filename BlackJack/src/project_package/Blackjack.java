package project_package;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("Welcome to Blackjack!");
         //creating playing deck
         Deck playingDeck=new Deck();
         
         playingDeck.createFullDeck();
         playingDeck.shuffle();
         System.out.println(playingDeck);
         Deck playerDeck=new Deck();
         Deck dealerDeck=new Deck();
         Double playerMoney=100.00;
         Scanner userInput=new Scanner(System.in);
        
         while(playerMoney>0)
         {
        	 System.out.println("You have $" + playerMoney+", how much would you like to bet?");
        	 double playerBet=userInput.nextDouble();
        	 if(playerBet>playerMoney)
        	 {
        		 System.out.println("You cannot bet more than you have"+" Please bet again within your Remaining Money");
        		 playerBet=userInput.nextDouble();
        		 if(playerBet>playerMoney)
        		 {
        			 System.out.println("You cannot bet more than you have");
        			 break;
        		 }
        			 
        	 }
        	 boolean endRound=false;
        	 playerDeck.draw(playingDeck);
        	 playerDeck.draw(playingDeck);
        	 dealerDeck.draw(playingDeck);dealerDeck.draw(playingDeck);
        	 while(true)
        	 {
        		 System.out.println("Your Hand:");
        		 System.out.println(playerDeck.toString());
        		 System.out.println("Your hand is Valued at :" +playerDeck.cardsValue());
        		 System.out.println("Dealer Hand :" +dealerDeck.getCard(0).toString() +"  and [Hidden]");
        		 
        		 System.out.println("would you like to (1)Hit or (2) stand?");
        		 int response=userInput.nextInt();
        		 if(response==1)
        		 {
        			 playerDeck.draw(playingDeck);
        			 System.out.println("You Draw a:" +playerDeck.getCard(playerDeck.deckSize()-1).toString());
        			 if(playerDeck.cardsValue()>21)
        			 {
        				 System.out.println("Bust ,currently value at :"+playerDeck.cardsValue());
        				 endRound=true;
        				 playerMoney-=playerBet;
        				 break;
        			 }
        		 }
        		 if(response==2)
        		 {
        			 break;
        		 }
        	 }
        	 System.out.println("Dealer Cards :" + dealerDeck.toString());
        	 if(dealerDeck.cardsValue() >playerDeck.cardsValue() && endRound==false)
        	 {
System.out.println("Dealer Beats You !");
playerMoney-=playerBet;
endRound=true;

        	 }
        	 while(dealerDeck.cardsValue()<17 && endRound==false)
        	 {
        		 dealerDeck.draw(playingDeck);
        		 System.out.println("Dealer draws:" +dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
        	 }
        	 System.out.println("Dealer's hand is valued at:" +dealerDeck.cardsValue());
        	 if(dealerDeck.cardsValue() >21 && endRound==false)
        	 {
        		 System.out.println("Dealer Bust, YOU WON!");
        		 playerMoney+=playerBet;
        		 endRound=true;
        	 }
        	 if(dealerDeck.cardsValue() == playerDeck.cardsValue() && endRound==false)
        	 {
        		 System.out.println("Push");
        		 //playerMoney+=playerBet;
        		 endRound=true;
        	 }
        	 if(playerDeck.cardsValue()>dealerDeck.cardsValue() && endRound==false)
        	 {
System.out.println("You Win the hand!");
playerMoney+=playerBet;
endRound=true;
        	 }
        	 else if(endRound==false)
        	 {
        		 System.out.println("You lose the hand!");
        		 playerMoney-=playerBet;
        		 endRound=true; 
        	 }
        	 playerDeck.moveAllToDeck(playingDeck);
        	 dealerDeck.moveAllToDeck(playingDeck);
        	 System.out.println("End of Round");
        	 
         }
         System.out.println("Game Over you are out of Money");
	}

}
