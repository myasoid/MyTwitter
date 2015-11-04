package com.miv.mytwitter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;

@Configuration
public class ThymeleafSecurityDialectConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

}
