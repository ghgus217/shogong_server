package com.shogong.sgs.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import com.google.common.collect.ImmutableList;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
    
    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        //security.httpBasic().disable();
        security.cors().and();
        security.cors().configurationSource(new CorsConfigurationSource(){
        
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.addAllowedOrigin("*");
            config.setAllowCredentials(true);
            return config;
            }
        });
        security.csrf().disable();
    }



    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowCredentials(true);

    }
    
}