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
        Thread.sleep(100); //0.1 second pause between characters/
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

  public static void setMatchUp(player p1, player p2){
    System.out.println("========================================="+ "\n" +"This match is set for 3 brutal rounds." + "\n" +
    "I want no foul or dirty plays, protect yourself at all times." + "\n" +
    p1.getName() + " are you ready? " + "\n"
    + p2.getName() + " are you ready?" + "\n"+
    "Let's get it on!");
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

 public static void pickWeapon (player p){
    int choice = 0;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Select your option.");
    //Do while loop for the user selecting their choice.
    do{
      System.out.println("Enter 1. for Rock" + "\n"
      + "Enter 2. for Paper" + "\n" + "Enter 3. for Scissors");
      choice = keyboard.nextInt();

      switch(choice){
        case 1 : p.setChoice(1);
            break;

        case 2: p.setChoice(2);
            break;

        case 3: p.setChoice(3);
            break;
        default:{
          System.out.println("Invalid choice option!");
        }
      }
    }while(choice == 0); //End of do loop

    //Clearing the terminal screen.
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void logic(player p1, player p2){
//Both players pick rock.
    if(p1.getChoice() == 1 && p2.getChoice() == 1){
      System.out.println("Both players picked rock!" + "\n" + "Tie");
      //return;
    }
//Player 1 picks rock and player2 picks paper
    else if(p1.getChoice() == 1 && p2.getChoice() == 2){
      System.out.println("Player 2 wins!" + "\n" + "Rock beats Paper! ");
      p2.setScore(p2.getScore() + 1);
      //return;
    }
//Player 1 picks Rock and player2 picks Scissors.
    else if(p1.getChoice() == 1 && p2.getChoice() == 3){
      System.out.println("Player 1 wins!" + "\n" + "Rock beats Scissors! ");
      p1.setScore(p1.getScore() + 1);
    }

//PLayer 1 picks Paper and player2 picks paper
  else if(p1.getChoice() == 3 && p2.getChoice() == 3){
    System.out.println("Both players picked Paper!" + "\n" + "Tie");
    //return;
  }
//Player 1 picks paper and player 2 picks scissors
  else if(p1.getChoice() == 2 && p2.getChoice() == 3){
    System.out.println("Player 2 wins!" + "\n" + "Scissors beats Paper! ");
    p2.setScore(p2.getScore() + 1);
    //return;
  }
//Scissors vs rock
  else if(p1.getChoice() == 3 && p2.getChoice() == 1){
    System.out.println("Player 2 wins!" + "\n" + "Rock beats Scissors! ");
    p2.setScore(p2.getScore() + 1);
    //return;
  }
//Scissors vs paper
  else if(p1.getChoice() == 3 && p2.getChoice() == 2){
    System.out.println("Player 1 wins!" + "\n" + "Scissors beats paper! ");
    p1.setScore(p1.getScore() + 1);
    //return;
  }
//Paper vs rock
  else if(p1.getChoice() == 3 && p2.getChoice() == 1){
    System.out.println("Player 2 wins!" + "\n" + "Paper beats Rock ");
    p2.setScore(p2.getScore() + 1);
    //return;
  }
//Both players pick scissors
  else if(p1.getChoice() == 3 && p2.getChoice() == 3){
    System.out.println("Both players picked Scissors!" + "\n" + "Tie");
    //return;
  }

}

public static void declareWinner(player p1, player p2){
  if(p1.getScore() > p2.getScore()){
    System.out.println("The winner of this bout is..." + p1.getName() + "!" + "\n" +
    "Player 1 Score: " + p1.getScore() + "\n" +
    "Player 2 Score: " + p2.getScore());
  }
  else if(p2.getScore() > p1.getScore()){
    System.out.println("The winner of this bout is..." + p2.getName() + "!" + "\n" +
    "Player 1 Score: " + p1.getScore() + "\n" +
    "Player 2 Score: " + p2.getScore());
  }
  else{
    System.out.println("No winner! It is a tie!");
  }
}

  public static void main(String[]args){

    opening();
    player p1 = getPlayer();
    player p2 = getPlayer();
    setMatchUp(p1, p2);
    playBell();
    pickWeapon(p1);
    pickWeapon(p2);
  //  System.out.println("Player one choice is " + p1.getChoice());
    //System.out.println("Player two choice is " + p2.getChoice());
for(int start = 0; start < 3; start++){
  logic(p1,p2);
}
declareWinner(p1,p2);

  /*  System.out.println("Player1 name is: " + p1.getName());
    System.out.println("Player1 hometown is: " + p1.getHomeTown());

    System.out.println("Player2 name is: " + p2.getName());
    System.out.println("Player2 hometown is: " + p2.getHomeTown());
    */

    }
}
