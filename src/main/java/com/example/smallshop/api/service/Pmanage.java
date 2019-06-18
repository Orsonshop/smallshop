package com.example.smallshop.api.service;



import com.example.smallshop.api.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pmanage {
    @Autowired
    private  Pmanage pmanage;

    public Product[] findByName(String pname){
        Product[] product=pmanage.findByName(pname);
        return product;
    }
}
