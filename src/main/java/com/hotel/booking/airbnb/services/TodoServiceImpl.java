package com.hotel.booking.airbnb.services;

import com.hotel.booking.airbnb.dtos.TodoDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class TodoServiceImpl implements ITodoService{

    public RestClient client;
    TodoServiceImpl(RestClient client){
        this.client = client;
    }

    @Override
    public TodoDto getTodo(Long id) {
        TodoDto result = client.get().uri("/todos/{id}",id)
            .retrieve()
            .body(TodoDto.class);

        return result;
    }

    @Override
    public List<TodoDto> getAllTodos() {
        return client.get()
            .uri("todos")
            .retrieve()
            .body(new ParameterizedTypeReference<List<TodoDto>>() {
            });
    }
}
