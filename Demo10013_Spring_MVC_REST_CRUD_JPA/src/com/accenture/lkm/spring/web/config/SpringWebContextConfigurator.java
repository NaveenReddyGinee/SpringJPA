package com.accenture.lkm.spring.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.accenture.lkm.web")
public class SpringWebContextConfigurator {
													// here we need to override somthing in the cycle
													// hence using the WebMvcConfigurerAdapter
}

