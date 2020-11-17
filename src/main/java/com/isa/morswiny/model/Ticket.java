package com.isa.morswiny.model;


import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    public Integer getTicketId() {
        return ticketId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketId;
    private String type;
    private String startTicket;
    private String endTicket;
    @OneToOne (mappedBy = "tickets")
    private Event event;

    public Ticket(String type, String startTicket, String endTicket) {
        this.type = type;
        this.startTicket = startTicket;
        this.endTicket = endTicket;
    }

    public Ticket() {

    }

    @Override
    public String toString() {
        return "Ticket " +
                "type = " + type +
                ", start Ticket = " + startTicket +
                ", end Ticket = " + endTicket;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTicket() {
        return startTicket;
    }

    public void setStartTicket(String startTicket) {
        this.startTicket = startTicket;
    }

    public String getEndTicket() {
        return endTicket;
    }

    public void setEndTicket(String endTicket) {
        this.endTicket = endTicket;
    }
}
