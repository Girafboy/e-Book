package com.example.girafboy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "book",schema = "e-book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookID;

    @Basic
    @Column(name = "name")
    private String bookName;

    @Basic
    @Column
    private String author;

    @Basic
    @Column
    private String coverUrl;

    @Basic
    @Column
    private String ISBN;

    @Basic
    @Column
    private BigDecimal price;

    @Basic
    @Column
    private int stock;

    @Basic
    @Column
    private String description;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @JsonProperty(value = "ISBN")
    public String getISBN() {
        return ISBN;
    }

    @JsonProperty(value = "ISBN")
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_type", joinColumns = {@JoinColumn(name = "book_id")})
    @Column(name = "type")
    private List<String> bookTypes;

    public List<String> getBookTypes() {
        return bookTypes;
    }

    public void setBookTypes(List<String> bookTypes) {
        this.bookTypes = bookTypes;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", bookTypes=" + bookTypes +
                '}';
    }
}
