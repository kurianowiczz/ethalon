package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tickets")
public class Tickets {

    private Long id;
    private int line;
    private int seat;
    private Long seanceId;

    public Tickets(Long id, int line, int seat, Long seanceId) {
        this.id = id;
        this.line = line;
        this.seat = seat;
        this.seanceId = seanceId;
    }

    public Tickets() {
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
    @Column(name="line")
    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Basic
    @Column(name="seat")
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Basic
    @Column(name="seanceId")
    public Long getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tickets)) return false;
        Tickets tickets = (Tickets) o;
        return line == tickets.line &&
                seat == tickets.seat &&
                Objects.equals(id, tickets.id) &&
                Objects.equals(seanceId, tickets.seanceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, line, seat, seanceId);
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", line=" + line +
                ", seat=" + seat +
                ", seanceId=" + seanceId +
                '}';
    }
}
