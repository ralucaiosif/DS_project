package com.example.easynotes.dto;

public class UserLogedInDto {
    private String username;
    private String email;
    private Integer id;
    private String firstName;
    private String lastName;

    public UserLogedInDto(){

    }

    public UserLogedInDto(String uname, String email){
        username = uname;
        this.email = email;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
