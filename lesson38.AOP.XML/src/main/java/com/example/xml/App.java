package com.example.xml;

import com.example.xml.service.TaskService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TaskService task = context.getBean(TaskService.class);
        task.performTask();
        context.close();
    }
}