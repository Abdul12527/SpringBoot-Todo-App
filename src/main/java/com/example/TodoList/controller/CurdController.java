package com.example.TodoList.controller;

import com.example.TodoList.Entities.Status;
import com.example.TodoList.Entities.Todo;
import com.example.TodoList.Services.CuredServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CurdController {
    @Autowired
    CuredServices services;

    @PostMapping("/todo/add")
    public String addTask(@RequestBody Todo task){
        if(services.addRecord(task)) return "added successfully";
        return "Something went Wrong";
    }

    @PutMapping("/todo/update/")
    public String updateStatus(@RequestParam String title,@RequestParam Status status){
        if(services.updateStatus(title,status))return "updated sucessfully";
        return "some thing wrong";
    }
    @DeleteMapping("/todo/delete")
    public String deleteRecord(@RequestParam String title){
        if(services.deleteRecord(title))return "deleted successfully";
        return "some thing went wrong";
    }


}
