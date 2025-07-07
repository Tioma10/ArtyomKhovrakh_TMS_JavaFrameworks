package com.example.aop.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}