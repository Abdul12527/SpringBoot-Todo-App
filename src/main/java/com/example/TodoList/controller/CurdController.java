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
    @PostMapping("/todos")
    public String addTasks(@RequestBody List<Todo> todos){
        if(services.addRecords(todos))return "200 added successfully";
        return "500 Something went Wrong";
    }

    @PutMapping("/todo")
    public String updateStatus(@RequestParam Integer id,@RequestParam Status status){
        if(services.updateStatus(id,status))return "200 updated successfully";
        return "500 some thing wrong";
    }
    @DeleteMapping("/todo")
    public String deleteRecord(@RequestParam Integer id){
        if(services.deleteRecord(id))return "200 deleted successfully";
        return "500 some thing went wrong";
    }
    @DeleteMapping("/todos")
    public String deleteRecords(@RequestParam List<Integer> ids){
        if(services.deleteList(ids))return "200 added successfully";
        return "500 Something went Wrong";
    }




}
