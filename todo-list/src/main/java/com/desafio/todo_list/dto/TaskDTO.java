package com.desafio.todo_list.dto;

import com.desafio.todo_list.enums.TaskStatus;

/**
 * DTO (Data Transfer Object) para representar uma tarefa na API.
 * Esse DTO é imutável, pois usa um `record`, garantindo segurança dos dados e reduzindo código boilerplate.
 */
public record TaskDTO(String title, String description, TaskStatus status) {


}
