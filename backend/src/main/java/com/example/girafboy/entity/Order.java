package com.example.girafboy.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders", schema = "e-book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Order {

    @Transient
    @JsonProperty(defaultValue = "0")
    private BigDecimal totPrice;

    public BigDecimal getTotPrice() {
        totPrice = new BigDecimal(0);
        if(orderItems == null)
            return totPrice;
        for(OrderItem item:orderItems)
            totPrice = totPrice.add(item.getBook().getPrice().multiply(new BigDecimal(item.getAmount().toString())));
        return totPrice;
    }

    public void setTotPrice(BigDecimal totPrice) {
        this.totPrice = totPrice;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;

    @Basic
    @Column
    private Date date;

    @Basic
    @Column
    private String state;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "totPrice=" + totPrice +
                ", orderID=" + orderID +
                ", date=" + date +
                ", state='" + state + '\'' +
                ", user=" + user +
                ", orderItems=" + orderItems +
                '}';
    }
}
