package Smartcity.services;

import Smartcity.interfaces.TransportService;

public class Taxiservice implements TransportService {
    private double ratePerKm = 10.0;

    @Override
    public String getName() { return "Taxi"; }

    @Override
    public double getFare(double distance) { return ratePerKm * distance; }
}
