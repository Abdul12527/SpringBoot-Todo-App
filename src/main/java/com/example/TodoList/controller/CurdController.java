package com.example.TodoList.controller;

import com.example.TodoList.Entities.Status;
import com.example.TodoList.Entities.Todo;
import com.example.TodoList.Services.CuredServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CurdController {
    @Autowired
    CuredServices services;

    @PostMapping("/todo")
    public String addTask(@RequestBody Todo task){
        if(services.addRecord(task)) return "200 added successfully";
        return "500 Something went Wrong";
    }
    @PutMapping("/todos")
    public String addTasks(List<Todo> todos){
        if(services.addRecords(todos))return "200 added successfully";
        return "500 Something went Wrong";
    }

    @PutMapping("/todo")
    public String updateStatus(@RequestParam String title,@RequestParam Status status){
        if(services.updateStatus(title,status))return "200 updated successfully";
        return "500 some thing wrong";
    }
    @DeleteMapping("/todo")
    public String deleteRecord(@RequestParam String title){
        if(services.deleteRecord(title))return "200 deleted successfully";
        return "500 some thing went wrong";
    }

    public String deleteRecords(List<String> titles){
        if(services.deleteList(titles))return "200 added successfully";
        return "500 Something went Wrong";
    }




}
