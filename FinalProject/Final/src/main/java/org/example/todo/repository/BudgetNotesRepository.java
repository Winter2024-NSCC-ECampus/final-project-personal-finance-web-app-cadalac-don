package org.example.todo.repository;

import org.example.todo.model.BudgetNotes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetNotesRepository extends JpaRepository<BudgetNotes, Long> {

}

