package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BudgetNotes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String futureExpense;
    private int futureCost;

    public BudgetNotes(Long id, String futureExpense, int futureCost) {
        this.id = id;
        this.futureExpense = futureExpense;
        this.futureCost = futureCost;
    }

    public BudgetNotes() {

    }

    public BudgetNotes(String futureExpense, int futureCost) {
        this.futureExpense = futureExpense;
        this.futureCost = futureCost;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFutureExpense() {
        return futureExpense;
    }

    public void setFutureExpense(String futureExpense) {
        this.futureExpense = futureExpense;
    }

    public int getFutureCost() {
        return futureCost;
    }

    public void setFutureCost(int futureCost) {
        this.futureCost = futureCost;
    }
}
