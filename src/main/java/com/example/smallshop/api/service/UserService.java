package com.example.smallshop.api.service;

import com.example.smallshop.api.bean.User;
import com.example.smallshop.api.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


   @Cacheable(value = "small",key="")
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

    @Cacheable(value ="findall")
    public  List<User> creatUser(String name,String password){

        User user = new User(name,password);
        userDao.save(user);
        System.out.println("sql");
        return userDao.findAll();
    }
   @Cacheable(value ="findid",key = "#Id")
    public User findUserById(Integer id){
        System.out.println("sql");
        return userDao.findUserById(id);
    }
    @Cacheable(value ="findname",key = "#name")
    public  User findUserByName(String name){
        System.out.println("sql");
        return userDao.findUserByName(name);
    }
   @Cacheable(value ="findnames",key = "#name")
    public  List<User> findUsersByName(String name){
        System.out.println("sql");
        return userDao.findUsersByName(name);
    }


  @Cacheable(value ="update",key = "#name")
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