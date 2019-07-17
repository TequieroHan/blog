package com.myong.blog.provider;

import com.alibaba.fastjson.JSON;
import com.myong.blog.dto.AccessTokenDTO;
import com.myong.blog.dto.GitHubUserDTO;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * GitHub 授权 提供者
 */
@Component
public class GitHubAuthorizeProvider {
    public static final MediaType MEDIA_TYPE
            = MediaType.get("application/json;charset=utf-8");

    /**
     * 获取Token
     *
     * @return
     */
    public String getAccessToken(AccessTokenDTO tokenDTO) {
        RequestBody body = RequestBody.create(MEDIA_TYPE, JSON.toJSONString(tokenDTO));
        String strBody = postBody("https://github.com/login/oauth/access_token", body);
        return strBody;
    }

    public GitHubUserDTO getUser(String accessToken) {
        String body = getBody("https://api.github.com/user?access_token="+accessToken);
        if (body != null) {
            GitHubUserDTO userDTO = JSON.parseObject(body, GitHubUserDTO.class);
            return userDTO;
        }
        return null;
    }

    private String getBody(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        return getResponse(client, request);
    }

    private String getResponse(OkHttpClient client, Request request) {
        try (Response response = client.newCall(request).execute()) {
            String strBody = response.body().string();
            return strBody;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String postBody(String url, RequestBody body) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return getResponse(client, request);
    }
}
