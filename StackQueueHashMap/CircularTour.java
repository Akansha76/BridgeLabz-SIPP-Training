package StackQueueHashMap;

public class CircularTour {
    public static int canCompleteTour(int[] petrol, int[] distance) {
        int totalSurplus = 0, currentSurplus = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int diff = petrol[i] - distance[i];
            totalSurplus += diff;
            currentSurplus += diff;

            if (currentSurplus < 0) {
                // Can't reach next pump, reset start
                start = i + 1;
                currentSurplus = 0;
            }
        }

        return totalSurplus >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int startIndex = canCompleteTour(petrol, distance);
        System.out.println("Start at pump index: " + startIndex);
    }
}

