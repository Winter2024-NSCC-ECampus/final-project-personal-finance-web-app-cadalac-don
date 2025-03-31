package org.example.todo.repository;

import org.example.todo.model.Investments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investments, Long> {

}

