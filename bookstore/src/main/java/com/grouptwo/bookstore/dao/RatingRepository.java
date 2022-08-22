/**
 * 
 */
package com.grouptwo.bookstore.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grouptwo.bookstore.model.Rating;
import com.grouptwo.bookstore.model.User;

/**
 * @author HY1916H
 *
 */
public interface RatingRepository extends JpaRepository<Rating, Integer>{


	public Optional<Rating> findByRatingId(int id);
	public void deleteByRatingId(int id);
	@Query("SELECT CASE WHEN COUNT(s)>0 THEN TRUE ELSE FALSE END FROM Rating s WHERE s.ratingId = ?1")
	public boolean isExistsByRatingId(Integer id);
	
	//This find By returns the values of Ratings of a specific user
	public List<Rating> findAllByUserForRatings(User userObjectForRatings);
	
	@Transactional
	public void deleteAllByUserForRatings(User userObjectForRatings);
	
	
}
