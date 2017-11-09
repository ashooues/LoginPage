

package com.ShoppingCart.Services;

import com.ShoppingCart.Model.Product;
import com.ShoppingCart.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ProductServices")
@Transactional
public class ProductServicesImpl {
    @Autowired
    ProductDao dao;

    public Product findByPdId(int id){ return dao.findByPdId(id);}
    public Product findByName(String name){ return dao.findByName(name);}
    public Product findByCategory(String ctg){ return dao.findByCategory(ctg);}
    public Product findBySubCategory(String sctg){ return dao.findBySubCategory(sctg);}
    public List<Product> listAllProducts() {
        return dao.listAllProducts();
    }
}


