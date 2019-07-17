package com.myong.blog.controller;


import com.myong.blog.dto.AccessTokenDTO;
import com.myong.blog.dto.UserDTO;
import com.myong.blog.provider.GitHubAuthorizeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    GitHubAuthorizeProvider authorizeProvider;
    /***
     * GitHub 授权 回调页面接口
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        System.out.println("code ="+code+"\n state = "+state);
        AccessTokenDTO tokenDTO = new AccessTokenDTO();
        tokenDTO.setClient_id("bbe5cbd333ddc89ed1cc");
        tokenDTO.setClient_secret("3a80ce034b1053750ab242d99be1c6515bf7b56b");
        tokenDTO.setCode(code);
        tokenDTO.setRedirect_uri("http://127.0.0.1:8081/callback");
        tokenDTO.setState(state);
        String accessToken = authorizeProvider.getAccessToken(tokenDTO);
        System.out.println("\naccessToken =\n"+accessToken);
        String access_token = accessToken.split("&")[0].split("=")[1];
        System.out.println("\n access_token =\n"+access_token);
        UserDTO user = authorizeProvider.getUser(access_token);
        System.out.println("\nuser =\n"+user.toString());
        return "index";
    }



}
