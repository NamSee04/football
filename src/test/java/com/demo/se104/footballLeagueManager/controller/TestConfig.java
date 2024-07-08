package com.demo.se104.footballLeagueManager.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

@Configuration
public class TestConfig {

    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver() {
            @Override
            public View resolveViewName(String viewName, Locale locale) throws Exception {
                InternalResourceView view = (InternalResourceView) super.resolveViewName(viewName, locale);
                view.setPreventDispatchLoop(false); // Bỏ qua lỗi vòng lặp
                return view;
            }
        };
    }
}
