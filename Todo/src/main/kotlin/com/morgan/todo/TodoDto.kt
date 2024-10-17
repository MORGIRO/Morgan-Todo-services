package com.morgan.todo

// DTOs are data transfer objects, they help us make requests and responses over
// a network, passing as request body and sending as request response.
data class TodoDto(val title: String, val description: String)