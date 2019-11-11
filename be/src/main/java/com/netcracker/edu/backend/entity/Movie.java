package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="movies")
public class Movie {

    private Long id;
    private String name;
    private String type;
    private String description;
    private String image;

    public Movie(Long id, String name, String type, String description, String image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "movie")
    @JsonManagedReference
    private Set<MovieSeance> movieSeances;

    public Movie() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name) &&
                Objects.equals(type, movie.type) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(image, movie.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, description, image);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

