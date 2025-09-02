package Smartcity.services;



import Smartcity.interfaces.TransportService;

public class EVChargingStation implements TransportService {
    private double ratePerUnit = 5.0;

    @Override
    public String getName() { return "EV Charging Station"; }

    @Override
    public double getFare(double units) { return units * ratePerUnit; }
}
