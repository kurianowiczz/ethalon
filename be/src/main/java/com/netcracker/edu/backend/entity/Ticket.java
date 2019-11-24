package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int line;
    private int seat;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "seanceid")
    private Seance movieSeance;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    private User userid;

    public Ticket() {
    }

    public Ticket(int line, int seat, Seance movieSeance, User userid) {
        this.line = line;
        this.seat = seat;
        this.movieSeance = movieSeance;
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "line")
    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Basic
    @Column(name = "seat")
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Basic
    @Column(name = "movieSeance")
    public Seance getMovieSeance() {
        return movieSeance;
    }

    public void setMovieSeance(Seance movieSeance) {
        this.movieSeance = movieSeance;
    }

    @Basic
    @Column(name = "userid")
    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }
}
