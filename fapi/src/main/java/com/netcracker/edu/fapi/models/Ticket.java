package com.netcracker.edu.fapi.models;

import java.util.Objects;

public class Ticket {

    private Long id;
    private int line;
    private int seat;
    private Long seanceId;

    public Ticket(Long id, int line, int seat, Long seanceId) {
        this.id = id;
        this.line = line;
        this.seat = seat;
        this.seanceId = seanceId;
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

    public Long getSeanceId() {
        return seanceId;
    }

    public void setSeanceId(Long seanceId) {
        this.seanceId = seanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket tickets = (Ticket) o;
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
