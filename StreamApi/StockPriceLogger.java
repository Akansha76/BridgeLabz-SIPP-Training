package StreamApi;

import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(101.5, 102.8, 99.7, 105.2, 103.9);

        System.out.println(" Stock Price Updates:");
        stockPrices.forEach(price -> System.out.println("Price: $" + price));
    }
}

