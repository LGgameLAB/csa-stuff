import java.util.ArrayList; 
public class Main
{
   public static void main(String[] args)
   {
      ArrayList <Appointment> appt = new ArrayList(); 
      
      appt.add( new Monthly(15, "pay the bills"));
      appt.add( new Onetime(2024, 5, 1, "Dentist appointment."));
      appt.add( new Daily("Brush your teeth")); 
      
      for ( int i = 0 ; i < appt.size(); i ++ ) { 
          System.out.println(appt.get(i).occursOn(2024,5,1)); 
        }
    
   }
}

