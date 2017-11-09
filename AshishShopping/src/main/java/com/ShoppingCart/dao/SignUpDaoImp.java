package com.ShoppingCart.dao;

import com.ShoppingCart.Model.UserDetails;
import org.springframework.stereotype.Repository;

@Repository("SignUpDao")
public class SignUpDaoImp extends AbstractDao<Integer, UserDetails> implements SignUpDao {
    public void savePost(UserDetails up) {

        persist(up);
    }
}
