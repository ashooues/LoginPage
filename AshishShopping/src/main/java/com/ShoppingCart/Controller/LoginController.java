
package com.ShoppingCart.Controller;

import com.ShoppingCart.Model.UserDetails;
import com.ShoppingCart.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello()
    {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String loginProcess(@RequestBody UserDetails user)
    {
        System.out.println("in here");
        if(userService.findByEmail(user.getEmailId()).getPassword().equals(user.getPassword()))
            return "Succesfully logged in";

        else return "wrong credentials";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String signupProcess(@RequestBody UserDetails user)
    {

        userService.saveUser(user);
        return "Succesfully registered";
    }
}