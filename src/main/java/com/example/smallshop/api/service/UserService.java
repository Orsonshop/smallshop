package com.example.smallshop.api.service;

import com.example.smallshop.api.bean.User;
import com.example.smallshop.api.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;



    public String login(String username,String password){
        User user = userDao.findUserByName(username);
        if (user == null) {
             return  "null";
        }  else {
            if (password.equals(user.getPassword())&&username.equals(user.getName()) ){
                      return "success";
            } else  {

                return "error";
            }
        }
    }


    public List<User> getUsers(){
        return userDao.findAll();
    }

    public  List<User> creatUser(String name,String password){

        User user = new User(name,password);
        userDao.save(user);
        return userDao.findAll();
    }

    public User findUserById(Integer id){

        return userDao.findUserById(id);
    }

    public  User findUserByName(String name){

        return userDao.findUserByName(name);
    }

    public  List<User> findUsersByName(String name){

        return userDao.findUsersByName(name);
    }



    public String updateUser(Integer id,String name,String password){
        User user= new User(id,name,password);
        userDao.save(user);
        return "update success";
    }

    @Transactional
    public void deleteById(Integer id){
        userDao.deleteById(id);
    }

}