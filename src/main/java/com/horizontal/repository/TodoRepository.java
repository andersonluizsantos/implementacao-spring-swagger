package com.horizontal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horizontal.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
