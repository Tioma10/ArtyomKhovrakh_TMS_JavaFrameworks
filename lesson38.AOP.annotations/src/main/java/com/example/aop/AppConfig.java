package com.example.aop;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}