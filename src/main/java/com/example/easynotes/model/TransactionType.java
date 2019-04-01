package com.example.easynotes.model;


import javax.persistence.*;

@Table(name = "types")
@Entity
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "type_name", nullable = false, length = 45)
    private String name;

    @Column(name = "transaction", nullable = false, length = 45)
    private String transaction;

    @Column(name = "predef", nullable = false)
    private int predefined = 0; // 0 / 1

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public int getPredefined() {
        return predefined;
    }

    public void setPredefined(int predefined) {
        this.predefined = predefined;
    }
}
