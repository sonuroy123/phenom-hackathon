package com.phenom.flat_mate.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Interests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long interestId;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private House house;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.DATE)
    private Date dateOfInterest;

    private String status; // "accepted", "rejected", "sent for review"

    private String reasonForRejection;

    public Interests() {
    }

    public Interests(House house, User user, Date dateOfInterest, String status, String reasonForRejection, long interestId) {
        this.house = house;
        this.user = user;
        this.dateOfInterest = dateOfInterest;
        this.status = status;
        this.reasonForRejection = reasonForRejection;
        this.interestId = interestId;
    }

    // Getters and Setters
    public long getInterestId() {
        return interestId;
    }

    public void setInterestId(long interestId) {
        this.interestId = interestId;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateOfInterest() {
        return dateOfInterest;
    }

    public void setDateOfInterest(Date dateOfInterest) {
        this.dateOfInterest = dateOfInterest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!status.equals("accepted") && !status.equals("rejected") && !status.equals("sent for review")) {
            throw new IllegalArgumentException("Status must be 'accepted', 'rejected', or 'sent for review'");
        }
        this.status = status;
    }

    public String getReasonForRejection() {
        return reasonForRejection;
    }

    public void setReasonForRejection(String reasonForRejection) {
        this.reasonForRejection = reasonForRejection;
    }

    
}
