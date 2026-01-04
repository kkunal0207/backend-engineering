package com.hotel.booking.airbnb.controllers;

import com.hotel.booking.airbnb.dtos.TodoDto;
import com.hotel.booking.airbnb.services.TodoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    public TodoServiceImpl todoService;
    public ToDoController(TodoServiceImpl todoService){
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public TodoDto getTodos(@PathVariable Long id){
        return todoService.getTodo(id);
    }

    @GetMapping
    public List<TodoDto> getAllTodos(){
        return todoService.getAllTodos();
    }
}
