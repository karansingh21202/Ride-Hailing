package com.ridehailing.model;

import javax.persistence.*;

@Entity
@Table(
    name = "ratings",
    indexes = {
        @Index(name = "idx_rating_ride", columnList = "ride_id"),
        @Index(name = "idx_rating_given_by", columnList = "given_by"),
        @Index(name = "idx_rating_given_to", columnList = "given_to")
    }
)
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    // Ride reference
    @OneToOne
    @JoinColumn(
        name = "ride_id",
        nullable = false,
        unique = true,
        foreignKey = @ForeignKey(name = "fk_rating_ride")
    )
    private Ride ride;

    // User who gave the rating
    @ManyToOne
    @JoinColumn(
        name = "given_by",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_rating_given_by")
    )
    private User givenBy;

    // User who received the rating
    @ManyToOne
    @JoinColumn(
        name = "given_to",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_rating_given_to")
    )
    private User givenTo;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "comment", length = 255)
    private String comment;

    /* =====================
       Constructors
       ===================== */
    public Rating() {}

    /* =====================
       Getters & Setters
       ===================== */
    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public User getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(User givenBy) {
        this.givenBy = givenBy;
    }

    public User getGivenTo() {
        return givenTo;
    }

    public void setGivenTo(User givenTo) {
        this.givenTo = givenTo;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
