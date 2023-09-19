package com.example.TodoList.Services;

import com.example.TodoList.Entities.Status;
import com.example.TodoList.Entities.Todo;
import com.example.TodoList.Properties.ITodoDB;
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

    public ArrayList<Todo> recordsWithStarted(Status status){
        ArrayList<Todo> ans=new ArrayList<>();
        List<Todo> all=(List<Todo>) iTodoDB.findAll();
        for(Todo i:all){
            if(i.getStatus().equals(status))ans.add(i);
        }
        return ans;
    }

    public void deletAll(){
        iTodoDB.deleteAll();
    }

    public boolean deleteList(List<Integer> todoTiltels){
        iTodoDB.deleteAllById(todoTiltels);
        return true;
    }
}
