public class Appointment{
    public int day, month, year;
    public String name;
    
    public Appointment(String n){
        name = n;
    }
    public boolean occursOn(int y, int m, int d){
        return (y == year) && (month == m) && (y == d);
    }
}
