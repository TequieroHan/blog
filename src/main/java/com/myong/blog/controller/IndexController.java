package com.myong.blog.controller;

import com.myong.blog.dto.GitHubUserDTO;
import com.myong.blog.mapper.UserMapper;
import com.myong.blog.modul.User;
import com.myong.blog.provider.GitHubAuthorizeProvider;
import com.myong.blog.utils.LOCALMAC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends BaseController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        User user=null;
        try{
            user = userMapper.findUser();
            if (user != null) {
                if (user.getCurrentAddress() != null &&
                        user.getCurrentAddress().equals(LOCALMAC.getLocMac())) {
                    request.getSession().setAttribute("user", user);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }
}
