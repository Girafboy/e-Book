package com.example.girafboy.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users",schema = "e-book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "userID")
    @GenericGenerator(name = "userID",strategy = "assigned")
    private String userID;

    @Basic
    @Column
    private String password;

    @Basic
    @Column
    private String role;

    @Basic
    @Column
    private String state;

    @Basic
    @Column
    private String email;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonBackReference
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)   return true;
        if(o == null || getClass() != o.getClass()) return false;

        User that = (User)o;

        if(userID.equals(that.userID)) return false;
        if(password != null ? password.equals(that.password) : that.password != null)   return false;
        if(role != null ? role.equals(that.role) : that.role != null)   return false;
        if(state != null ? state.equals(that.state) : that.state != null)   return false;
        if(email != null ? email.equals(that.email) : that.email != null)   return false;

        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
