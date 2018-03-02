package com.example.controller;

import com.example.Entity.User;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WK on 2018/3/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping("/gologin")
    public String  gologin(){
        return "user/dologin";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String  dologin(HttpServletRequest request, HttpServletResponse response,Model model)  {
        String username = request.getParameter("username_login");
        String password = request.getParameter("password_login");
        User user = new User(username,password);
        System.out.println(username + "--------" + password);
       if (userService.save(user)){
           model.addAttribute("msg","注册成功");
           return ("redirect:/user/index");
       }else {
            model.addAttribute("msg","注册失败");
            return "user/dologin";
       }

    }
}
