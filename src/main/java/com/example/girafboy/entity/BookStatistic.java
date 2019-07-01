package com.example.girafboy.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookStatistic implements Serializable {
    private Book book;
    private Integer sales;
    private BigDecimal prices;

    public BookStatistic(Book book, Integer sales) {
        this.book = book;
        this.sales = sales;
        this.prices = book.getPrice().multiply(new BigDecimal(sales));
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(BigDecimal prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "BookStatistic{" +
                "book=" + book +
                ", sales=" + sales +
                ", prices=" + prices +
                '}';
    }
}
