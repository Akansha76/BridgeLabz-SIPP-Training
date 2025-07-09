//package Review;
public class Vehicle{
    public static void main(String[] args){
        VehicleManagement v1=new Bike("Hero", "Passion Pro", "Petrol");
        VehicleManagement v2=new Car("Maruti-Suzuki", "Alto K10", "Petrol/CNG", 60);
        VehicleManagement v3=new Truck("Tata", "Prima 5530", "Diesel");
        v1.printServiceDetails();
        v2.printServiceDetails();
        v3.printServiceDetails();
    }
}

abstract class VehicleManagement {
    String brand;
    String model;
    String fuelType;
    VehicleManagement(String brand,String model,String fuelType){
        this.brand=brand;
        this.model=model;
        this.fuelType=fuelType;
    }
    public abstract double calculateServiceCost();


    public void printServiceDetails() {
        System.out.printf(
            "Brand: %-10s | Model: %-15s | Fuel: %-8s | Next service cost: %.2f%n",
            brand, model, fuelType, calculateServiceCost()
        );
    }

}

class Car extends VehicleManagement{
    private int Avg_Speed;
    Car(String brand,String model,String fuelType,int Avg_Speed){
        super(brand,model,fuelType);
        this.Avg_Speed=Avg_Speed;
        
    }
    @Override
     public double calculateServiceCost() {
        // rule of thumb: faster car → higher cost
        return 3000 + (Avg_Speed * 5);
    }
}
class Bike extends VehicleManagement{
    Bike(String brand,String model,String fuelType){
        super(brand,model,fuelType);
    }
    @Override
    public double calculateServiceCost() {
        return 1500;  // flat rate
    }
}
class Truck extends VehicleManagement{
    Truck(String brand,String model,String fuelType){
        super(brand,model,fuelType);
    }
    @Override
     public double calculateServiceCost() {
        return 5000;  // bigger vehicle → bigger bill
    }
}


