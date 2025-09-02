package Smartcity.services;

import Smartcity.interfaces.TransportService;

public class Metroservice implements TransportService {
    private double ratePerKm = 3.0;

    @Override
    public String getName() { return "Metro"; }

    @Override
    public double getFare(double distance) { return ratePerKm * distance; }
}
