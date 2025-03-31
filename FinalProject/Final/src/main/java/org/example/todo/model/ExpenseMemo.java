package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class ExpenseMemo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;
    private int amount;
    private String memoLine;

    public ExpenseMemo(Long id, String email, int amount, String memoLine) {
        this.id = id;
        this.email = email;
        this.amount = amount;
        this.memoLine = memoLine;
    }

    public ExpenseMemo() {

    }

    public ExpenseMemo(String email, int amount, String memoLine) {
        this.email = email;
        this.amount = amount;
        this.memoLine = memoLine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMemoLine() {
        return memoLine;
    }

    public void setMemoLine(String memoLine) {
        this.memoLine = memoLine;
    }
}
