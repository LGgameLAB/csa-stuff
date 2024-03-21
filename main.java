import java.util.*;

public class main{
	public static void main(){
		new wow(new int[] {1,2,3,4});
	}
}

class wow{
	ArrayList<Integer> hi;
	public wow(int[] h){
		for (int i: h){
			hi.add(i);
		}
	}
}