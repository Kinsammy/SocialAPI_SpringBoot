package com.samytech.socialapi.user;

import com.samytech.socialapi.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value="/users/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/users/{id}")
    public void updateUser(@PathVariable String id,@RequestBody User user){
        userService.updateUser(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

}
