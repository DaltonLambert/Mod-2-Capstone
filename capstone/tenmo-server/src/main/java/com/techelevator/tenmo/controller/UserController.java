package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.techelevator.tenmo.security.jwt.TokenProvider;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> findAll(){return userDao.findAll();}

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username){return userDao.findByUsername((username));}

    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public int findIdByUsername(@PathVariable String username){return userDao.findIdByUsername(username);}

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id){return userDao.getUserById(id);}

}
