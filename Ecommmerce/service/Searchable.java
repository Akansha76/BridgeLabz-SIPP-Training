package Ecommmerce.service;

import Ecommmerce.model.Products;
import java.util.List;

public interface Searchable {
    List<Products> searchByName(String name);
    List<Products> searchByCategory(String category);
}


