package JDBC;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class User {
    @Autowired
    private int id_user;
    private String name_user;
    private String email_user;
    private char[] password_user;
    private Date birthday;

    public User(int id_user, String name_user, char[] password_user) {
         this.id_user = id_user;
         this.name_user = name_user;
         this.password_user = password_user;
    }

    public User(int id_user, String name_user, String email_user, char[] password_user) {
        this.id_user = id_user;
        this.name_user = name_user;
        this.email_user = email_user;
        this.password_user = password_user;
    }

    public User(int id_user, String name_user, String email_user, char[] password_user, Date birthday) {
        this.id_user = id_user;
        this.name_user = name_user;
        this.email_user = email_user;
        this.password_user = password_user;
        this.birthday = birthday;
    }

    public User(int id_user, String name_user, char[] password_user, Date birthday) {
        this.id_user = id_user;
        this.name_user = name_user;
        this.password_user = password_user;
        this.birthday = birthday;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public char[] getPassword_user() {
        return password_user;
    }

    public void setPassword_user(char[] password_user) {
        this.password_user = password_user;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}