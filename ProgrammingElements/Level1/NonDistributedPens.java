//package level1;

public class NonDistributedPens {
	 public static void main(String[] args) {
			
			int Total_pen=14; 
			int Total_Student=3;
			int Pen_each_Student=14/3;
			int Not_Distributed_Pen=Total_pen%Total_Student;
			System.out.print("The Pen Per Student is "+Pen_each_Student+" and the remaining pen not distributed is "+Not_Distributed_Pen );
			
			
		}
		
	

}
