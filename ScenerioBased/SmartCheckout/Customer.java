package ScenerioBased.SmartCheckout;

import java.util.*;

public class Customer {
    String name;
    List<String> cart;

    public Customer(String name, List<String> cart) {
        this.name = name;
        this.cart = cart;
    }

    public String toString() {
        return name + "'s cart: " + cart;
    }
}

