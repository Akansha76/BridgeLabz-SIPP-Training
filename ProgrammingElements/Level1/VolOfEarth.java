//package level1;

public class VolOfEarth {
public static void main(String[] args) {
		
		int radius=6378;
		int vol_km=(4/3)*(22/7)*radius^3;
	    double vol_miles=vol_km*1.6;
		System.out.print("The volume of earth in cubic kilometers is "+vol_km +" and cubic miles is "+vol_miles
	);
		
}

}
