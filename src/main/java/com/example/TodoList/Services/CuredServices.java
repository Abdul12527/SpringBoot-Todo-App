package com.example.TodoList.Services;

import com.example.TodoList.Entities.Status;
import com.example.TodoList.Entities.Todo;
import com.example.TodoList.Repository.ITodoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CuredServices {
    @Autowired
    ITodoDB iTodoDB;

    public boolean addRecord(Todo task){
        iTodoDB.save(task);
        return true;
    }
    public boolean addRecords(List<Todo> todos){
        iTodoDB.saveAll(todos);
        return true;
    }

    public boolean updateStatus(Integer id, Status status){
        if(!iTodoDB.existsById(id))return false;
        Optional<Todo> temp=iTodoDB.findById(id);
        Todo temp2=temp.get();
        temp2.setStatus(status);
        iTodoDB.save(temp2);
        return true;

    }
    public List<Todo> getAll(){
        return (List<Todo>) iTodoDB.findAll();
    }
    public Status getStatus(Integer id){
        return iTodoDB.findById(id).get().getStatus();
    }

    public boolean deleteRecord(Integer id){
        if(!iTodoDB.existsById(id))return false;
        iTodoDB.deleteById(id);
        return true;
    }

    public List<Todo> recordsWithStarted(Status status){
        return iTodoDB.findByStatus(Status.Started);
    }

    public void deletAll(){
        iTodoDB.deleteAll();
    }

    public boolean deleteList(List<Integer> todoTiltels){
        iTodoDB.deleteAllById(todoTiltels);
        return true;
    }
    public List<Todo> getByTitle(String title){
        return iTodoDB.findByTitle(title);
    }

    public List<Todo> findAllNonStartedOrDoneTask(){
        return iTodoDB.findByStatusIsNotAndStatusIsNot(Status.Done,Status.Started);
    }
}
