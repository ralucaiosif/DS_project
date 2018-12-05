package com.example.easynotes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", unique = true, nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @NotBlank
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @NotBlank
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @NotBlank
    @Column(name="role", nullable = false, length = 5)
    private String role;


    public User() {
    }

    public User(@NotBlank String username, @NotBlank String pass, @NotBlank String email, @NotBlank String role) {
        this.username = username;
        this.password = pass;
        this.email = email;
        this.role = role;
    }

    public User(Integer id, @NotBlank String username, @NotBlank String pass, @NotBlank String email, @NotBlank String role) {
        this.id = id;
        this.username = username;
        this.password = pass;
        this.email = email;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
