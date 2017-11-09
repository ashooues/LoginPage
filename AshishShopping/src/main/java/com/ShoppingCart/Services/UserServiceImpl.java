package com.ShoppingCart.Services;
import java.util.List;

import com.ShoppingCart.Model.UserDetails;
import com.ShoppingCart.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private LoginDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails findById(int id) {
        return dao.findById(id);
    }


    public UserDetails findByEmail(String sso) {
        UserDetails user = dao.findByEmail(sso);
        return user;
    }


    public void saveUser(UserDetails user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(UserDetails user) {
        UserDetails entity = dao.findById(user.getUserId());
        if(entity!=null){
 //           entity.setSsoId(user.getSsoId());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setUserName(user.getUserName());
            entity.setPhoneNo(user.getPhoneNo());
            entity.setEmailId(user.getEmailId());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }


    public void deleteUserByEmail(String sso) {
        dao.deleteByEmail(sso);
    }

    public List<UserDetails> findAllUsers() {
        return dao.findAllUsers();
    }

//    public boolean isUserSSOUnique(Integer id, String sso) {
//        UserDetails user = findBySSO(sso);
//        return ( user == null || ((id != null) && (user.getUserId()==id)));
//    }

}