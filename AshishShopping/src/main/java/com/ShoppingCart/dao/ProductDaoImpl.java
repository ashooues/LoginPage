

package com.ShoppingCart.dao;

import com.ShoppingCart.Model.Product;
import com.ShoppingCart.Model.UserProfile;

import java.util.List;

public class ProductDaoImpl extends AbstractDao<Integer, ProductDao>implements ProductDao{
    Product findByPdId(int id){
        return getBy(id);
    }
    Product findByName(String name){

    }

    Product findByCategory(String ctg){

    }
    Product findBySubCategory(String stgc){

    }
    List<Product> listAllProducts(){

    }
}


