package com.miv.mytwitter.spring.config;

import com.miv.mytwitter.spring.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
        //  .passwordEncoder(getShaPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/signin", "/signup").permitAll()
                .anyRequest().authenticated()
                .and();

        http.formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/j_spring_security_check")
//                .defaultSuccessUrl("/")
             //   .successHandler(new )
                .failureUrl("/signin?error")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll()
                .and();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);

    }

//    @Bean
//    public ShaPasswordEncoder getShaPasswordEncoder() {
//        return new ShaPasswordEncoder();
//    }


//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("profile_page");
//        registry.addViewController("/signup").setViewName("signup_page");
//        registry.addViewController("/signin").setViewName("signin_page");
//        registry.addViewController("/{user}").setViewName("profile_page");
//    }

}