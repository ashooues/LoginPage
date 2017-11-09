package com.ShoppingCart.Services;

import com.ShoppingCart.Model.UserDetails;

import java.util.List;

public interface UserService {

    UserDetails findById(int id);

    UserDetails findByEmail(String email);

    void saveUser(UserDetails user);
//
    void updateUser(UserDetails user);

    void deleteUserByEmail(String sso);

    List<UserDetails> findAllUsers();


//    void register(UserDetails user);
}