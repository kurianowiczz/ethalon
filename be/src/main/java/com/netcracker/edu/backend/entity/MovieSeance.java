package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="movieseances")
public class MovieSeance {

    private Long id;
    private Long movieId;
    private String dateTime;
    private double price;

    public MovieSeance(Long id, Long movieId, String dateTime, double price) {
        this.id = id;
        this.movieId = movieId;
        this.dateTime = dateTime;
        this.price = price;
    }

    public MovieSeance() {
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name="movieId")
    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name="dateTime")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieSeance that = (MovieSeance) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(movieId, that.movieId) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, dateTime, price);
    }

    @Override
    public String toString() {
        return "MovieSeances{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", dateTime='" + dateTime + '\'' +
                ", price=" + price +
                '}';
    }
}
