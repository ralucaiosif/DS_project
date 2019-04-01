package com.example.easynotes.model;

import javax.persistence.*;

@Table(name = "transactions")
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

//    @OneToOne
//    @JoinColumn(name = "id_user")
    @Column(name = "id_user", nullable = false)
    //private User user;
    private Integer useriId;

    @OneToOne
    @JoinColumn(name = "id_card")
    private Card card;

    @Column(name = "sum", nullable = false)
    private Double sum = 0.0;

//    @OneToOne
//    @JoinColumn(name = "id_type")
//    private TransactionType type;
    @Column(name = "id_type", nullable = false)
    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

//    public TransactionType getType() {
//        return type;
//    }
//
//    public void setType(TransactionType type) {
//        this.type = type;
//    }


    public Integer getUseriId() {
        return useriId;
    }

    public void setUseriId(Integer useriId) {
        this.useriId = useriId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
