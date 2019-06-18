package com.example.smallshop.api.controller;


import com.example.smallshop.api.bean.User;
import com.example.smallshop.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller

public class TurnController {

    @Autowired
    private UserService userService;






    @RequestMapping("/register")
    public String register(){

        return "register";
    }
    @RequestMapping("/successlogin")
    public String successlogin(){

        return "successlogin";
    }

    @RequestMapping("/suc")

    public String succ(Map<String, Object> map){
        map.put("name", "Hello, Spring Boot!");
        map.put("password", "Hello, Spring Boot!");
        return  "successlogin";
    }


    @RequestMapping("/text")
    public String text(){

        return "text";
    }


    @RequestMapping("/delete/{id}")
    public String Product(@PathVariable Integer id, ModelMap modelMap)throws IOException {
        userService.deleteById(id);
        List<User> userList = userService.getUsers();
        modelMap.put("users",userList);
        return "manage";
    }

    @RequestMapping("/find/{name}")
    public String search(@PathVariable  String name,HttpServletResponse response, ModelMap modelMap) throws IOException {
        List<User> user= userService.findUsersByName(name);

        if(user==null){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('没有该条信息');");
            out.println("</script>");

        }else{
            modelMap.put("users",user);
        }
        return "manage";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable  Integer id, String password, HttpServletResponse response,ModelMap modelMap,Map<String, Object> map){
        User user= userService.findUserById(id);
        map.put("id", user.getId());
        map.put("name", user.getName());
        map.put("password", user.getPassword());
        return "edit";
    }


    @RequestMapping("/editok")
    public String editok(String id,String name, String password) throws IOException {
        userService.updateUser(Integer.valueOf(id), name, password);
        return "manage";
    }

    @RequestMapping("/add")
    public String add(String name, String password, HttpServletResponse response,ModelMap modelMap){
      //  userService.creatUser(name,password);
        return "add";
    }

    @RequestMapping("/addok")
    public String addok(String name, String password, HttpServletResponse response,ModelMap modelMap){
        List<User> userList = userService.creatUser(name,password);
        modelMap.put("users",userList);
        return "manage";
    }

    @RequestMapping("/login")
    public String index(String username, String password, HttpServletResponse response,ModelMap modelMap) throws IOException {

        String state = userService.login(username, password);
        if (state.equals("error")) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('用户名或密码错误');");
            out.println("</script>");
            return "index";
        } else if (state.equals("success")) {

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('登陆成功');");
            out.println("</script>");
            List<User> userList = userService.getUsers();
            modelMap.put("users",userList);
            return "manage";

        } else if(state.equals("null")) {
            return "index";
        }
        return   "index";

    }

}
