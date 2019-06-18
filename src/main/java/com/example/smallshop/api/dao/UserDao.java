package com.example.smallshop.api.dao;

import com.example.smallshop.api.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends  JpaRepository<User,Integer> {



   @Query("select u from User u where u.name = ?1")
    User findUserByName(String name);

    @Query("select u from User u where u.name = ?1")
    List<User> findUsersByName(String name);


    @Query("select u from User u where u.id = ?1")
    User findUserById(Integer id);

}
