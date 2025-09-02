package Smartcity.services;

import Smartcity.interfaces.TransportService;
import Smartcity.interfaces.EmergencyService;

public class Ambulanceservice implements TransportService, EmergencyService {
    @Override
    public String getName() { return "Ambulance"; }

    @Override
    public double getFare(double distance) { return 0.0; } // Free for emergency
}
