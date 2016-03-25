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
    System.out.println("=========== Welcome to the ultimate Rock Paper and Scissors Match! =============");
    int iterator;
    for(int i = 0;i < text.length();i++){
      playTypeWriter();
      System.out.printf("%c", text.charAt(i));
      try{
        Thread.sleep(100); //0.3second pause between characters/
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
      File file = new File("keyboardstroke.wav");
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(file));
      clip.start();
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
      File file = new File("bellSound.wav");
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(file));
      clip.start();
      Thread.sleep(clip.getMicrosecondLength()/1000);

    }catch(Exception e){
      System.out.println("File does not exist!");
    }
  }

/*  public static pickWeapon (player p){
    char choice = '';
    Scanner keyboard = new Scanner(System.in);
    do{
      System.out.println("Enter 1. for Rock" + "\n"
      + "Enter 2. for Paper" + "\n" + "Enter 3. for Scissors");

      choice = keyboard.nextChar

    }


  }
  */

  public static void main(String[]args){

    //playTypeWriter();
    opening();
    player p1 = getPlayer();
    player p2 = getPlayer();
    setMatchUp(p1, p2);
    playBell();
    //System.out.println("GOOOOOOOOO");
  /*  System.out.println("Player1 name is: " + p1.getName());
    System.out.println("Player1 hometown is: " + p1.getHomeTown());

    System.out.println("Player2 name is: " + p2.getName());
    System.out.println("Player2 hometown is: " + p2.getHomeTown());
    */

    }
}
