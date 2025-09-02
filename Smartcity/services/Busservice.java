package Smartcity.services;


import Smartcity.interfaces.TransportService;

public class Busservice implements TransportService {
    private double ratePerKm = 2.0;

    @Override
    public String getName() { return "Bus"; }

    @Override
    public double getFare(double distance) { return ratePerKm * distance; }
}
