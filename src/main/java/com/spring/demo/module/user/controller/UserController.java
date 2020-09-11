package com.spring.demo.module.user.controller;

import com.spring.demo.module.user.entity.User;
import com.spring.demo.module.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/toRegister")
    public String register(){
        return "anon/register";
    }

    @RequestMapping("/register")
    public String register( User user){
        userService.register(user);
        return "anon/register_success.html";
    }

    @RequestMapping("/isUsernameUsable")
    @ResponseBody   //用ajax 和返回一个user对象
    public HashMap<String, Object> isUsernameUsable(String username){
        Boolean flag=  userService.isUsernameUsable(username);
        HashMap<String,Object> map=new HashMap<>();
        map.put("flag",flag);
        map.put("msg","查询用户是否可有成功");
        return map;
    }
   /* @RequestMapping("/active/{id}")
    @ResponseBody
    public String active(@PathVariable Long id){

       userService.updataEmailstatus(id);
        return "激活成功"+id;
    }*/

    @PostMapping("/login")
    public String login(User user, Model model){

        try{
            Subject subject= SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(user.getUsername(),user.getPassword());
            subject.login(usernamePasswordToken);
            return "index";
        }catch (UnknownAccountException e){
                model.addAttribute("msg","登录失败，用户名不存在");
        }catch (IncorrectCredentialsException e){
                model.addAttribute("msg","登录失败，密码错误");
        }
        return "anon/login";
    }

    @GetMapping("/toLogin")
    public String toLogin(){
        return "anon/login";
    }
}
