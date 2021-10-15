package pack2; //package name is pack2

public abstract class SportsClub 
{
    
     String name;
     String location;
     String statistics;
    
    
    public boolean equals(Object o) //Returns true if the arguement is not null and is a boolean object
    {
        return this.name.equals(((SportsClub)o).name);
    }
    
    
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getStatistics() {
        return statistics;
    }
    
    public void setLocation(String s) {
        this.location = s;
    }
    
    public void setName(String s) {
        this.name = s;
    } 
    
    public void setStatistics(String s) {
        this.statistics = s;
    }   
    
}
