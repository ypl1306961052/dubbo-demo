package com.ypl.oauth.config;
/*
作者：yangp
创建时间：2020/7/24-11:15-2020
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: AuthorizationServerConfig
 * @Package com.ypl.oauth.config
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/24 11:15
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security//客户端校验token访问许可 /oauth/check_key公开
//                .checkTokenAccess("permitAll()")
//                //客户端token调用许可 /oauth/check_token公开
//                .tokenKeyAccess("permitAll()")
//                //表单认证,申请令牌
//                .allowFormAuthenticationForClients()
//                .passwordEncoder(passwordEncoder);
         security
                .tokenKeyAccess("permitAll()")                    //oauth/token_key是公开
                .checkTokenAccess("permitAll()") .allowFormAuthenticationForClients();

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //客户端配置
        clients.inMemory().withClient("client-ypl")
                .secret(passwordEncoder.encode("ypl"))
                .authorizedGrantTypes("authorization_code")
                .scopes("read_user_info")
                .resourceIds("id1").redirectUris("http://127.0.0.1:9090/callback");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    }
}
