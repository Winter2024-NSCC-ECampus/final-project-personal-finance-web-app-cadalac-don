package org.example.todo.repository;

import org.example.todo.model.ExpenseIntermittent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseIntermittentRepository extends JpaRepository<ExpenseIntermittent, Long> {

}

