package org.example.todo.repository;

import org.example.todo.model.IncomeRegular;
import org.example.todo.model.Investments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRegularRepository extends JpaRepository<IncomeRegular, Long> {

}

