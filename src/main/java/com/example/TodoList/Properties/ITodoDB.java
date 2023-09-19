package com.example.TodoList.Properties;

import com.example.TodoList.Entities.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoDB extends CrudRepository<Todo,Integer> {
}
