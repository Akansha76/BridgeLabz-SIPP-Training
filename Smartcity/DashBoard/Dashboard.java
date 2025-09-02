package Smartcity.DashBoard;

import Smartcity.interfaces.TransportService;
import java.util.List;

public class Dashboard {
    public static void displayServices(List<TransportService> services) {
        System.out.println("=== Live Transport Services ===");
        services.forEach(TransportService::printServiceDetails);
    }
}
