//package level1;

public class CalculateProfitLoseInNumAndPercent {
	public static void main(String[] args) {
		
		int cost_price=129;
		int selling_price=191;
		
		int profit=selling_price-cost_price;
		double profit_percentage=profit/cost_price *100;
		System.out.print("The Cost Price is INR "+ cost_price +" and Selling Price is INR "+selling_price
				+ "\r\nThe Profit is INR "+ profit +" and the Profit Percentage is "
				+ profit_percentage);
	}

}

