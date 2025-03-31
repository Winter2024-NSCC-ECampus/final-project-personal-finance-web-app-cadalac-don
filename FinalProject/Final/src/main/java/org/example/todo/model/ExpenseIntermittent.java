package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class ExpenseIntermittent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int expense;
    private String note;

    public ExpenseIntermittent(Long id, int expense, String note) {
        this.id = id;
        this.expense = expense;
        this.note = note;
    }

    public ExpenseIntermittent() {

    }

    public ExpenseIntermittent(int expense, String note) {
        this.expense = expense;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
