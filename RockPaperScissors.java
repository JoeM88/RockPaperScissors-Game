/* Title: RockPaperScissors.java
Description: Java program to simulate a rock paper and scissors game.
Author: Joseph Molina
Date 3/23/16
*/
import java.util.*;
import java.applet.*;
import java.net.*;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class RockPaperScissors extends player{

  public static String p1Name = "";
  public static String p2Name = "";

  //Method to display the welcome message
  public static void opening()
  {
    String text = "Are you ready to play?";
    System.out.println("======= Welcome to the ultimate Rock Paper and Scissors Match! ========");
    int iterator;
    //For loop that will display each character of the text along with the sound of a typewriter.
    for(int i = 0;i < text.length();i++){
      playTypeWriter();
      System.out.printf("%c", text.charAt(i));
      try{
        Thread.sleep(3); //0.1 second pause between characters/
      }catch(Exception e){
        Thread.currentThread().interrupt();
      }
    }
    System.out.println("");
  }

  //Method to play the type writing sound effect
  public static void playTypeWriter()
  {
    try{
      //Opening the audio file.
      File file = new File("keyboardstroke.wav");
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(file));
      clip.start(); //Playing the clip.
      Thread.sleep(clip.getMicrosecondLength()/1000);

    }catch(Exception e){
      System.out.println("File does not exist!");
    }
  }

//Method to obtain the necessary information of the player
  public static player getPlayer(){
    Scanner input = new Scanner(System.in);
    String name = "", hometown = "";
    int score = 0;
    boolean checker = false,checker2 = false;

    while(checker!= true){
      //Try and catch to valdiate the name of the user.
      try{
        System.out.print("Enter player name:");
        name = input.nextLine();
          checker = true;
      }catch(Exception e){
        input.nextLine();
        System.out.println("Please enter a valid name.");
      }
    }

    //Second while loop and try and catch to validate the hometown.
    while(checker2!= true){
      try{
        System.out.print(name +" enter your hometown:");
        hometown = input.nextLine();
        checker2 = true;
      }catch(Exception e){
        input.nextLine();
        System.out.println("Please enter a valid hometown.");
      }
    }
    //Creating a temporary player object with the overloaded constructor
    //and then returning it to the main.
    player temp = new player (name,hometown,score);
    return temp;
  }
//Method to display the a funny play game message before the match begins.
  public static void setMatchUp(player p1, player p2){
    System.out.println("========================================="+ "\n" +"This match is set for 3 brutal rounds." + "\n" +
    "I want no foul or dirty plays, protect yourself at all times." + "\n" +
    p1.getName() + " are you ready? " + "\n"
    + p2.getName() + " are you ready?" + "\n"+
    "Let's get it on!");
    System.out.println("");
  }

//Method to play the bell before the match begins.
  public static void playBell()
  {
    try{
      //Opening the sound file.
      File file = new File("bellSound.wav");
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(file));
      clip.start(); //Playing the clip.
      Thread.sleep(clip.getMicrosecondLength()/1000);

    }catch(Exception e){
      System.out.println("File does not exist!");
    }
  }
