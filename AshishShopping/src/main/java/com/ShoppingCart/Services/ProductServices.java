
package com.ShoppingCart.Services;

import com.ShoppingCart.Model.Product;

import java.util.List;

public interface ProductServices {
    Product findByPdId(int id);
    Product findByName(String name);
    Product findByCategory(String ctg);
    Product findBySubCategory(String sctg);
    List<Product> listAllProducts();
}
