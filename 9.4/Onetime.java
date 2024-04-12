public class Onetime extends Appointment{
    public Onetime (int y, int m, int d, String name){
        super(name);
        day = d;
        month = m;
        year = y;
    }
}
