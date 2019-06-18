package com.example.smallshop.api.controller;

import com.example.smallshop.api.bean.Product;
import com.example.smallshop.api.dao.Pmanaage;
import com.example.smallshop.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private Pmanaage pmanaage;

    @RequestMapping("/search")
    public String search(String search,String pname){
           return "manage";
    }

}
