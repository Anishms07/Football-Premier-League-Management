package management;       //package name is management
import java.util.Comparator;

public class CustomComparator implements Comparator<FootballClub>    //comparator is a interface having two methods equal and compare used to compare two objects
{                                                                     
     
    public int compare(FootballClub t, FootballClub t1)             //Two objects are taken to compare
    {
        
        if(t.getPoints() > t1.getPoints()) 
            return -1;
        else 
            if (t.getPoints() < t1.getPoints())
                return 1;
            else {
                int goalDif = t.getScoredGoalsCount()-t.getReceivedGoalsCount();      //Goal diffeence of team1 calculated
                int goalDif1 = t1.getScoredGoalsCount()-t1.getReceivedGoalsCount();    //Goal diffeence of team2 calculated
                if(goalDif > goalDif1)
                    return -1;
                else
                    if(goalDif < goalDif1)
                        return 1;
                    else return 0;
            }
        
    }
}