package management; //Package name is management
 
import pack2.SportsClub;

public class Match  
{
    
     FootballClub teamA;
     FootballClub teamB;
     int teamAScore;
     int teamBScore;
   
    
    
    public FootballClub getTeamA()
    {
        return teamA;
    }
    
    public FootballClub getTeamB() {
        return teamB;
    }
    
    public int getTeamAScore(){
        return teamAScore;
    }
    
    public int getTeamBScore(){
        return teamBScore;
    }
    
    
    public void setTeamA(FootballClub teamA) 
    {
        this.teamA = teamA;
    }
    
    public void setTeamB(FootballClub teamB) {
        this.teamB = teamB;
    }
    
    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }
    
    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }
    
   
}
