package com.ridehailing.service;

import com.ridehailing.model.Rating;
import com.ridehailing.repository.RatingRepository;

import java.util.List;

public class RatingService {

    private final RatingRepository ratingRepository = new RatingRepository();

    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public void updateRating(Rating rating) {
        ratingRepository.update(rating);
    }

    public void deleteRating(Rating rating) {
        ratingRepository.delete(rating);
    }
}
