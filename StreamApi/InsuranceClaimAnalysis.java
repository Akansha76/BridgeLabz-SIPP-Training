package StreamApi;

// Stream API Example 3: Insurance Claim Analysis

import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 5000),
            new Claim("Auto", 3000),
            new Claim("Health", 7000),
            new Claim("Home", 8000),
            new Claim("Auto", 4000)
        );

        Map<String, Double> avgClaims = claims.stream()
            .collect(Collectors.groupingBy(c -> c.type,
                     Collectors.averagingDouble(c -> c.amount)));

        avgClaims.forEach((type, avg) -> 
            System.out.println(type + " -> Average: " + avg));
    }
}
