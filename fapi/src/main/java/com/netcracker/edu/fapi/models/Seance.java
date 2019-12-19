package com.netcracker.edu.fapi.models;

import java.util.Objects;

public class Seance {

    private Long id;
    private Long movieId;
    private String datetime;
    private double price;

    public Seance(Long id, Long movieId, String datetime, double price) {
        this.id = id;
        this.movieId = movieId;
        this.datetime = datetime;
        this.price = price;
    }

    public Seance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String dateTime) {
        this.datetime = datetime;
    }

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
        Seance that = (Seance) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(movieId, that.movieId) &&
                Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, datetime, price);
    }

    @Override
    public String toString() {
        return "MovieSeances{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", datetime='" + datetime + '\'' +
                ", price=" + price +
                '}';
    }
}
