public class Daily extends Appointment{
    public Daily(String n){
        super(n);
    }
    public boolean occursOn(int a, int b, int c){
        return true;
    }
}
