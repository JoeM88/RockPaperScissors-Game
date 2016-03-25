/* Title: RockPaperScissors.java
Description: Java program to simulate a rock paper and scissors game.
Author: Joseph Molina
Date 3/23/16
*/
import java.util.*;

public class RockPaperScissors extends player{

  //Method to display the welcome message
  public static void opening()
  {
    String text = "Are you ready to play?";
    System.out.println("=========== Welcome to the ultimate Rock Paper and Scissors Match! =============");
    int iterator;
    for(int i = 0;i < text.length();i++){
      System.out.printf("%c", text.charAt(i));
      try{
        Thread.sleep(300); //0.3second pause between characters/
      }catch(Exception e){
        Thread.currentThread().interrupt();
      }
    }
    System.out.println("");
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

  public static void main(String[]args){

    opening();
    player p1 = getPlayer();

    //System.out.println("Player1 name is: " + p1.getName());
    //System.out.println("Player1 hometown is: " + p1.getHomeTown());

    }
}
