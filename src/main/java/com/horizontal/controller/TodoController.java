package com.horizontal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.horizontal.domain.Todo;
import com.horizontal.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/todos")
@Api(tags = "Recursos do Todo", value="Todo", description = "Todos os recursos para consumo do Todo")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	@ApiOperation(value = "Lista páginada de tarefas")
	public ResponseEntity<Page<Todo>> paged(Pageable pageable) {
		return ResponseEntity.ok(todoService.findAll(pageable));
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "Lista de todas tarefas sem paginação")
	public ResponseEntity<List<Todo>> all() {
		return ResponseEntity.ok(todoService.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiIgnore
	public ResponseEntity<Todo> find(@PathVariable Long id) {
		return ResponseEntity.ok(this.todoService.getOne(id));
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Todo> save(@RequestBody Todo todo) {
		return ResponseEntity.ok(this.todoService.save(todo));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
		todo.setId(id);
		return ResponseEntity.ok(this.todoService.save(todo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Todo> delete(@PathVariable Long id) {
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/horizontal")
	public ResponseEntity<String> getHorizontal() {
		return ResponseEntity.ok().build();
	}
}
