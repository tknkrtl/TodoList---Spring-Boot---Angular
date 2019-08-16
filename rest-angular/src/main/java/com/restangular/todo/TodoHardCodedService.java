package com.restangular.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TodoHardCodedService {
	
	@Autowired
	private TodoRepo todoRepo;
	
	@Transactional
	public List<Todo> getAllTodos() {
		
		return todoRepo.findAll();
		
	}
	
	@Transactional
	public Todo getTodo(String id) {

		return todoRepo.findById(id).orElse(null);
	
	}
	
	@Transactional
	public ResponseEntity<Void> deleteTodo(String id) {

		Todo todo = todoRepo.findById(id).orElse(null);
		if(todo!=null) {
			todoRepo.deleteById(id);
			return ResponseEntity.noContent().build();
		}
			return ResponseEntity.notFound().build();
		
	}
	@Transactional
	public ResponseEntity<Todo> updateTodo(Todo todo){

		todoRepo.save(todo);
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
		
	}
	
	@Transactional
	public ResponseEntity<Todo> saveTodo(Todo todo){
		
		Todo tempTodo = new Todo();
		
		tempTodo.setDescription(todo.getDescription());
		tempTodo.setDone(todo.isDone());
		tempTodo.setTargetDate(todo.getTargetDate());
		tempTodo.setUsername(todo.getUsername());
		
		todoRepo.insert(tempTodo);
		
		return new ResponseEntity<Todo>(tempTodo,HttpStatus.OK);
	}
	@Transactional
	public ResponseEntity<Todo> changeStatus(String id) {
		
		Todo todo = todoRepo.findById(id).orElse(null);
		
		if(todo.isDone()) {
			todo.setDone(false);
		}
		else
			todo.setDone(true);
		
		todoRepo.save(todo);
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	

	
//	private static List<Todo> todos= new ArrayList<Todo>();
//	private static long idCounter = 0;
//	
//	static {
//		todos.add(new Todo(++idCounter,"in28minutes","Learn To Dance",new Date(),false));
//		todos.add(new Todo(++idCounter,"in28minutes","Learn About Microservices",new Date(),false));
//		todos.add(new Todo(++idCounter,"in28minutes","Learn About Angular",new Date(),true));
//	}
//	
//	public Todo save(Todo todo) {
//		
//		if(todo.getId()==-1) {
//			todo.setId(++idCounter);
//			todos.add(todo);
//		}
//		else {
//			deleteById(todo.getId());
//			todos.add(todo);
//		}
//		return todo;
//	}
//	
//	public List<Todo> findAll() {
//		return todos;
//	}
//	public Todo deleteById(long id) {
//		Todo todo = findById(id);
//
//		if(todo==null) return null;
//		
//		if(todos.remove(todo))
//		return todo;
//		
//		return null;
//	}
//	public Todo findById(long id) {
//		
//		for(Todo todo:todos)
//			if(todo.getId()==id) {
//				return todo;
//			}
//		return null;
//	}
//	
//	
}
