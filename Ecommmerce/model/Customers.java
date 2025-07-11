package Ecommmerce.model;

public class Customers {
   private String name;
   private int id;
   
   Customers(String name,int id){
    this.id=id;
    this.name=name;
   }

    public int getId() {
       return id;
    }
    public String getName(){
      return name;
    }
}

