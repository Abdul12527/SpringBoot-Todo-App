package com.example.TodoList.Properties;

import com.example.TodoList.Entities.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

@Configuration
public class Configurations {
    @Bean
    public HashMap<String,Todo> ConfiguringHmASDB(){
        return new HashMap<>();
    }
}
