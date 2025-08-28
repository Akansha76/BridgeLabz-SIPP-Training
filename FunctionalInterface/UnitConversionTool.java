package FunctionalInterface;

interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }

    static double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }
}

public class UnitConversionTool {
    public static void main(String[] args) {
        double km = 10;
        double kg = 5;
        double celsius = 25;

        System.out.println(km + " km = " + UnitConverter.kmToMiles(km) + " miles");
        System.out.println(kg + " kg = " + UnitConverter.kgToLbs(kg) + " lbs");
        System.out.println(celsius + "°C = " + UnitConverter.celsiusToFahrenheit(celsius) + "°F");
    }
}

