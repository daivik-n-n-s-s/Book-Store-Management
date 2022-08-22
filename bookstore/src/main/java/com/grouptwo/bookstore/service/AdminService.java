/**
 * 
 */
package com.grouptwo.bookstore.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.bookstore.dao.AdminRepository;
import com.grouptwo.bookstore.dao.BookRepository;
import com.grouptwo.bookstore.dao.OrderRepository;
import com.grouptwo.bookstore.dao.RatingRepository;
import com.grouptwo.bookstore.dao.UserRepository;
import com.grouptwo.bookstore.exceptions.BookExceptions;
import com.grouptwo.bookstore.exceptions.OrderExceptions;

import com.grouptwo.bookstore.exceptions.UserExceptions;
import com.grouptwo.bookstore.model.Admin;
import com.grouptwo.bookstore.model.Book;
import com.grouptwo.bookstore.model.Order;
import com.grouptwo.bookstore.model.Rating;
import com.grouptwo.bookstore.model.User;

/**
 * @author HY1916H
 *
 */
@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	UserRepository userRepo;


	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	RatingRepository ratingRepo;
	//*******************USER RELATED: CREATE, UPDATE, DELETE AND READ ******************************
	//*******CREATE USER********
	public User createUserByAdmin(int idOfAdmin, User userCreatedByAdmin) {
		// TODO Auto-generated method stub
		System.out.println("Creating a User....");
		Admin adminToBeAssigned = adminRepo.findByAdminId(idOfAdmin).get();
		User tempCreatedUser = userRepo.save(userCreatedByAdmin);
		User finalCreatedUser = userRepo.findByUserId(tempCreatedUser.getUserId()).get();
		finalCreatedUser.setAdminForUsers(adminToBeAssigned);
		
		return userRepo.save(userCreatedByAdmin);
	}

	//*******READ ALL USER*******
	public Collection<User> getAllUsersByAdmin() {
		// TODO Auto-generated method stub
		System.out.println("Returning all the users..");
		return userRepo.findAll();
	}
	
	//********READ A SPECIFIC USER****
	public User getUserByUserId(int idOfASpecificUser) {
		// TODO Auto-generated method stub
		System.out.println("Finding the user....");
		try
		{
		 if (!userRepo.isExistsByUserId(idOfASpecificUser)) {
		      throw new UserExceptions();
		    }
		}
		 catch(UserExceptions e)
		 {
			 e.userNotFoundException();
		 }
		
		return userRepo.findByUserId(idOfASpecificUser).get();
	}

	//*********UPDATING A SPECIFIC USER********
	public User updateUserByAdmin(User latestUserDetails) {
		// TODO Auto-generated method stub
		try
		{
		 if (!userRepo.isExistsByUserId(latestUserDetails.getUserId())) {
		      throw new UserExceptions();
		    }
		}
		 catch(UserExceptions e)
		 {
			 e.userNotFoundException();
		 }
		
		System.out.println("Updating the user...");
		User userUpdatedByAdmin = userRepo.findByUserId(latestUserDetails.getUserId()).get();
		
		userUpdatedByAdmin.setUserName(latestUserDetails.getUserName());
		userUpdatedByAdmin.setUserEmail(latestUserDetails.getUserEmail());
		userUpdatedByAdmin.setUserContact(latestUserDetails.getUserContact());
		userUpdatedByAdmin.setUserAddress(latestUserDetails.getUserAddress());
		userUpdatedByAdmin.setUserPassword(latestUserDetails.getUserPassword());
		return userRepo.save(userUpdatedByAdmin);
	}
	

	
	//**********DELETING A SPECIFIC USER*******
	public void deleteUserByAdmin(int idOfASpecificUser) {
		// TODO Auto-generated method stub
		try
		{
		 if (!userRepo.isExistsByUserId(idOfASpecificUser)) {
		      throw new UserExceptions();
		    }
		}
		 catch(UserExceptions e)
		 {
			 e.userNotFoundException();
		 }
		System.out.println("Deleting a User....");
		userRepo.deleteByUserId(idOfASpecificUser);
		
	}

	
	
	
	//*******************BOOK RELATED: CREATE, UPDATE, DELETE AND READ ******************************
	//*******CREATE BOOK********
		public Book createBookByAdmin(int idOfAdmin, Book bookCreatedByAdmin) {
			// TODO Auto-generated method stub
			System.out.println("Creating a Book....");
			
			Admin adminToBeAssigned = adminRepo.findByAdminId(idOfAdmin).get();
			Book tempCreatedBook = bookRepo.save(bookCreatedByAdmin);
			Book finalCreatedBook = bookRepo.findByBookId(tempCreatedBook.getBookId()).get();
			finalCreatedBook.setAdminForBooks(adminToBeAssigned);
			return bookRepo.save(finalCreatedBook);
			
		}

		//*******READ ALL BOOKS*******
		public Collection<Book> getAllBooksByAdmin() {
			// TODO Auto-generated method stub
			System.out.println("Returning all the Books..");
			return bookRepo.findAll();
		}
		
		//********READ A SPECIFIC BOOK****
		public Book getBookByBookId(int idOfASpecificBook) {
			// TODO Auto-generated method stub
			System.out.println("Finding the Book....");
			try
			{
			 if (!bookRepo.isExistsByBookId(idOfASpecificBook)) {
			      throw new BookExceptions();
			    }
			}
			 catch(BookExceptions e)
			 {
				 e.bookNotFoundException();
			 }
			return bookRepo.findByBookId(idOfASpecificBook).get();
		}
		
		//***************SEARCH A SPECIFIC BOOK************
		public Book getBookByBookTitle(String titleOfASpecificBook) {
			// TODO Auto-generated method stub
			return bookRepo.findByBookTitle(titleOfASpecificBook).get();
		}

		

		//*********UPDATING A SPECIFIC BOOK*****
		public Book updateBookByAdmin(Book latestBookDetails) {
			// TODO Auto-generated method stub
			try
			{
			 if (!bookRepo.isExistsByBookId(latestBookDetails.getBookId())) {
			      throw new BookExceptions();
			    }
			}
			 catch(BookExceptions e)
			 {
				 e.bookNotFoundException();
			 }
			System.out.println("Updating the Book...");
			Book bookUpdatedByAdmin = bookRepo.findByBookId(latestBookDetails.getBookId()).get();
			bookUpdatedByAdmin.setBookAuthor(latestBookDetails.getBookAuthor());
			bookUpdatedByAdmin.setBookGenre(latestBookDetails.getBookGenre());
			bookUpdatedByAdmin.setBookNumberOfInstances(latestBookDetails.getBookNumberOfInstances());
			bookUpdatedByAdmin.setBookPrice(latestBookDetails.getBookPrice());
			bookUpdatedByAdmin.setBookTitle(latestBookDetails.getBookTitle());
			return bookRepo.save(bookUpdatedByAdmin);
		}
		
		//**********DELETING A SPECIFIC BOOK*******
		public void deleteBookByAdmin(int idOfASpecificBook) {
			// TODO Auto-generated method stub
			try
			{
			 if (!bookRepo.isExistsByBookId(idOfASpecificBook)) {
			      throw new BookExceptions();
			    }
			}
			 catch(BookExceptions e)
			 {
				 e.bookNotFoundException();
			 }
			System.out.println("Deleting a Book....");
			bookRepo.deleteByBookId(idOfASpecificBook);
			
		}

		
		
		//*******************RATING RELATED: VIEW RATINGS ******************************
		//*******VIEW RATINGS*********
		
		public Collection<Rating> getAllRatingsByAdmin() {
			// TODO Auto-generated method stub
			System.out.println("Returning all the ratings....");
			return ratingRepo.findAll();
		}
		
		
		//*******************ORDER RELATED: VIEW, UPDATE, DELETE THE ORDER ******************************
		//*******VIEW ORDERS*********
		public Collection<Order> getAllOrdersByAdmin() {
			// TODO Auto-generated method stub
			System.out.println("Returning all the Orders..");
			return orderRepo.findAll();
		}
		
		//********READ A SPECIFIC ORDER****
		public Order getOrderByOrderId(int idOfAdmin, int idOfASpecificOrder) {
			// TODO Auto-generated method stub
			System.out.println("Finding the Order....");
			try
			{
			 if (!orderRepo.isExistsByOrderId(idOfASpecificOrder)) {
			      throw new OrderExceptions();
			    }
			}
			 catch(OrderExceptions e)
			 {
				 e.orderNotFoundException();
			 }
			
			Order tempOrder = orderRepo.findByOrderId(idOfASpecificOrder).get();
			Admin tempAdmin = adminRepo.findByAdminId(idOfAdmin).get();
			tempOrder.setAdminForOrders(tempAdmin);
			Order finalOrder = orderRepo.save(tempOrder);
			
			return finalOrder;
		}

		//*********UPDATING A SPECIFIC ORDER -- ONLY UPDATING THE STATUS, NO RIGHTS TO CHANGE THE OTHER DETAILS*****
		public Order updateOrderByAdmin(int idOfAdmin, Order latestOrderDetails) {
			// TODO Auto-generated method stub
			try
			{
			 if (!orderRepo.isExistsByOrderId(latestOrderDetails.getOrderId())) {
			      throw new OrderExceptions();
			    }
			}
			 catch(OrderExceptions e)
			 {
				 e.orderNotFoundException();
			 }
			System.out.println("Updating the Order...");
			Admin tempAdmin = adminRepo.findByAdminId(idOfAdmin).get();
			Order orderUpdatedByAdmin = orderRepo.findByOrderId(latestOrderDetails.getOrderId()).get();
			orderUpdatedByAdmin.setOrderStatus(latestOrderDetails.getOrderStatus());
			orderUpdatedByAdmin.setAdminForOrders(tempAdmin);
			return orderRepo.save(orderUpdatedByAdmin);
		}
		
		
//		//**********DELETING A SPECIFIC ORDER*******
//		public void deleteOrderByAdmin(int idOfASpecificOrder) {
//			// TODO Auto-generated method stub
//			try
//			{
//			 if (!orderRepo.isExistsByOrderId(idOfASpecificOrder)) {
//			      throw new OrderExceptions();
//			    }
//			}
//			 catch(OrderExceptions e)
//			 {
//				 e.orderNotFoundException();
//			 }
//			orderRepo.deleteById(idOfASpecificOrder);
//			
//		}

		
		
		
		
	
	
	
	

}
