import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Tongits {

   static Scanner scanner = new Scanner (System.in);
   static Random random = new Random();
   
   static String [] cardDeck = {"Spade 1", "Spade 2", "Spade 3", "Spade 4", "Spade 5", "Spade 6", "Spade 7", "Spade 8", "Spade 9", "Spade 10", "Spade Jack", "Spade Queen", "Spade King",
                                "Clover 1", "Clover 2", "Clover 3", "Clover 4", "Clover 5", "Clover 6", "Clover 7", "Clover 8", "Clover 9", "Clover 10", "Clover Jack", "Clover Queen", "Clover King",
                                "Heart 1", "Heart 2", "Heart 3", "Heart 4", "Heart 5", "Heart 6", "Heart 7", "Heart 8", "Heart 9", "Heart 10", "Heart Jack", "Heart Queen", "Heart King",
                                "Diamond 1", "Diamond 2", "Diamond 3", "Diamond 4", "Diamond 5", "Diamond 6", "Diamond 7", "Diamond 8", "Diamond 9", "Diamond 10", "Diamond Jack", "Diamond Queen", "Diamond King"};
                                
   static String [] player1Deck = new String [13];
   static String [] player2Deck = new String [13];
   static String [] player3Deck = new String [13];
   
   static ArrayList<String> leftoverCards = new ArrayList<>();
   static ArrayList<String> cardsThrowned = new ArrayList<>();
   static ArrayList<String> meldedCardsSet = new ArrayList<>();
   
   static boolean firstPlayer13 = false, secondPlayer13 = false, thirdPlayer13 = false, meldedCardsExist = false, gameRunning = true;
   static boolean firstMove1 = false , firstMove2 = false, firstMove3 = false;
   static boolean player1Turn = true, player2Turn = true, player3Turn = true;
   static boolean validMelding1 = false, validMelding2 = false;
   static boolean player1Won = false, player2Won = false, player3Won = false;
   
   static String thrownCard, pickedCard;
   
   static int player1CardCount, player2CardCount, player3CardCount;
   static int meldingIndex = 0;
   
   public static void main (String [] args) {
   
      decision13Cards();
      cardDissemination();
      cardsToBePicked();
      
      while (gameRunning) {
      
         if (firstPlayer13) {
            
            if (!player1Won) {
            
               player1MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
            
            if (!player2Won) {   
            
               player2MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
            
            if (!player3Won) {
               
               player3MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
         }
         
         else if (secondPlayer13) {
            
            if (!player2Won) {
            
               player2MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
            
            if (!player3Won) {   
            
               player3MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
             
            if (!player1Won) {  
               player1MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
         }      
         
         else if (thirdPlayer13) {
            
            if (!player3Won) {
            
               player3MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
            
            if (!player1Won) {  
             
               player1MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
            
            if (!player2Won) {
               
               player2MoveSet();
               endGameChecker();
               
               if (endGameChecker()) {
               
                  gameRunning = false;
               }
            }
         }
      }
   }
   
   public static void cardDissemination() {
   
      String randomCard;
      boolean cardVoid = true;
             
      for (int i = 0 ; i < player1CardCount ; i++) {
             
         randomCard = cardDeck[random.nextInt(52)];      
            
         for (int j = 0 ; j < player1CardCount ; j++) {
               
            try {
                  
               if (player1Deck[j] != null && player1Deck[j].equals(randomCard) ||
                   player2Deck[j] != null && player2Deck[j].equals(randomCard) ||
                   player3Deck[j] != null && player3Deck[j].equals(randomCard)) {
                              
                  i--;
                  cardVoid = false;
                  break;
               }
            }
               
            catch (Exception e) {
            }
                        
         }
            
         if (cardVoid) {   
            
            player1Deck[i] = randomCard;
         }
            
         cardVoid = true;
               
      }
             
      for (int i = 0 ; i < player2CardCount ; i++) {
             
         randomCard = cardDeck[random.nextInt(52)];
               
         for (int j = 0 ; j < player2CardCount ; j++) {
                  
            try {
                  
               if (player1Deck[j] != null && player1Deck[j].equals(randomCard) ||
                   player2Deck[j] != null && player2Deck[j].equals(randomCard) ||
                   player3Deck[j] != null && player3Deck[j].equals(randomCard)) {
                              
                  i--;
                  cardVoid = false;
                  break;
               }
            }
               
            catch (Exception e) {
            }              
         }
            
         if (cardVoid) {      
            
            player2Deck[i] = randomCard;
         }
            
         cardVoid = true;
               
      }
             
      for (int i = 0 ; i < player3CardCount ; i++) {
             
         randomCard = cardDeck[random.nextInt(52)];
               
         for (int j = 0 ; j < player3CardCount ; j++) {
                  
            try {
                  
               if (player1Deck[j] != null && player1Deck[j].equals(randomCard) ||
                   player2Deck[j] != null && player2Deck[j].equals(randomCard) ||
                   player3Deck[j] != null && player3Deck[j].equals(randomCard)) {
                              
                  i--;
                  cardVoid = false;
                  break;
               }
            }
               
            catch (Exception e) {
            }              
         }
            
            
         if (cardVoid) {
                  
            player3Deck[i] = randomCard;
         }
            
         cardVoid = true;
               
      }
      
      
   }
   
   public static void decision13Cards() {
   
      int response = 4;
      
      while (response > 3 || response < 1 ) {
      
         printLine("Who will hold 13 cards?: ", 1);
         printLine("[1] Player 1 \n[2] Player 2 \n[3] Player 3 \n",2);
         printLine(">  ", 1);
         response = scanner.nextInt();
         
         if (response > 3 || response < 1) {
            printLine("Option not available! Please pick again.", 2);
         }
      }
      
      if (response == 1) {
      
         firstPlayer13 = true;
         firstMove1 = true;
      }
      
      else if (response == 2) {
      
         secondPlayer13 = true;
         firstMove2 = true;
      }
      
      else if (response == 3) {
      
         thirdPlayer13 = true;
         firstMove3 = true;
      }
      
      player1CardCount = (firstPlayer13) ? 13 : 12;
      player2CardCount = (secondPlayer13) ? 13 : 12;
      player3CardCount = (thirdPlayer13) ? 13 : 12;
   }
   
   public static void cardsToBePicked() {
      
      boolean ceaseDeck1, ceaseDeck2, ceaseDeck3;
      int i = 0, j = 0;
      
      while (i <= 51) {
         
         j = 0;
         ceaseDeck1 = true;
         ceaseDeck2 = true;
         ceaseDeck3 = true;
            
         while (j < 13) {
            
            if (j < player1Deck.length && player1Deck[j] != null && cardDeck[i].equals(player1Deck[j])) {
               ceaseDeck1 = false;   
            }
            
            
            if (j < player2Deck.length && player2Deck[j] != null && cardDeck[i].equals(player2Deck[j])) {
               ceaseDeck2 = false;   
            }
            
            if (j < player3Deck.length && player3Deck[j] != null && cardDeck[i].equals(player3Deck[j])) {
               ceaseDeck3 = false;   
            }
            
            j++;
         }
         
         if (ceaseDeck1 && ceaseDeck2 && ceaseDeck3) {
         
            leftoverCards.add(cardDeck[i]);
         }
         
         i++;
      }
   }
   
   public static void player1MoveSet() {
      
      player1Turn = true;
      
      int choice, choice2, choice3, cardToBeMelded, tempCardCount = 0;
      String stringMelded = "", key;
      String [] cardsMeldedArray, actingCardDeck;
      
      deckArranger(player1Deck);
      
      printLine("Player 1 Turn: ", 2);
      printLine("", 1);
      
      if (firstMove1) {
      
         cardDeckPrinter(player1Deck);
         
         printLine("Pick a card to throw: ", 2);
         choice = scanner.nextInt();
         
         thrownCard = player1Deck[choice-1];
         cardsThrowned.add(thrownCard);
         printLine("Player 1 have thrown " + thrownCard, 1);
         
         player1Deck[choice-1] = null;
         
         player1Deck = deckOrganizer(player1Deck);
         deckArranger(player1Deck);
         player1CardCount--; //temporary
        
         firstMove1 = false;
      }
      
      else {
         
         while (player1Turn) {
            
            if (!cardsThrowned.get(cardsThrowned.size()-1).equals(null)) {
            
               printLine("Latest thrown card: " + thrownCard, 1);
            }
            
            else {
            
               printLine("Latest thrown card: None", 1);
            }
            
            printLine("[1] Get card from the deck", 1);
            printLine("[2] Get latest card from the thrown cards", 0);
            printLine("[3] View Card Deck", 0);
            printLine(">  ", 1);
            choice2 = scanner.nextInt();
            
            if (choice2 == 1) {
            
               pickedCard = leftoverCards.get(leftoverCards.size()-1);
               printLine("Player 1 got the card " + pickedCard, 2);
               player1Deck[player1CardCount] = pickedCard;
               player1CardCount++; //temporary
               
               leftoverCards.remove(leftoverCards.size()-1);
                 
               player1Deck = deckOrganizer(player1Deck);
               deckArranger(player1Deck);               
               
               printLine("Player 1 Deck: ", 2);
               printLine("", 1);
                  
               cardDeckPrinter(player1Deck);
            }
            
            else if (choice2 == 2) {
               
               tempCardCount = player1CardCount;
               actingCardDeck = player1Deck.clone();
               stringMelded = "";
            
               thrownCard = cardsThrowned.get(cardsThrowned.size()-1);
               printLine("Player 1 got the card " + thrownCard, 2);
               player1Deck[player1CardCount] = thrownCard;
               
               player1Deck = deckOrganizer(player1Deck);
               deckArranger(player1Deck);
               player1CardCount++; //temporary
               
               printLine("Player 1 Deck: ", 2);
               printLine("", 1);
                  
               cardDeckPrinter(player1Deck);
               
               printLine("Since you decide to get the latest card, proceed to melding!", 2);
                           
               while (true) {
                              
                  cardDeckPrinter(player1Deck);
                     
                  printLine("Please pick the cards to be meld --", 2);
                  printLine("Please enter '0' to stop melding", 1);
                  printLine(">  ", 2);
                  cardToBeMelded = scanner.nextInt();
                              
                  if (cardToBeMelded == 0) {
                                 
                     break;
                  }
                              
                  stringMelded += player1Deck[cardToBeMelded-1] + "  ";
                  player1Deck[cardToBeMelded-1] = null;
                  player1CardCount--;
                  player1Deck = deckOrganizer(player1Deck);
                  deckArranger(player1Deck);
               }
                           
               cardsMeldedArray = stringMelded.split("  ");
               
               if (cardsMeldedArray.length > 2) {
               
                  meldingVerification(cardsMeldedArray);
                              
                  if (validMelding1 || validMelding2) {
                              
                     printLine("Player 1 melded: ", 2);
                     printLine(stringMelded, 0);
                     meldedCardsSet.add(stringMelded);
                     meldingIndex++;
                     cardsThrowned.remove(cardsThrowned.size()-1);
                                 
                     meldedCardsExist = true;
                  }
                              
                  else {
                              
                     printLine("Melded cards invalid", 2);
                     player1Deck = actingCardDeck;
                     player1CardCount = tempCardCount;
                           
                     player1Deck = deckOrganizer(player1Deck);
                     deckArranger(player1Deck);
                     continue;
                  }
                 
               }
               
               else {
               
                  printLine("Melded cards should be consists of 3 cards!", 2);
                  player1Deck = actingCardDeck;
                  player1CardCount = tempCardCount;
                           
                  player1Deck = deckOrganizer(player1Deck);
                  deckArranger(player1Deck);
                  continue;
               }  
   
            }
            
            else if (choice2 == 3) {
            
               cardDeckPrinter(player1Deck);
               printLine("Please enter any key to proceed: ", 2);
               key = scanner.next();
               continue;
            }
            
            while (true) {
               
               validMelding1 = false;
               validMelding2 = false;
            
               printLine("What would you like to do? : ", 1);
               printLine("[1] Throw a chard", 1);
               printLine("[2] Meld a set of cards", 0);
               printLine("[3] Add another card to the melded set of cards", 0);
               printLine(">  ", 0);
               choice2 = scanner.nextInt();
                     
               switch (choice2) {
                     
                  case 1:
                        
                     cardDeckPrinter(player1Deck);
                           
                     printLine("Pick a card to throw: ", 2);
                     choice = scanner.nextInt();
                           
                     thrownCard = player1Deck[choice-1];
                     cardsThrowned.add(thrownCard);
                           
                     player1Deck[choice-1] = null;
                           
                     printLine("Player 1 has thrown " + thrownCard, 2);
                           
                     player1Deck = deckOrganizer(player1Deck);
                     deckArranger(player1Deck);
                     player1CardCount--; //temporary
                           
                     player1Turn = false;
                                    
                     break;
                        
                  case 2:
                     
                     tempCardCount = player1CardCount;
                     actingCardDeck = player1Deck.clone();
                     stringMelded = "";
                           
                     while (true) {
                              
                        cardDeckPrinter(player1Deck);
                     
                        printLine("Please pick the cards to be meld --", 2);
                        printLine("Please enter '0' to stop melding", 1);
                        printLine(">  ", 2);
                        cardToBeMelded = scanner.nextInt();
                              
                        if (cardToBeMelded == 0) {
                                 
                           break;
                        }
                              
                        stringMelded += player1Deck[cardToBeMelded-1] + "  ";
                        player1Deck[cardToBeMelded-1] = null;
                        player1CardCount--;
                        player1Deck = deckOrganizer(player1Deck);
                        deckArranger(player1Deck);
                     }
                           
                     cardsMeldedArray = stringMelded.split("  ");
                     
                     if (cardsMeldedArray.length > 2) {
                     
                        meldingVerification(cardsMeldedArray);
                              
                        if (validMelding1 || validMelding2) {
                              
                           printLine("Player 1 melded: ", 2);
                           printLine(stringMelded, 0);
                           meldedCardsSet.add(stringMelded);
                           meldingIndex++;
                                 
                           meldedCardsExist = true;
                           continue;
                        }
                              
                        else {
                              
                           printLine("Melded cards invalid", 2);
                           player1Deck = actingCardDeck;
                           player1CardCount = tempCardCount;
                           
                           player1Deck = deckOrganizer(player1Deck);
                           deckArranger(player1Deck);
                           continue;
                        }
                     }
                     
                     else {
                     
                        printLine("Melded cards should be consists of 3 cards!", 2);
                        player1Deck = actingCardDeck;
                        player1CardCount = tempCardCount;
                                 
                        player1Deck = deckOrganizer(player1Deck);
                        deckArranger(player1Deck);
                        continue;   
                     }
                        
                  case 3:
                        
                     actingCardDeck = player1Deck.clone();
                     tempCardCount = player1CardCount;
                           
                     if (meldedCardsExist) {
                        stringMelded = "";
                              
                        int i = 1;
                        for (String meldedCards : meldedCardsSet) {
                              
                           printLine("[" + i + "] " + meldedCards, 0);
                           i++;
                        }
                              
                        printLine("Please choose a set of melded cards: ", 1);
                        printLine(">  ", 2);
                        choice3 = scanner.nextInt();
                              
                        printLine("Player 1 chose the melded cards set: " + meldedCardsSet.get(choice3-1), 2);
                              
                              
                        while (true) {
                              
                           cardDeckPrinter(player1Deck);
                                 
                           printLine("Please choose a card you would like to add to the set: ", 1);
                           printLine("Please enter '0' to stop adding cards", 1);
                           printLine(">  ", 2);
                           cardToBeMelded = scanner.nextInt();
                                  
                           if (cardToBeMelded == 0) {
                                 
                              break;
                           }
                                 
                           stringMelded += player1Deck[cardToBeMelded-1] + "  ";
                           player1Deck[cardToBeMelded-1] = null;
                           player1CardCount--;
                           player1Deck = deckOrganizer(player1Deck);
                           deckArranger(player1Deck);
                                 
                        }
                              
                        stringMelded += meldedCardsSet.get((choice3)-1);
                        cardsMeldedArray = stringMelded.split("  ");
                        meldingVerification(cardsMeldedArray);
                              
                        if (validMelding1 || validMelding2) {
                           
                           printLine("Player 1 added a cards and melded: ", 2);
                           printLine(stringMelded, 0);
                           meldedCardsSet.add(stringMelded);
                           
                           continue;
                        }
                           
                        else {
                              
                           printLine("Cards added to the melded cards is invalid", 2);
                           player1Deck = actingCardDeck;
                           player1CardCount = tempCardCount;
                           continue;
                        }
                     
                     }
                           
                     else {
                        printLine("There are no melded cards yet!", 1);
                        continue;
                     }
                           
               }
               
               break;
            }
         }
      }
   }

   public static void player2MoveSet() {
      
      player2Turn = true;
      
      int choice, choice2, choice3, cardToBeMelded, tempCardCount = 0;
      String stringMelded = "", key;
      String [] cardsMeldedArray, actingCardDeck;
      
      deckArranger(player2Deck);
      
      printLine("Player 2 Turn: ", 2);
      printLine("", 1);
      
      if (firstMove2) {
      
         cardDeckPrinter(player2Deck);
         
         printLine("Pick a card to throw: ", 2);
         choice = scanner.nextInt();
         
         thrownCard = player2Deck[choice-1];
         cardsThrowned.add(thrownCard);
         printLine("Player 2 have thrown " + thrownCard, 1);
         
         player2Deck[choice-1] = null;
         
         player2Deck = deckOrganizer(player2Deck);
         deckArranger(player2Deck);
         player2CardCount--; //temporary
        
         firstMove1 = false;
      }
      
      else {
         
         while (player2Turn) {
         
            if (!cardsThrowned.get(cardsThrowned.size()-1).equals(null)) {
            
               printLine("Latest thrown card: " + thrownCard, 1);
            }
            
            else {
            
               printLine("Latest thrown card: None", 1);
            }

            
            printLine("[1] Get card from the deck", 1);
            printLine("[2] Get latest card from the thrown cards", 0);
            printLine("[3] View Card Deck", 0);
            printLine(">  ", 1);
            choice2 = scanner.nextInt();
            
            if (choice2 == 1) {
            
               pickedCard = leftoverCards.get(leftoverCards.size()-1);
               printLine("Player 2 got the card " + pickedCard, 2);
               player2Deck[player2CardCount] = pickedCard;
               player2CardCount++; //temporary
               
               leftoverCards.remove(leftoverCards.size()-1);
                 
               player2Deck = deckOrganizer(player2Deck);
               deckArranger(player2Deck);               
               
               printLine("Player 2 Deck: ", 2);
               printLine("", 1);
                  
               cardDeckPrinter(player2Deck);
            }
            
            else if (choice2 == 2) {
               
               tempCardCount = player2CardCount;
               actingCardDeck = player2Deck.clone();
               stringMelded = "";
               
               thrownCard = cardsThrowned.get(cardsThrowned.size()-1);
               printLine("Player 2 got the card " + thrownCard, 2);
               player2Deck[player2CardCount] = thrownCard;
               
               player2Deck = deckOrganizer(player2Deck);
               deckArranger(player2Deck);
               player2CardCount++; //temporary
               
               printLine("Player 2 Deck: ", 2);
               printLine("", 1);
                  
               cardDeckPrinter(player2Deck);
               
               printLine("Since you decide to get the latest card, proceed to melding!", 2);
                           
               while (true) {
                              
                  cardDeckPrinter(player2Deck);
                     
                  printLine("Please pick the cards to be meld --", 2);
                  printLine("Please enter '0' to stop melding", 1);
                  printLine(">  ", 2);
                  cardToBeMelded = scanner.nextInt();
                              
                  if (cardToBeMelded == 0) {
                                 
                     break;
                  }
                              
                  stringMelded += player2Deck[cardToBeMelded-1] + "  ";
                  player2Deck[cardToBeMelded-1] = null;
                  player2CardCount--;
                  player2Deck = deckOrganizer(player2Deck);
                  deckArranger(player2Deck);
               }
                           
               cardsMeldedArray = stringMelded.split("  ");
               
               if (cardsMeldedArray.length > 2) {
               
                  meldingVerification(cardsMeldedArray);
                              
                  if (validMelding1 || validMelding2) {
                              
                     printLine("Player 2 melded: ", 2);
                     printLine(stringMelded, 0);
                     meldedCardsSet.add(stringMelded);
                     meldingIndex++;
                     cardsThrowned.remove(cardsThrowned.size()-1);
                                 
                     meldedCardsExist = true;
                  }
                              
                  else {
                              
                     printLine("Melded cards invalid", 2);
                     player2Deck = actingCardDeck;
                     player2CardCount = tempCardCount;
                           
                     player2Deck = deckOrganizer(player2Deck);
                     deckArranger(player2Deck);
                     continue;
                  }
                  
               }
               
               else {
               
                  printLine("Melded cards should be consists of 3 cards!", 2);
                  player2Deck = actingCardDeck;
                  player2CardCount = tempCardCount;
                           
                  player2Deck = deckOrganizer(player2Deck);
                  deckArranger(player2Deck);
                  continue;
               }

            }
            
            else if (choice2 == 3) {
            
               cardDeckPrinter(player2Deck);
               printLine("Please enter any key to proceed: ", 2);
               key = scanner.next();
               continue;
            }
            
            while (true) {
               
               validMelding1 = false;
               validMelding2 = false;
            
               printLine("What would you like to do? : ", 1);
               printLine("[1] Throw a chard", 1);
               printLine("[2] Meld a set of cards", 0);
               printLine("[3] Add another card to the melded set of cards", 0);
               printLine(">  ", 0);
               choice2 = scanner.nextInt();
                     
               switch (choice2) {
                     
                  case 1:
                        
                     cardDeckPrinter(player2Deck);
                           
                     printLine("Pick a card to throw: ", 2);
                     choice = scanner.nextInt();
                           
                     thrownCard = player2Deck[choice-1];
                     cardsThrowned.add(thrownCard);
                           
                     player2Deck[choice-1] = null;
                           
                     printLine("Player 2 has thrown " + thrownCard, 2);
                           
                     player2Deck = deckOrganizer(player2Deck);
                     deckArranger(player2Deck);
                     player2CardCount--; //temporary
                           
                     player2Turn = false;
                                    
                     break;
                        
                  case 2:
                     
                     tempCardCount = player2CardCount;
                     actingCardDeck = player2Deck.clone();
                     stringMelded = "";
                           
                     while (true) {
                              
                        cardDeckPrinter(player2Deck);
                     
                        printLine("Please pick the cards to be meld --", 2);
                        printLine("Please enter '0' to stop melding", 1);
                        printLine(">  ", 2);
                        cardToBeMelded = scanner.nextInt();
                              
                        if (cardToBeMelded == 0) {
                                 
                           break;
                        }
                              
                        stringMelded += player2Deck[cardToBeMelded-1] + "  ";
                        player2Deck[cardToBeMelded-1] = null;
                        player2CardCount--;
                        player2Deck = deckOrganizer(player2Deck);
                        deckArranger(player2Deck);
                     }
                           
                     cardsMeldedArray = stringMelded.split("  ");
                     
                     if (cardsMeldedArray.length > 2) {
                     
                        meldingVerification(cardsMeldedArray);
                              
                        if (validMelding1 || validMelding2) {
                              
                           printLine("Player 2 melded: ", 2);
                           printLine(stringMelded, 0);
                           meldedCardsSet.add(stringMelded);
                           meldingIndex++;
                                 
                           meldedCardsExist = true;
                           continue;
                        }
                              
                        else {
                              
                           printLine("Melded cards invalid", 2);
                           player2Deck = actingCardDeck;
                           player2CardCount = tempCardCount;
                           
                           player2Deck = deckOrganizer(player2Deck);
                           deckArranger(player2Deck);
                           continue;
                        }
                       
                     }
                     
                     else {
                     
                        printLine("Melded cards should be consists of 3 cards!", 2);
                        player2Deck = actingCardDeck;
                        player2CardCount = tempCardCount;
                                 
                        player2Deck = deckOrganizer(player2Deck);
                        deckArranger(player2Deck);
                        continue;
                     }
                        
                  case 3:
                        
                     actingCardDeck = player2Deck.clone();
                     tempCardCount = player2CardCount;
                           
                     if (meldedCardsExist) {
                        stringMelded = "";
                              
                        int i = 1;
                        for (String meldedCards : meldedCardsSet) {
                              
                           printLine("[" + i + "] " + meldedCards, 0);
                           i++;
                        }
                              
                        printLine("Please choose a set of melded cards: ", 1);
                        printLine(">  ", 2);
                        choice3 = scanner.nextInt();
                              
                        printLine("Player 2 chose the melded cards set: " + meldedCardsSet.get(choice3-1), 2);
                              
                              
                        while (true) {
                              
                           cardDeckPrinter(player2Deck);
                                 
                           printLine("Please choose a card you would like to add to the set: ", 1);
                           printLine("Please enter '0' to stop adding cards", 1);
                           printLine(">  ", 2);
                           cardToBeMelded = scanner.nextInt();
                                  
                           if (cardToBeMelded == 0) {
                                 
                              break;
                           }
                                 
                           stringMelded += player2Deck[cardToBeMelded-1] + "  ";
                           player2Deck[cardToBeMelded-1] = null;
                           player2CardCount--;
                           player2Deck = deckOrganizer(player2Deck);
                           deckArranger(player2Deck);
                                 
                        }
                              
                        stringMelded += meldedCardsSet.get((choice3)-1);
                        cardsMeldedArray = stringMelded.split("  ");
                        meldingVerification(cardsMeldedArray);
                              
                        if (validMelding1 || validMelding2) {
                           
                           printLine("Player 2 added a cards and melded: ", 2);
                           printLine(stringMelded, 0);
                           meldedCardsSet.add(stringMelded);
                           
                           continue;
                        }
                           
                        else {
                              
                           printLine("Cards added to the melded cards is invalid", 2);
                           player2Deck = actingCardDeck;
                           player2CardCount = tempCardCount;
                           continue;
                        }
                     
                     }
                           
                     else {
                        printLine("There are no melded cards yet!", 1);
                        continue;
                     }
                           
               }
               
               break;
            }
         }
      }
   }

   public static void player3MoveSet() {
      
      player3Turn = true;
      
      int choice, choice2, choice3, cardToBeMelded, tempCardCount = 0;
      String stringMelded = "", key;
      String [] cardsMeldedArray, actingCardDeck;
      
      deckArranger(player3Deck);
      
      printLine("Player 3 Turn: ", 2);
      printLine("", 1);
      
      if (firstMove3) {
      
         cardDeckPrinter(player3Deck);
         
         printLine("Pick a card to throw: ", 2);
         choice = scanner.nextInt();
         
         thrownCard = player3Deck[choice-1];
         cardsThrowned.add(thrownCard);
         printLine("Player 3 have thrown " + thrownCard, 1);
         
         player3Deck[choice-1] = null;
         
         player3Deck = deckOrganizer(player3Deck);
         deckArranger(player3Deck);
         player3CardCount--; //temporary
        
         firstMove1 = false;
      }
      
      else {
         
         while (player3Turn) {
            
            if (!cardsThrowned.get(cardsThrowned.size()-1).equals(null)) {
            
               printLine("Latest thrown card: " + thrownCard, 1);
            }
            
            else {
            
               printLine("Latest thrown card: None", 1);
            }
            
            printLine("[1] Get card from the deck", 1);
            printLine("[2] Get latest card from the thrown cards", 0);
            printLine("[3] View Card Deck", 0);
            printLine(">  ", 1);
            choice2 = scanner.nextInt();
            
            if (choice2 == 1) {
            
               pickedCard = leftoverCards.get(leftoverCards.size()-1);
               printLine("Player 3 got the card " + pickedCard, 2);
               player3Deck[player3CardCount] = pickedCard;
               player3CardCount++; //temporary
               
               leftoverCards.remove(leftoverCards.size()-1);
                 
               player3Deck = deckOrganizer(player3Deck);
               deckArranger(player3Deck);               
               
               printLine("Player 3 Deck: ", 2);
               printLine("", 1);
                  
               cardDeckPrinter(player3Deck);
            }
            
            else if (choice2 == 2) {
            
               tempCardCount = player3CardCount;
               actingCardDeck = player3Deck.clone();
               stringMelded = "";
            
               thrownCard = cardsThrowned.get(cardsThrowned.size()-1);
               printLine("Player 3 got the card " + thrownCard, 2);
               player3Deck[player3CardCount] = thrownCard;
               
               player3Deck = deckOrganizer(player3Deck);
               deckArranger(player3Deck);
               player3CardCount++; //temporary
               
               printLine("Player 3 Deck: ", 2);
               printLine("", 1);
                  
               cardDeckPrinter(player3Deck);
               
               printLine("Since you decide to get the latest card, proceed to melding!", 2);
                           
               while (true) {
                              
                  cardDeckPrinter(player3Deck);
                     
                  printLine("Please pick the cards to be meld --", 2);
                  printLine("Please enter '0' to stop melding", 1);
                  printLine(">  ", 2);
                  cardToBeMelded = scanner.nextInt();
                              
                  if (cardToBeMelded == 0) {
                                 
                     break;
                  }
                              
                  stringMelded += player3Deck[cardToBeMelded-1] + "  ";
                  player3Deck[cardToBeMelded-1] = null;
                  player3CardCount--;
                  player3Deck = deckOrganizer(player3Deck);
                  deckArranger(player3Deck);
               }
                           
               cardsMeldedArray = stringMelded.split("  ");
               
               if (cardsMeldedArray.length > 2) {
               
                  meldingVerification(cardsMeldedArray);
                              
                  if (validMelding1 || validMelding2) {
                              
                     printLine("Player 3 melded: ", 2);
                     printLine(stringMelded, 0);
                     meldedCardsSet.add(stringMelded);
                     meldingIndex++;
                     cardsThrowned.remove(cardsThrowned.size()-1);
                                 
                     meldedCardsExist = true;
                  }
                              
                  else {
                              
                     printLine("Melded cards invalid", 2);
                     player3Deck = actingCardDeck;
                     player3CardCount = tempCardCount;
                           
                     player3Deck = deckOrganizer(player3Deck);
                     deckArranger(player3Deck);
                     continue;
                  }
   
               }
               
               else {
               
                  printLine("Melded cards should be consists of 3 cards!", 2);
                  player3Deck = actingCardDeck;
                  player3CardCount = tempCardCount;
                           
                  player3Deck = deckOrganizer(player3Deck);
                  deckArranger(player3Deck);
                  continue;
               }
            }
            
            else if (choice2 == 3) {
            
               cardDeckPrinter(player3Deck);
               printLine("Please enter any key to proceed: ", 2);
               key = scanner.next();
               continue;
            }
            
            while (true) {
               
               validMelding1 = false;
               validMelding2 = false;
            
               printLine("What would you like to do? : ", 1);
               printLine("[1] Throw a chard", 1);
               printLine("[2] Meld a set of cards", 0);
               printLine("[3] Add another card to the melded set of cards", 0);
               printLine(">  ", 0);
               choice2 = scanner.nextInt();
                     
               switch (choice2) {
                     
                  case 1:
                        
                     cardDeckPrinter(player3Deck);
                           
                     printLine("Pick a card to throw: ", 2);
                     choice = scanner.nextInt();
                           
                     thrownCard = player3Deck[choice-1];
                     cardsThrowned.add(thrownCard);
                           
                     player3Deck[choice-1] = null;
                           
                     printLine("Player 3 has thrown " + thrownCard, 2);
                           
                     player3Deck = deckOrganizer(player3Deck);
                     deckArranger(player3Deck);
                     player3CardCount--; //temporary
                           
                     player3Turn = false;
                                    
                     break;
                        
                  case 2:
                     
                     tempCardCount = player3CardCount;
                     actingCardDeck = player3Deck.clone();
                     stringMelded = "";
                           
                     while (true) {
                              
                        cardDeckPrinter(player3Deck);
                     
                        printLine("Please pick the cards to be meld --", 2);
                        printLine("Please enter '0' to stop melding", 1);
                        printLine(">  ", 2);
                        cardToBeMelded = scanner.nextInt();
                              
                        if (cardToBeMelded == 0) {
                                 
                           break;
                        }
                              
                        stringMelded += player3Deck[cardToBeMelded-1] + "  ";
                        player3Deck[cardToBeMelded-1] = null;
                        player3CardCount--;
                        player3Deck = deckOrganizer(player3Deck);
                        deckArranger(player3Deck);
                     }
                           
                     cardsMeldedArray = stringMelded.split("  ");
                     
                     if (cardsMeldedArray.length > 2) {
                     
                        meldingVerification(cardsMeldedArray);
                              
                        if (validMelding1 || validMelding2) {
                              
                           printLine("Player 3 melded: ", 2);
                           printLine(stringMelded, 0);
                           meldedCardsSet.add(stringMelded);
                           meldingIndex++;
                                 
                           meldedCardsExist = true;
                           continue;
                        }
                              
                        else {
                              
                           printLine("Melded cards invalid", 2);
                           player3Deck = actingCardDeck;
                           player3CardCount = tempCardCount;
                           
                           player3Deck = deckOrganizer(player3Deck);
                           deckArranger(player3Deck);
                           continue;
                        }
                     }
                     
                     else {
                     
                        printLine("Melded cards should be consists of 3 cards!", 2);
                        player3Deck = actingCardDeck;
                        player3CardCount = tempCardCount;
                                 
                        player3Deck = deckOrganizer(player3Deck);
                        deckArranger(player3Deck);
                        continue;
                     }
                        
                  case 3:
                        
                     actingCardDeck = player3Deck.clone();
                     tempCardCount = player3CardCount;
                           
                     if (meldedCardsExist) {
                        stringMelded = "";
                              
                        int i = 1;
                        for (String meldedCards : meldedCardsSet) {
                              
                           printLine("[" + i + "] " + meldedCards, 0);
                           i++;
                        }
                              
                        printLine("Please choose a set of melded cards: ", 1);
                        printLine(">  ", 2);
                        choice3 = scanner.nextInt();
                              
                        printLine("Player 3 chose the melded cards set: " + meldedCardsSet.get(choice3-1), 2);
                              
                              
                        while (true) {
                              
                           cardDeckPrinter(player3Deck);
                                 
                           printLine("Please choose a card you would like to add to the set: ", 1);
                           printLine("Please enter '0' to stop adding cards", 1);
                           printLine(">  ", 2);
                           cardToBeMelded = scanner.nextInt();
                                  
                           if (cardToBeMelded == 0) {
                                 
                              break;
                           }
                                 
                           stringMelded += player3Deck[cardToBeMelded-1] + "  ";
                           player3Deck[cardToBeMelded-1] = null;
                           player3CardCount--;
                           player3Deck = deckOrganizer(player3Deck);
                           deckArranger(player3Deck);
                                 
                        }
                              
                        stringMelded += meldedCardsSet.get((choice3)-1);
                        cardsMeldedArray = stringMelded.split("  ");
                        meldingVerification(cardsMeldedArray);
                              
                        if (validMelding1 || validMelding2) {
                           
                           printLine("Player 3 added a cards and melded: ", 2);
                           printLine(stringMelded, 0);
                           meldedCardsSet.add(stringMelded);
                           
                           continue;
                        }
                           
                        else {
                              
                           printLine("Cards added to the melded cards is invalid", 2);
                           player3Deck = actingCardDeck;
                           player3CardCount = tempCardCount;
                           continue;
                        }
                     
                     }
                           
                     else {
                        printLine("There are no melded cards yet!", 1);
                        continue;
                     }
                           
               }
               
               break;
            }
         }
      }
   }
   
   public static void meldingVerification(String [] meldedCards) {
   
      boolean sameSymbol = false, ascendingRank = false;
      
      // checks to see if melded cards have the same rank
      for (int i = 0 ; i < meldedCards.length ; i++) {
      
         for (int j = 0 ; j < meldedCards.length ; j++) {
         
            if ( j == i) {
            
               continue;
            }
            
            if (meldedCards[i].charAt(meldedCards[i].length()-1) == meldedCards[j].charAt(meldedCards[j].length()-1)) {
            
               validMelding1 = true;
            }
            
            else {
            
               validMelding1 = false;
               break;
            }
         }
      }
      
      // checks to see if melded cards have the same symbol and ascending rank by 1
      
      ArrayList<String> cardsMelded = new ArrayList<>();
      ArrayList<Integer> cardsNumbers = new ArrayList<>();
      
      for (String cards : meldedCards) {
      
         String [] words = cards.split(" ");
         
         for (String word : words) {
         
            cardsMelded.add(word);
         }
      }
      
      // checks if melded cards have same symbol
      for (int i = 0 ; i < cardsMelded.size() ; i+=2) {
      
         for (int j = 0 ; j < cardsMelded.size() ; j+=2) {
         
            if (i == j) {
            
               continue;
            }
         
            if (cardsMelded.get(i).equals(cardsMelded.get(j))) {
            
               sameSymbol = true;
            }
            
            else {
            
               sameSymbol = false;
            }
         }
      }
      
      // checks if melded cards have ascending number
      
      for (int i = 1 ; i < cardsMelded.size() ; i+=2) {
         
         if (cardsMelded.get(i).equals("Jack")) {
         
            cardsNumbers.add(11);
         }
         
         else if (cardsMelded.get(i).equals("Queen")) {
         
            cardsNumbers.add(12);
         }
         
         else if (cardsMelded.get(i).equals("King")) {
         
            cardsNumbers.add(13);
         }
         
         else {
         
            cardsNumbers.add(Integer.parseInt(cardsMelded.get(i)));
         }
      }
      
      Collections.sort(cardsNumbers);
      
      for (int i = 0 ; i < cardsNumbers.size()-1 ; i++) {
      
         if ((cardsNumbers.get(i+1) - cardsNumbers.get(i)) == 1) {
         
            ascendingRank = true;
         }
         
         else {
         
            ascendingRank = false;
         }
      }
      
      if (sameSymbol && ascendingRank) {
      
         validMelding2 = true;
      }
      
      else {
      
         validMelding2 = false;
      }
   
   }
   
   public static boolean endGameChecker() {
   
      if (leftoverCards.get(0) == null) {
      
         printLine("There's no Left Over Cards anymore!!!", 2);
         totalPointsPlayers();
         return true;
      }
      
      if (player1Deck[0] == null) {
         
         player1Won = true;
         printLine("Player 1 Won!!!", 2);
      }
      
      else if (player2Deck[0] == null) {
         
         player2Won = true;
         printLine("Player 2 Won!!!", 2);
      }
      
      else if (player3Deck[0] == null) {
         
         player3Won = true;
         printLine("Player 3 Won!!!", 2);
      }
      
      if (player1Won && player2Won) {
         
         printLine("Player 3 Lose!!!", 2);
         return true;
      }
      
      else if (player1Won && player3Won) {
         
         printLine("Player 2 Lose!!!", 2);
         return true;
      }
      
      else if (player2Won && player3Won) {
         
         printLine("Player 1 Lose!!!", 2);
         return true;
      }
   
      return false;
   }
   
   public static void totalPointsPlayers () {
   
      int player1Points = 0, player2Points = 0, player3Points = 0, spaceIndex;
      String cardRank;
      
      for (int i = 0 ; i < player1Deck.length ; i++) {
      
         if (player1Deck[i] != null) {
         
            spaceIndex = player1Deck[i].indexOf(' ');
            cardRank = player1Deck[i].substring(spaceIndex + 1);
            
            player1Points += rankBoolean(cardRank);
         }
      } 
      
      for (int i = 0 ; i < player2Deck.length ; i++) {
      
         if (player2Deck[i] != null) {
         
            spaceIndex = player2Deck[i].indexOf(' ');
            cardRank = player2Deck[i].substring(spaceIndex + 1);
            
            player2Points += rankBoolean(cardRank);
         }
      } 
      
      for (int i = 0 ; i < player3Deck.length ; i++) {
      
         if (player3Deck[i] != null) {
         
            spaceIndex = player3Deck[i].indexOf(' ');
            cardRank = player3Deck[i].substring(spaceIndex + 1);
            
            player3Points += rankBoolean(cardRank);
         }
      } 
      
      printLine("Player 1 points: " + player1Points, 2);
      printLine("Player 2 points: " + player1Points, 0);
      printLine("Player 3 points: " + player1Points, 0);
      
      if (player1Points > player3Points && player2Points > player3Points) {
      
         printLine("Player 3 Lose!!!", 2);
      }
      
      else if (player2Points > player1Points && player3Points > player1Points) {
      
         printLine("Player 1 Lose!!!", 2);
      }
      
      else if (player1Points > player2Points && player3Points > player2Points) {
      
         printLine("Player 2 Lose!!!", 2);
      }
   }
   
   public static String [] deckOrganizer(String [] cardDeck) {
      
      int index = 0;
      
      String [] tempCardDeck = new String [13];
      
      for (int i = 0 ; i < cardDeck.length ; i++) {
      
         if (cardDeck[i] != null) {
         
            tempCardDeck[index] = cardDeck[i];
            index++;
         }
      }
      
      return tempCardDeck;
   } 
   
   public static void deckArranger (String [] cardDeck) {
     
      int spaceIndex1 = 0, spaceIndex2 = 0;
      String temp;
   
      for (int i = 1 ; i < cardDeck.length ; i++) {
      
         for (int j = i ; j > 0 ; j--) {
            
            if (cardDeck[j] != null && cardDeck[j-1] != null) {
            
               spaceIndex1 = cardDeck[j].indexOf(' ');
               spaceIndex2 = cardDeck[j-1].indexOf(' ');
               
               String rank1 = cardDeck[j].substring(spaceIndex1 + 1);
               String rank2 = cardDeck[j-1].substring(spaceIndex2 + 1);
            
               if (rankBoolean(rank1) < rankBoolean(rank2)) {
               
                  temp = cardDeck[j];
                  cardDeck[j] = cardDeck[j-1];
                  cardDeck[j-1] = temp;
               }
            }
         }
      } 
   }
   
   public static void cardDeckPrinter (String [] cardDeck) {
   
      for (int i = 0 ; i < cardDeck.length ; i++) {
                           
         if (cardDeck[i] != null) {
         
            printLine("[" + (i+1) + "] " + cardDeck[i], 0);
         }
      }   
   }
   
   public static void printLine(String text, int line) {
   
      for (int i = 0 ; i <= line ; i++) {
         System.out.println();
      }
      
      System.out.print(text);
   }
   
   public static int rankBoolean (String rank) {
      
      switch (rank) {
         
         case "1":
            return 1;
         case "2":
            return 2;
         case "3":
            return 3;
         case "4":
            return 4;
         case "5":
            return 5;
         case "6":
            return 6;
         case "7":
            return 7;
         case "8":
            return 8;
         case "9":
            return 9;
         case "10":
            return 10;
         case "Jack":
            return 11;
         case "Queen":
            return 12;
         case "King":
            return 13;
      }
      
      return 0;
   }
   
}