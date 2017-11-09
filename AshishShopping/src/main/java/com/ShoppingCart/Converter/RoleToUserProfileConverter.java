package com.ShoppingCart.Converter;

import com.ShoppingCart.Model.UserDetails;
import com.ShoppingCart.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserDetails>{

    static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);

    @Autowired
    UserService userProfileService;

    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserDetails convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserDetails profile= userProfileService.findById(id);
        logger.info("Profile : {}",profile);
        return profile;
    }

}