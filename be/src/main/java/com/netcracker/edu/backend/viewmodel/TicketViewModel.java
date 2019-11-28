package com.netcracker.edu.backend.viewmodel;

public class TicketViewModel {

    private Long id;
    private int line;
    private int seat;
    private int seanceid;
    private int userid;

    public TicketViewModel() {
    }

    public TicketViewModel(Long id, int line, int seat, int seanceid, int userid) {
        this.id = id;
        this.line = line;
        this.seat = seat;
        this.seanceid = seanceid;
        this.userid = userid;
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

    public int getSeanceid() {
        return seanceid;
    }

    public void setSeanceid(int seanceid) {
        this.seanceid = seanceid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
