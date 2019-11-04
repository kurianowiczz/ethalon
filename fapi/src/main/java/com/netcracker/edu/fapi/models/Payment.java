package com.netcracker.edu.fapi.models;

import java.util.Objects;

public class Payment {

    private Long id;
    private int userId;
    private double amount;
    private Long idJournal;

    public Payment(Long id, int userId, double amount, Long idJournal) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.idJournal = idJournal;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getIdJournal() {
        return idJournal;
    }

    public void setIdJournal(Long idJournal) {
        this.idJournal = idJournal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return userId == payment.userId &&
                Double.compare(payment.amount, amount) == 0 &&
                Objects.equals(id, payment.id) &&
                Objects.equals(idJournal, payment.idJournal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, amount, idJournal);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                ", idJournal=" + idJournal +
                '}';
    }
}
