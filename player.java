public class player{
  String name;
  String hometown;
  int score;

  player(){
    name = "Player";
    hometown = "UNKNOWN";
    score = 0;
  }

  player(String name, String hometown, int score){
    this.name = name;
    this.hometown = hometown;
    this.score = score;
  }

  //Setters for the class
  public void setName(String name){
    this.name = name;
  }

  public void setHomeTown(String hometown){
    this.hometown = hometown;
  }

  public void setScore(int score){
    this.score = score;
  }

  //Getters for the class
  public String getName(){
    return this.name;
  }

  public String getHomeTown(){
    return this.hometown;
  }

  public int getScore(){
    return this.score;
  }
}
