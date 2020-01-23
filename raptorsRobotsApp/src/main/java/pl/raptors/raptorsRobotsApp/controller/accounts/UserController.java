package pl.raptors.raptorsRobotsApp.controller.accounts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.raptors.raptorsRobotsApp.configuration.SecurityConfiguration;
import pl.raptors.raptorsRobotsApp.domain.accounts.User;
import pl.raptors.raptorsRobotsApp.service.accounts.MongoUserDetailsService;
import pl.raptors.raptorsRobotsApp.service.accounts.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    MongoUserDetailsService mongoUserDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

/*    @RequestMapping("/login")
    public UserDetails login(@RequestBody User user) {
        return mongoUserDetailsService.loadUserByUsername(user.getEmail());
    }*/

//TODO pobrac usera na podstawie maila i porównaj hasła
    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        System.out.println(user.getEmail() +" "+ user.getPassword());
        return user.getEmail().equals("user@mail.com") ;
    }


    @GetMapping("/all")
    public List<User> getAll() {

        return this.userService.getAll();
    }
}
