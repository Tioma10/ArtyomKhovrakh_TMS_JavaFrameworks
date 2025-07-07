package com.example.aop;

import com.example.aop.config.AppConfig;
import com.example.aop.service.TaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskService service = context.getBean(TaskService.class);
        service.performTask();
        context.close();
    }
}