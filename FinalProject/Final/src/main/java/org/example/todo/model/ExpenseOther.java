package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class ExpenseOther {

    @Id
    @GeneratedValue()
    private Long id;
    private int expense;
    private String note;

    public ExpenseOther(Long id, int expense, String note) {
        this.id = id;
        this.expense = expense;
        this.note = note;
    }

    public ExpenseOther() {

    }

    public ExpenseOther(int expense, String note) {
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
