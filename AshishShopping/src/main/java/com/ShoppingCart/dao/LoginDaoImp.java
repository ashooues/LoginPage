package com.ShoppingCart.dao;

import com.ShoppingCart.Model.UserDetails;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

@Repository("LoginDao")
public class LoginDaoImp extends AbstractDao<Integer, UserDetails> implements LoginDao {

    static final Logger logger = LoggerFactory.getLogger(LoginDaoImp.class);

    public UserDetails findById(int id) {
        UserDetails user = getByKey(id);
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }

    public UserDetails findByEmail(String sso) {
        logger.info("SSO : {}", sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("EmailId", sso));
        UserDetails user = (UserDetails) crit.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<UserDetails> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<UserDetails> users = (List<UserDetails>) criteria.list();

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return users;
    }

    public void save(UserDetails user) {
        persist(user);
    }

    public void deleteByEmail(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("EmailId", sso));
        UserDetails user = (UserDetails) crit.uniqueResult();
        delete(user);
    }

}