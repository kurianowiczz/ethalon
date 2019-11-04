package com.netcracker.edu.fapi.models;

import java.util.Objects;

public class Journal {

    private Long id;
    private Long userId;
    private Long ticketId;

    public Journal(Long id, Long userId, Long ticketId) {
        this.id = id;
        this.userId = userId;
        this.ticketId = ticketId;
    }

    public Journal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        Journal journal = (Journal) o;
        return Objects.equals(id, journal.id) &&
                Objects.equals(userId, journal.userId) &&
                Objects.equals(ticketId, journal.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, ticketId);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", userId=" + userId +
                ", ticketId=" + ticketId +
                '}';
    }
}
