package com.morgan.todo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//This  class is a rest controller, basically it handles all the rest requests that
// will be coming to our server. examples.

// a user makes a request, I want to create a new todo
// POST /api/todo/ body { "title": "HI", "description": "i want to eat today" }

// this rest controller will automatically map the request to the function on line 22.
// and create the request as it's a post mapping.


// let's say our user comes and wants to find out what he wrote as a todo with his todoId
// and calls GET /api/todo/adfbe123588902-afih2y2ouahy
// in our case "adfbe123588902-afih2y2ouahyw" is our user id for example,
// the rest controller will directly map the request to line 24 ,

// the same applies for line 37.
@RestController
class TodoController(private val  service: MessageService) {

    @GetMapping("/api/todo/{id}")
    fun findTodo(@PathVariable id: String): ResponseEntity<TodoDto> {
        val savedTodo = service.getTodo(id)
        return ResponseEntity.ok(savedTodo)
    }

    @PostMapping("/api/todo")
    fun post(@RequestBody todo: TodoDto): ResponseEntity<String> {
        val savedTodoId = service.saveTodoItem(todo)
        return ResponseEntity.ok(savedTodoId)
    }

    @GetMapping("/api/todo")
    fun findAllTodos(): ResponseEntity<List<TodoDto>> {
        val allTodos = service.getAllTodos()
        return ResponseEntity.ok().body(allTodos)
    }
}


