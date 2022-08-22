/**
 * 
 */
package com.grouptwo.bookstore.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grouptwo.bookstore.dao.BookRepository;
import com.grouptwo.bookstore.model.Book;

/**
 * @author HY1916H
 *
 */
@SpringBootTest
class BookRepoTest {

	
	@Autowired
	private BookRepository bookRepoTest;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Setting Up..!!");
	}

	@Test
	void isExistsByBookId() {
		Book bookForTest = new Book(21,"Rowling", "Harry Potter" , "Adventure" , 100, 900);
		Book addedBook = bookRepoTest.save(bookForTest);
		int bookIdAutoGenerated = addedBook.getBookId();
		
		Boolean actualResult = bookRepoTest.isExistsByBookId(bookIdAutoGenerated);
		assertThat(actualResult).isTrue();
		
	}
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Tearing Down");
		bookRepoTest.deleteAll();
	}

	

}