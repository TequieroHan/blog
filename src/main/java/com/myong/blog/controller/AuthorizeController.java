package com.myong.blog.controller;


import com.myong.blog.dto.AccessTokenDTO;
import com.myong.blog.dto.GitHubUserDTO;
import com.myong.blog.provider.GitHubAuthorizeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthorizeController {
    @Autowired
    GitHubAuthorizeProvider authorizeProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    //@Value切入.properties的值
    //语法是@Value("${.properties文件中的名称}")
    @Value("${github.redirect.uri}")
    private String redirectURI;

    /***
     * GitHub 授权 回调页面接口
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO tokenDTO = new AccessTokenDTO();
        tokenDTO.setClient_id(clientId);
        tokenDTO.setClient_secret(clientSecret);
        tokenDTO.setCode(code);
        tokenDTO.setRedirect_uri(redirectURI);
        tokenDTO.setState(state);
        String accessToken = authorizeProvider.getAccessToken(tokenDTO);
        String access_token = accessToken.split("&")[0].split("=")[1];
        GitHubUserDTO user = authorizeProvider.getUser(access_token);
        if (user != null) {
            //.setAttribute("user",user)
            //登陆成功 在html页面获取信息 session.user
            request.getSession().setAttribute("user",user);
            return "redirect:/";//重定向在根路径 ，return"redirect:/xxx重定向
        }else{
            //登陆失败
            return "redirect:/";
        }
    }


}
