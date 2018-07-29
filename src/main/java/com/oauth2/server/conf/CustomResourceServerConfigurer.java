package com.oauth2.server.conf;

import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class CustomResourceServerConfigurer extends ResourceServerConfigurerAdapter {

	@Override
    public void configure(@NotNull HttpSecurity http) throws Exception {
		 http
         .requestMatchers().antMatchers("/principal/**").and()
         .authorizeRequests().anyRequest().authenticated();
    }
}
