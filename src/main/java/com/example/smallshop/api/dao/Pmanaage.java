package com.example.smallshop.api.dao;


import com.example.smallshop.api.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Pmanaage extends JpaRepository<Product,Integer> {

    @Query("select u from Product u where u.pname = ?1")
    Product[] findProductByName(String Pname);

}