//Method to prompt the user for either rock,paper or scissors.
//The method will take in a player object and record his or her option.
 public static void pickWeapon (player p){
  // System.out.print("\033[H\033[2J");
   //System.out.flush();
    int choice = 0;

    Scanner keyboard = new Scanner(System.in);
    boolean correctChoice = false;
while(!correctChoice){
  try{
    if(p.getName().equals(p1Name)){
      System.out.println(p1Name + " select your option.");
    }
    else if(p.getName().equals(p2Name)){
      System.out.println(p2Name + " select your option.");
    }
    //System.out.println("Select your option.");
    //Do while loop for the user selecting their choice.
    do{
      System.out.println("Enter 1. for Rock" + "\n"
      + "Enter 2. for Paper" + "\n" + "Enter 3. for Scissors");
      choice = keyboard.nextInt();
      switch(choice){
        case 1 :
                p.setChoice(1);
                correctChoice = true;
            break;

        case 2:
                p.setChoice(2);
                correctChoice = true;
            break;

        case 3:
              p.setChoice(3);
              correctChoice = true;
            break;
        default:{
          System.out.println("Invalid choice option!");
        }
      }
    }while(choice == 0 && correctChoice!= true); //End of do loop
    //Clearing the terminal screen.
  //  System.out.print("\033[H\033[2J");
    //System.out.flush();
  }catch(Exception e){
    keyboard.nextLine();
    System.out.println("Invalid choice option!");
  }
 }
}

  public static void logic(player p1, player p2){
//Both players pick rock.
    if(p1.getChoice() == 1 && p2.getChoice() == 1){
      System.out.println("Both players picked rock!" + "\n" + "Tie");
    }
//Player 1 picks rock and player2 picks paper
    else if(p1.getChoice() == 1 && p2.getChoice() == 2){
      System.out.println("Player 2 wins!" + "\n" + "Paper beats Rock! " + "\n");
      p2.setScore(p2.getScore() + 1);
    }
//Player 1 picks Rock and player2 picks Scissors.
    else if(p1.getChoice() == 1 && p2.getChoice() == 3){
      System.out.println("Player 1 wins!" + "\n" + "Rock beats Scissors! ");
      p1.setScore(p1.getScore() + 1);
    }

//PLayer 1 picks Paper and player2 picks paper
  else if(p1.getChoice() == 3 && p2.getChoice() == 3){
    System.out.println("Both players picked Paper!" + "\n" + "Tie");
  }
//Player 1 picks paper and player 2 picks scissors
  else if(p1.getChoice() == 2 && p2.getChoice() == 3){
    System.out.println("Player 2 wins!" + "\n" + "Scissors beats Paper! ");
    p2.setScore(p2.getScore() + 1);
  }
//Scissors vs rock
  else if(p1.getChoice() == 3 && p2.getChoice() == 1){
    System.out.println("Player 2 wins!" + "\n" + "Rock beats Scissors! ");
    p2.setScore(p2.getScore() + 1);
  }
//Scissors vs paper
  else if(p1.getChoice() == 3 && p2.getChoice() == 2){
    System.out.println("Player 1 wins!" + "\n" + "Scissors beats paper! ");
    p1.setScore(p1.getScore() + 1);
  }
//Scissors vs rock
  else if(p1.getChoice() == 3 && p2.getChoice() == 1){
    System.out.println("Player 2 wins!" + "\n" + "Paper beats Rock ");
    p2.setScore(p2.getScore() + 1);
  }
//Both players pick scissors
  else if(p1.getChoice() == 3 && p2.getChoice() == 3){
    System.out.println("Both players picked Scissors!" + "\n" + "Tie");
  }
}
/********************************************************************************/
//Function to display the winner and the their score.
public static void declareWinner(player p1, player p2){
  if(p1.getScore() > p2.getScore()){
    System.out.println("The winner of this bout is..." + p1.getName() + "!" + "\n" +
    "Player 1 Score: " + p1.getScore() + "\n" +
    "Player 2 Score: " + p2.getScore());
      playVictorySong();

  }
  else if(p2.getScore() > p1.getScore()){
    System.out.println("The winner of this bout is..." + p2.getName() + "!" + "\n" +
    "Player 1 Score: " + p1.getScore() + "\n" +
    "Player 2 Score: " + p2.getScore());
      playVictorySong();
    }
  else{
    System.out.println("No winner! It is a tie!");
  }
}
//Function to play a victory song if either player wins.
public static void playVictorySong(){
  try{
    //Opening the audio file.
    File file = new File("Victory.wav");
    Clip clip = AudioSystem.getClip();
    clip.open(AudioSystem.getAudioInputStream(file));
    clip.start(); //Playing the clip.
    Thread.sleep(clip.getMicrosecondLength()/100);

  }catch(Exception e){
    System.out.println("File does not exist!");
  }
}

public static int computerChoice(){
  Random rand = new Random();
  int randomNumber = rand.nextInt((3 -1) + 1) + 1;
  return randomNumber;
}
/*********************************************************************************************************
*/
public static void main(String[]args){
final String ANSI_CLS = "\u001b[2J";
final String ANSI_HOME = "\u001b[H";
boolean validater = false;
Scanner input = new Scanner(System.in);
int choiceSelected = 0;
int numRounds = 3;


System.out.print(ANSI_CLS + ANSI_HOME);
System.out.flush();
//Obtaining which mode of gameplay to launch.
System.out.println("Would you like to play against a friend or against a machine?");
while(validater != true){
  try{
    System.out.println("Enter 1 for friend and 2 for machine");
    choiceSelected = input.nextInt();
    if(choiceSelected == 1 || choiceSelected == 2){
          validater = true;
    }
  }catch(Exception e){
    System.out.println("Invalid choice option!");
    input.nextLine();
  }
}

validater = false;

while(validater != true){
  try{
    System.out.println("How many rounds do you want to battle for?");
    numRounds = input.nextInt();
    if(numRounds >= 3 && choiceSelected <= 13){
      validater = true;
    }
  }catch(Exception e){
    System.out.println("Number of rounds must be 3 - 12.");
    input.nextLine();
  }
}

switch(choiceSelected){
  case 1:
    System.out.println("You selected 2 player game play" + "\n");
    opening();
    System.out.println("First player:");
    player p1 = getPlayer();
    System.out.println("Second player:");
    player p2 = getPlayer();
    p1Name = p1.getName();
    p2Name = p2.getName();
    setMatchUp(p1, p2);
    playBell();

    for(int i = 0; i < numRounds; i++){
      pickWeapon(p1);
      System.out.print(ANSI_CLS + ANSI_HOME);
      System.out.flush();
      pickWeapon(p2);
      System.out.print(ANSI_CLS + ANSI_HOME);
      System.out.flush();
      logic(p1,p2);
      if( i < numRounds){
        System.out.println("Next round.");
      }
      else if(i == numRounds){
        System.out.println("Final round.");
      }
    }
    declareWinner(p1,p2);
    break;

  case 2:
  System.out.println("You selected Computer game play");
  player player1 = getPlayer();
  player computer = new player();
  computer.setName("computer");
  for(int i = 0; i < numRounds; i++){
    pickWeapon(player1);
    System.out.print(ANSI_CLS + ANSI_HOME);
    System.out.flush();
    int randomSelection = computerChoice();
    computer.setChoice(randomSelection);
    logic(player1,computer);
    if( i < numRounds){
      System.out.println("Next round.");
    }
    else if(i == numRounds){
      System.out.println("Final round.");
    }
  }
  declareWinner(player1,computer);
    break;
  } //end of switch statement.

  } //end of main
} // end of class
