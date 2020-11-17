package com.isa.morswiny.model;



import javax.persistence.*;

@Entity
@Table(name="url")
public class EventURL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventUrlId;
    private String www;
    private String tickets;

    @OneToOne (mappedBy = "urls")
    private Event event;

    public EventURL(String www, String tickets) {
        this.www = www;
        this.tickets = tickets;
    }

    public EventURL() {

    }

    @Override
    public String toString() {
        return "EventURL " +
                "www = " + www ;

    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public void setEvent (Event event) {
        this.event = event;
    }
}
