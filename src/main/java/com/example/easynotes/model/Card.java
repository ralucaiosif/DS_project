package com.example.easynotes.model;


import javax.persistence.*;
import java.sql.Date;

@Table(name = "cards")
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cinema", unique = true, nullable = false)
    private Integer id;

    @Column(name = "card_number", unique = true, nullable = false)
    private String cardNumber;

    @Column(name = "cvv", nullable = false)
    private int cvv;

    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @Column(name = "exp_date", nullable = false)
    private Date expirationDate;

    @Column(name = "sold", nullable = false)
    private Double sold = 0.0;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_user")
//    private User owner;
    @Column(name="id_user", nullable = false)
    private Integer userId;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }

//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
