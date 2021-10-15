package management; //package name is management
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager 
{
    
     final int numberOfClubs;                                  //final keyword is used so that the contents are not modified
     final ArrayList<FootballClub> league= new ArrayList<>();   //Creating arraylist
     final Scanner scanner=new Scanner(System.in);
     final ArrayList<Match> matches=new ArrayList<>();
    
    public PremierLeagueManager(int numberOfClubs)               //constructor of Premierleaguemanager
    {
        
        this.numberOfClubs = numberOfClubs;
        displayMenu();
    }
    
          public void displayMenu()
          {
        
        while(true) {
            System.out.println("Premier League menu: ");
            System.out.println("Create new team and add it to league (press 1)");
            System.out.println("Delete existing team from league (press 2)");
            System.out.println("Display Statistics for team (press 3)");
            System.out.println("Display the Premier League Table (press 4)");
            System.out.println("Add a Played Match (press 5)");
            String line = scanner.nextLine();
            int command=0;
            try
            {
                command = Integer.parseInt(line);      //this method prases string into single decimal integer
            } 
            catch (Exception e) 
            {
                  }
            
            switch(command) 
            {
                case 1 :
                   addTeam();
            break;
                case 2 :
                    deleteTeam();
                    break;
                case 3 :
                    displayStatistics();
                  break;
                case 4 :
                    displayLeagueTable();
                  break;
                case 5:
                    addPlayedMatch();
                   break;
              
            default:
            System.out.println("Wrong Command");
        }
        
    } 
   }
    
   public void addTeam()                                          //Member function to add teams
   {
        if(league.size() == numberOfClubs)                      //The size() method returns the number of elements in the arraylist league
        {
            System.out.println("Can't add more clubs to league");
            return;
        }
        
        FootballClub club = new FootballClub();   //Oject creation
        System.out.println("Insert Club Name: ");
        String line = scanner.nextLine();
        club.setName(line);
        
        if(league.contains(club))       //contains(object) Returns true if the list contains specified element
        {
            System.out.println("This club is already in the league");
            return;
        }
        System.out.println("Insert Club Location: ");
        line = scanner.nextLine();
        club.setLocation(line);
        league.add(club);           //add(object) adds it to the arraylist
    }
    
  public void deleteTeam()                //Member function to delete teams
  {
        System.out.println("Insert club name: ");
        String line = scanner.nextLine();
         for(FootballClub club : league)
         {
             if(club.getName().equals(line))
             {
                 league.remove(club);         //Remove(object) removes the first occurence team from the league
                 System.out.println("Club "+ club.getName()+" removed");
                 return;
             }
         }
         System.out.println("No such club in league");
    }
    
    public void displayStatistics()          //Function to display statistics
    {
        
        System.out.println("Insert club name: ");
        String line = scanner.nextLine();
         for (FootballClub club : league)         //For loop syntax for Arraylist for(class name object : object of arraylist)
         {
             if(club.getName().equals(line)){
                 System.out.println("Club " + club.getName()+ " matches won: " + club.getWinCount());
                 System.out.println("Club " + club.getName()+ " matches lost: " + club.getDefeatCount());
                 System.out.println("Club " + club.getName()+ " matches draw: " + club.getDrawCount());
                 System.out.println("Club " + club.getName()+ " scored goals: " + club.getScoredGoalsCount());
                 System.out.println("Club " + club.getName()+ " recieved goals: " + club.getReceivedGoalsCount());
                 System.out.println("Club " + club.getName()+ " points: " + club.getPoints());
                 System.out.println("Club " + club.getName()+ " matches played: " + club.getMatchesPlayed());
                 return;
             }
         }
         System.out.println("No such club in league");
    } 
        
    public void displayLeagueTable()          //Function to display the points table
    {
        
        Collections.sort(league, new CustomComparator());     //Sorting the clubs and calling the customcomparator
        for(FootballClub club : league)
        {
            System.out.println("Club: " + club.getName()+" Points: "+ club.getPoints()+" goal difference: "+ (club.getScoredGoalsCount()-club.getReceivedGoalsCount()));
    }    
  }
    
    
    public void addPlayedMatch()                  //Function to add matches played between two teams
    {
       
        System.out.println("Enter Home Team: ");
       String line = scanner.nextLine();
        FootballClub home = null;
          for(FootballClub club : league){
              if(club.getName().equals(line))
                  home = club;
          }  
          if (home == null) {
              System.out.println("No such club in league");
              return;
          }
          System.out.println("Enter Away Team: ");
          line = scanner.nextLine();
          FootballClub away = null;
           for(FootballClub club : league){
              if(club.getName().equals(line))
                  away = club;
          } 
           if (away == null) {
              System.out.println("No such club in league");
              return;
          }
           
           System.out.println("Enter home team goals: ");
           line = scanner.nextLine();
           int homeGoals = -1;
             try {
                 homeGoals = Integer.parseInt(line);                
             } catch (Exception e) { 
    }
         if (homeGoals == -1) {
             System.out.println("You have to enter number of goals");
             return;
         }
         
         System.out.println("Enter away team goals: ");
           line = scanner.nextLine();
           int awayGoals = -1;
             try {
                 awayGoals = Integer.parseInt(line);                
             } catch (Exception e) { 
    }
         if (awayGoals == -1) {
             System.out.println("You have to enter number of goals");
             return;
         }
               
         Match match = new Match();  //Object creation of the class match
        
         match.setTeamA(home);
         match.setTeamB(away);
         match.setTeamAScore(awayGoals);
         match.setTeamBScore(homeGoals);
         matches.add(match);
         home.setScoredGoalsCount(home.getScoredGoalsCount()+homeGoals);
         away.setScoredGoalsCount(away.getScoredGoalsCount()+awayGoals);
         home.setRecievedGoalsCount(home.getReceivedGoalsCount()+awayGoals);
         away.setRecievedGoalsCount(away.getReceivedGoalsCount()+homeGoals);
         home.setMatchesPlayed(home.getMatchesPlayed()+1);
         away.setMatchesPlayed(away.getMatchesPlayed()+1);
         
         if (homeGoals > awayGoals) {            
             home.setPoints(home.getPoints()+3);
             home.setWinCount(home.getWinCount()+1);
             away.setDefeatCount(away.getDefeatCount()+1);
         }
         
         else if (homeGoals < awayGoals) {            
             away.setPoints(away.getPoints()+3);
             away.setWinCount(away.getWinCount()+1);
             home.setDefeatCount(home.getDefeatCount()+1);
         }
         else {
             home.setPoints(home.getPoints()+1);
             away.setPoints(away.getPoints()+1);
             home.setDrawCount(home.getDrawCount()+1);
             away.setDrawCount(away.getDrawCount()+1);
         }      
    } 
    
   } 
    
    
    
    

