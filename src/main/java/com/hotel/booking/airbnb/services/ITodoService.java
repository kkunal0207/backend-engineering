package com.hotel.booking.airbnb.services;

import com.hotel.booking.airbnb.dtos.TodoDto;

import java.util.List;

public interface ITodoService {

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();
}
