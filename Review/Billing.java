package Review;
public class Billing{
    public static void main(String[] args){
        Product b1=new Electronics("charger",100);
        Product b2=new Clothing("shirt",300);
        Product b3=new Grocery("rice",120);

        b1.printDetails();
        b2.printDetails();
        b3.printDetails();
    }
}

abstract class Product{
    String name;
    int price;
    Product(String name,int price){
        this.name=name;
        this.price=price;
    }

    public abstract double getDiscountRate();
    
    public double calculateDiscount() {
        return price * getDiscountRate();
    }

    public double priceAfterDiscount() {
        return price - calculateDiscount();
    }

    public void printDetails(){
        System.out.println("name: "+name+" price: "+price+" Disc: "+calculateDiscount()+" Pay: "+priceAfterDiscount());
    }
}
class Electronics extends Product{
    Electronics(String name,int price){
        super(name, price);
    }
    @Override
    public double getDiscountRate(){
        return 0.10;
    }

}
class Clothing extends Product{
    Clothing(String name,int price){
        super(name,price);
    }
    @Override
    public double getDiscountRate(){
        return 0.20;
    }
}
class Grocery extends Product{
    Grocery(String name,int price){
        super(name, price);
    }
    @Override
    public double getDiscountRate(){
        return 0.0;
    }

}
