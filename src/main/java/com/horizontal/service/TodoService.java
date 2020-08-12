package com.horizontal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.horizontal.domain.Todo;
import com.horizontal.repository.TodoRepository;

@Service
public class TodoService implements TodoRepository {

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public List<Todo> findAll(Sort sort) {
		return todoRepository.findAll(sort);
	}

	@Override
	public List<Todo> findAllById(Iterable<Long> ids) {
		return todoRepository.findAllById(ids);
	}

	@Override
	public <S extends Todo> List<S> saveAll(Iterable<S> entities) {
		return todoRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		this.todoRepository.flush();
	}

	@Override
	public <S extends Todo> S saveAndFlush(S entity) {
		return this.todoRepository.saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Todo> entities) {
		this.todoRepository.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		this.todoRepository.deleteAllInBatch();
	}

	@Override
	public Todo getOne(Long id) {
		return this.todoRepository.getOne(id);
	}

	@Override
	public <S extends Todo> List<S> findAll(Example<S> example) {
		return this.todoRepository.findAll(example);
	}

	@Override
	public <S extends Todo> List<S> findAll(Example<S> example, Sort sort) {
		return this.todoRepository.findAll(example, sort);
	}

	@Override
	public Page<Todo> findAll(Pageable pageable) {
		return this.todoRepository.findAll(pageable);
	}

	@Override
	public <S extends Todo> S save(S entity) {
		return this.todoRepository.save(entity);
	}

	@Override
	public Optional<Todo> findById(Long id) {
		return this.todoRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return this.todoRepository.existsById(id);
	}

	@Override
	public long count() {
		return this.todoRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		this.todoRepository.deleteById(id);
	}

	@Override
	public void delete(Todo entity) {
		this.todoRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Todo> entities) {
		this.todoRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		this.todoRepository.deleteAll();
	}

	@Override
	public <S extends Todo> Optional<S> findOne(Example<S> example) {
		return this.todoRepository.findOne(example);
	}

	@Override
	public <S extends Todo> Page<S> findAll(Example<S> example, Pageable pageable) {
		return this.todoRepository.findAll(example, pageable);
	}

	@Override
	public <S extends Todo> long count(Example<S> example) {
		return this.todoRepository.count(example);
	}

	@Override
	public <S extends Todo> boolean exists(Example<S> example) {
		return this.todoRepository.exists(example);
	}
	
}
