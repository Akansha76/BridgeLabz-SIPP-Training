package Smartcity.interfaces;



public interface GeoUtils {
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow(lat1 - lat2, 2) + Math.pow(lon1 - lon2, 2)) * 10;
    }
}
