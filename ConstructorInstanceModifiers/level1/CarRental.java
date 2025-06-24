package ConstructorInstanceModifiers.level1;

class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    // Default constructor
    CarRental() {
        customerName = "Unknown";
        carModel = "Basic";
        rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        double ratePerDay;
        switch (carModel.toLowerCase()) {
            case "suv": ratePerDay = 2000; break;
            case "sedan": ratePerDay = 1500; break;
            default: ratePerDay = 1000;
        }
        return ratePerDay * rentalDays;
    }

    void displayDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Neha", "SUV", 4);
        rental.displayDetails();
    }
}
