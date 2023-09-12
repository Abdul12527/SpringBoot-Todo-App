package com.example.TodoList.Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
    private Integer id;
    private String title;
    private String description;
    private Date date;

    private Status status;

    public Status getStatus() {
        return status;
    }

    public Todo setStatus(Status status) {
        this.status = status;
        return null;
    }

    public Todo(Integer id, String title, String description, String date,Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        try {
            this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.status=status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
