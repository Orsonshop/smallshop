package com.example.smallshop.api.controller;



import com.example.smallshop.api.bean.User;


import com.example.smallshop.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用,
// 返回json数据不需要在方法前面加@ResponseBody注解了，但使用@RestController这个注解，就不能返回jsp,html页面，
// 视图解析器无法解析jsp,html页面

@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){

        return userService.getUsers();
    }
    @PostMapping("/add/{name}/{password}")
    public List<User> createProduct(@PathVariable String name, @PathVariable String password){

        return userService.creatUser(name,password);

    }
    @PutMapping("/update/{id}/{name}/{password}")
    public String updateProduct(@PathVariable Integer id,@PathVariable String name,@PathVariable String password){

        return userService.updateUser(id,name,password);

    }

    @RequestMapping("/delete/{id}")
    public void Product(@PathVariable Integer id) {

        userService.deleteById(id);

    }
    @RequestMapping("/find/{name}")
    public String Product(@PathVariable String name) {
       String s=userService.findUserByName(name).getName()+userService.findUserByName(name).getPassword();

       return s;

    }


}