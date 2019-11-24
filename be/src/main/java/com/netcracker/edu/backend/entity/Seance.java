package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="seances")
public class Seance {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datetime;
    private double price;
    private Long movieid;

//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "movieid")
//    private Movie movie;

    public Seance() {
    }

    public Seance(String datetime, double price, Long movieid) {
        this.datetime = datetime;
        this.price = price;
        this.movieid = movieid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datetime")
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "movieid")
    public Long getMovieid() {
        return movieid;
    }

    public void setMovieid(Long movieid) {
        this.movieid = movieid;
    }
}
