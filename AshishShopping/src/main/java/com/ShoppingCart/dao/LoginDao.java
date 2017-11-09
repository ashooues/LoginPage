package com.ShoppingCart.dao;

import java.util.List;
import com.ShoppingCart.Model.UserDetails;

public interface LoginDao {

    UserDetails findById(int id);
    void save(UserDetails user);
    List<UserDetails> findAllUsers();

    UserDetails findByEmail(String email);

    void deleteByEmail(String email);

}
