package com.example.TodoList.Services;

import com.example.TodoList.Entities.Status;
import com.example.TodoList.Entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
@Service
public class CuredServices {
    @Autowired
    HashMap<String, Todo> hm;

    public boolean addRecord(Todo task){
        try {
            hm.put(task.getTitle(),task);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

    }
    public boolean checkTitel(String title){
        return hm.containsKey(title);
    }
    public boolean updateStatus(String title, Status status){
        if(hm.containsKey(title)){
            Todo temp=hm.get(title);
            temp.setStatus(status);
            hm.put(title,temp);
            return true;
        }
        return false;
    }
    public HashMap<String,Todo> getAll(){
        return hm;
    }
    public Status getStatus(String title){
        if(hm.get(title).getDate().before(new Date())&&!hm.get(title).getStatus().equals(Status.Done))return Status.Delayed;
        return hm.get(title).getStatus();
    }

    public boolean deleteRecord(String title){
        if(hm.containsKey(title)){
            hm.remove(title);
            return true;
        }
        return false;
    }

    public ArrayList<Todo> recordsWithStarted(Status status){
        ArrayList<Todo> ans=new ArrayList<>();
        for(var i:hm.keySet()){
            if(hm.get(i).getStatus().equals(status))ans.add(hm.get(i));
        }
        return ans;
    }

    public void deletAll(){
        hm=new HashMap<>();
    }
}
