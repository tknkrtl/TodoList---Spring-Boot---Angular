package com.restangular.todo;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

	@Autowired
	private TodoHardCodedService todoService;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		
		return todoService.getAllTodos();
		
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,
						@PathVariable String id) {
		
		return todoService.getTodo(id);
		
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,
										   @PathVariable String id) {
		
		return todoService.deleteTodo(id);

	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo,
										   @PathVariable String username,
										   @PathVariable String id){
		
		return todoService.updateTodo(todo);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo,
										 @PathVariable String username
										   ){
		return todoService.saveTodo(todo);
	}
	
	@GetMapping("/users/{username}/todos/{id}/change-status")
	public ResponseEntity<Todo> changeStatus(@PathVariable String id){
		
		return todoService.changeStatus(id);
		
	}
	
	
	
	
	
}
