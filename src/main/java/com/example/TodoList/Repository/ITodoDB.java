package com.example.TodoList.Repository;

import com.example.TodoList.Entities.Status;
import com.example.TodoList.Entities.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.TodoList.Entities.Status.*;

@Repository
public interface ITodoDB extends CrudRepository<Todo,Integer> {
    List<Todo> findByTitle(String title);
    List<Todo> findByStatus(Status status);

    List<Todo> findByStatusIsNotAndStatusIsNot(Status status1,Status status2);

}
