package com.desafio.todo_list.dto;


import com.desafio.todo_list.enums.TaskStatus;

public record TaskDTO(String title, String description, TaskStatus status) { }
