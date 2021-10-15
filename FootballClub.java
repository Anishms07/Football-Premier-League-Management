package management;    //Package name is management

import pack2.SportsClub;

public class FootballClub extends SportsClub     //Inherits the properties of class SportsClub
{
     int winCount;
     int drawCount;
     int defeatCount;
     int scoredGoalsCount;
     int receivedGoalsCount;
     int points;
     int matchesPlayed;
    
    public int getWinCount(){              //Functions used to get the value of wincount
        return winCount;
    }
    
    public int getDrawCount() {
        return drawCount;
    }
    
    public int getDefeatCount(){
        return defeatCount;
    }
    
    public int getScoredGoalsCount() {
        return scoredGoalsCount;
    }
    
    public int getReceivedGoalsCount() {
        return receivedGoalsCount;
    }
    
    public int getPoints() {
        return points;
    }
    
    public int getMatchesPlayed() {
        return matchesPlayed;
    }
    
    public void setWinCount(int i) {                  //Assigning the value to wincount
        winCount=i;
    }
    
    public void setDrawCount(int i){
        drawCount = i;
    }
    
    public void setDefeatCount(int i) {
        defeatCount=i;
    }
    
    public void setScoredGoalsCount(int i){
        scoredGoalsCount = i;
    }
    
     public void setRecievedGoalsCount(int i){
        receivedGoalsCount = i;
    }
     
     public void setPoints(int i){
        points = i;
    }
    
     public void setMatchesPlayed(int i){
        matchesPlayed = i;
    }
    
}
