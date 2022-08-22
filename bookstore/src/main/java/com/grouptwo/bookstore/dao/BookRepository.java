/**
 * 
 */
package com.grouptwo.bookstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grouptwo.bookstore.model.Book;

/**
 * @author HY1916H
 *
 */
public interface BookRepository extends JpaRepository<Book, Integer>{


	public Optional<Book> findByBookId(int id);
	public void deleteByBookId(int id);
	
//	@Query("SELECT p FROM Book p WHERE p.bookTitle = ?1")
	public Optional<Book> findByBookTitle(String titleOfASpecificBook);
	
	@Query("SELECT CASE WHEN COUNT(s)>0 THEN TRUE ELSE FALSE END FROM Book s WHERE s.bookId = ?1")
	public boolean isExistsByBookId(Integer id);
	
}
