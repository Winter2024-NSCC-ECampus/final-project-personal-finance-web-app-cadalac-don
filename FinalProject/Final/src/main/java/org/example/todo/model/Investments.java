package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Investments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int investmentTotal;
    private String info;

    public Investments(Long id, int investmentTotal, String info) {
        this.id = id;
        this.investmentTotal = investmentTotal;
        this.info = info;
    }

    public Investments() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInvestmentTotal() {
        return investmentTotal;
    }

    public void setInvestmentTotal(int investmentTotal) {
        this.investmentTotal = investmentTotal;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
