package org.example.todo.repository;

import org.example.todo.model.ExpenseMemo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseMemoRepository extends JpaRepository<ExpenseMemo, Long> {

}

