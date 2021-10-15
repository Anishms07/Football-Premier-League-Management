package management;     //Package name is management
class single implements Runnable
{
	public void run()
	{
		
		System.out.println("");
		System.out.println("Welcome to Premier League Management Program");
		System.out.println("");
	}
}
public class FootballManager 
{

    public static void main(String[] args)
    {
    	single s=new single();
    	Thread t=new Thread(s);     
    	t.start();                //Execution of thread
        PremierLeagueManager plm = new PremierLeagueManager(20); //Object of premierleaguemanger is created and the constructor is invoked
   
    }
    
}
