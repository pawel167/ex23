package com.example.demo8;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empl")
public class empl{
    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "fio")
    private String fio;

    @Column(name = "razr")
    private int razr;

    @Column(name = "salary")
    private int salary;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getRazr() {
        return razr;
    }

    public void setRazr(int razr) {
        this.razr = razr;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
