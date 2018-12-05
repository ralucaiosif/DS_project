package com.example.easynotes.dto;

public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String username, String password, String role, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public static class Builder {
        private Integer nestedid;
        private String nestedusername;
        private String nestedpassword;
        private String nestedrole;
        private String nestedemail;


        public Builder id(int id) {
            this.nestedid = id;
            return this;
        }

        public Builder username(String username) {
            this.nestedusername = username;
            return this;
        }

        public Builder password(String password) {
            this.nestedpassword = password;
            return this;
        }

        public Builder role(String role) {
            this.nestedrole = role;
            return this;
        }

        public Builder email(String email){
            this.nestedemail = email;
            return this;
        }

        public UserDto create() {
            return new UserDto(nestedid, nestedusername, nestedpassword, nestedrole, nestedemail);
        }

    }
}
