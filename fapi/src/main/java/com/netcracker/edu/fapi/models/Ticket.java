package com.netcracker.edu.fapi.models;

public class Ticket {

    private Long id;
    private int line;
    private int seat;
    private User userId;
    private Seance movieSeance;

    public Ticket(Long id, int line, int seat, User userId, Seance movieSeance) {
        this.id = id;
        this.line = line;
        this.seat = seat;
        this.userId = userId;
        this.movieSeance = movieSeance;
    }

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Seance getMovieSeance() {
        return movieSeance;
    }

    public void setMovieSeance(Seance movieSeance) {
        this.movieSeance = movieSeance;
    }
}
