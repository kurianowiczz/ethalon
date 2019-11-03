<<<<<<< HEAD
package com.netcracker.edu.fapi.models;

import java.util.Objects;

=======
package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="movies")
>>>>>>> 1d503208be752fba7dd47b42b8582f9cc7e58c73
public class Movie {

    private Long id;
    private String name;
    private String type;
    private String description;

    public Movie(Long id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Movie() {

    }

<<<<<<< HEAD
=======
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 1d503208be752fba7dd47b42b8582f9cc7e58c73
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
=======
    @Basic
    @Column(name="name")
>>>>>>> 1d503208be752fba7dd47b42b8582f9cc7e58c73
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
=======
    @Basic
    @Column(name="type")
>>>>>>> 1d503208be752fba7dd47b42b8582f9cc7e58c73
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

<<<<<<< HEAD
=======
    @Basic
    @Column(name="description")
>>>>>>> 1d503208be752fba7dd47b42b8582f9cc7e58c73
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name) &&
                Objects.equals(type, movie.type) &&
                Objects.equals(description, movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, description);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
