package com.ridehailing.service;

import com.ridehailing.model.Rating;
import com.ridehailing.repository.RatingRepository;

import java.util.List;

public class RatingService {

    private final RatingRepository ratingRepository = new RatingRepository();

    // Add a new rating
    public boolean addRating(Rating rating) {
        try {
            ratingRepository.save(rating);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get rating by ID
    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    // Get all ratings
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    // Update an existing rating
    public boolean updateRating(Rating rating) {
        try {
            ratingRepository.update(rating);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a rating by object
    public boolean deleteRating(Rating rating) {
        try {
            ratingRepository.delete(rating.getRatingId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
