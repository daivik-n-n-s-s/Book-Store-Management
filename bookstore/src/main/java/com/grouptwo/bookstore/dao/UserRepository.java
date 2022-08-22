/**
 * 
 */
package com.grouptwo.bookstore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grouptwo.bookstore.model.User;

/**
 * @author HY1916H
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByUserId(int id);
	public void deleteByUserId(int id);
	
	public boolean existsByUserId(int id);
	@Query("SELECT CASE WHEN COUNT(s)>0 THEN TRUE ELSE FALSE END FROM User s WHERE s.userId = ?1")
	public boolean isExistsByUserId(Integer id);
}
