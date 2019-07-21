package com.benbasty.fungifs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class TemplateConfig {

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
            final SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
            springTemplateEngine.addTemplateResolver(templateResolver());
            return springTemplateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
            final ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
            thymeleafViewResolver.setTemplateEngine(templateEngine());
            thymeleafViewResolver.setOrder(1);
            return thymeleafViewResolver;
        }

    }
