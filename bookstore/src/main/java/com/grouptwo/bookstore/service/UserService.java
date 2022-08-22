/**
 * 
 */
package com.grouptwo.bookstore.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.grouptwo.bookstore.dao.BookRepository;
import com.grouptwo.bookstore.dao.OrderRepository;
import com.grouptwo.bookstore.dao.RatingRepository;
import com.grouptwo.bookstore.dao.UserRepository;
import com.grouptwo.bookstore.exceptions.OrderExceptions;
import com.grouptwo.bookstore.exceptions.RatingExceptions;
import com.grouptwo.bookstore.exceptions.UserExceptions;
import com.grouptwo.bookstore.model.Book;
import com.grouptwo.bookstore.model.Order;
import com.grouptwo.bookstore.model.Rating;
import com.grouptwo.bookstore.model.User;

/**
 * @author HY1916H
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	RatingRepository ratingRepo;
	
	//*******************ORDER RELATED: CREATE, DELETE AND READ ******************************
	//*******VIEW ORDERS********

	public List<Order> getAllOrdersOfUser(int idOfUser) {
		// TODO Auto-generated method stub
		User userObjectForOrders = userRepo.findByUserId(idOfUser).get();
		return orderRepo.findAllByUserForOrders(userObjectForOrders);
	}

	public Order getSpecificOrderByUser(int idOfUser, int idOfOrder) {
		// TODO Auto-generated method stub
		return orderRepo.findByOrderId(idOfOrder).get();
	}

	//*******CREATE ORDERS********
	public Order createOrderByUser(int idOfUser, Order orderCreatedByUser) {
		// TODO Auto-generated method stub
		 Order orderCreatedByUserFinal = userRepo.findByUserId(idOfUser).map(userTemp -> {
		     orderCreatedByUser.setUserForOrders(userTemp);
		     return orderRepo.save(orderCreatedByUser);
			}).get();
		 return orderCreatedByUserFinal;
	}
	

	public Order addBooksToOrderByUser(int idOfUser, int idOfOrder, Book bookAddedToOrder) {
		// TODO Auto-generated method stub
		Order tempOrderObject = orderRepo.findByOrderId(idOfOrder).get();
		Book tempBookObject = bookRepo.findByBookId(bookAddedToOrder.getBookId()).get();
		tempBookObject.setOrdersForBooks(tempOrderObject);
		return orderRepo.save(tempOrderObject);
	}
	
	
	
/*
	//*******DELETE A SPECIFIC ORDER********
	public void deleteOrderByUser(int idOfUser, int idOfASpecificOrder) {
		// TODO Auto-generated method stub
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
//		Order orderObject = orderRepo.findByOrderId(idOfASpecificOrder).get();
//		User userObjectFromOrder = orderObject.getUserForOrders();
//		User userObjectAccessingOrder = userRepo.findByUserId(idOfUser).get();
//		if(userObjectAccessingOrder.equals(userObjectFromOrder))
//		{
		
		orderRepo.deleteByOrderId(idOfASpecificOrder);
//		}
//		else
//		{
//			try
//			{
//				throw new OrderExceptions();
//			}
//			catch(OrderExceptions e)
//			{
//				e.userDoNotHaveAcess();
//			}
//			
//		}
	}

	
	//********DELETE ALL ORDERS SPECIFIC TO USER*****
	
	public void deleteAllOrdersOfUser(int idOfUser) {
		// TODO Auto-generated method stub
		try
		{
		 if (!userRepo.isExistsByUserId(idOfUser)) {
		      throw new OrderExceptions();
		    }
		}
		 catch(OrderExceptions e)
		 {
			 e.orderNotFoundException();
		 }
		User userObjectForOrders = userRepo.findByUserId(idOfUser).get();
		orderRepo.deleteAllByUserForOrders(userObjectForOrders);
	}
	
	*/
	
	
	
	//**************UPDATE ORDER STATUS************
	
	
	public Order updateOrderStatusByUser(int idOfUser, Order orderStatusToBeChanged) {
		// TODO Auto-generated method stub
		try
		{
		 if (!orderRepo.isExistsByOrderId(orderStatusToBeChanged.getOrderId())) {
		      throw new OrderExceptions();
		    }
		}
		 catch(OrderExceptions e)
		 {
			 e.orderNotFoundException();
		 }
		Order orderUpdatedByUser = orderRepo.findByOrderId(orderStatusToBeChanged.getOrderId()).get();
		orderUpdatedByUser.setOrderStatus(orderStatusToBeChanged.getOrderStatus());;

		return orderRepo.save(orderUpdatedByUser);
	}
	
	
	
	
	
	
	
	
	//*******************RATING RELATED: CREATE, UPDATE, DELETE AND READ ******************************
	//*******VIEW RATINGS********
	public List<Rating> getAllRatingsOfUser(int idOfUser) {
		// TODO Auto-generated method stub
		User userObjectForRatings = userRepo.findByUserId(idOfUser).get();
		return ratingRepo.findAllByUserForRatings(userObjectForRatings);
	}
	
	//********CREATE RATINGS******

	public Rating createRatingByUser(int idOfUser, int idOfBook, Rating ratingCreatedByUser) {
		// TODO Auto-generated method stub
	
		Rating ratingCreatedByUserFinal = userRepo.findByUserId(idOfUser).map(userTemp -> {
		     ratingCreatedByUser.setUserForRatings(userTemp);
		     return ratingRepo.save(ratingCreatedByUser);
			}).get();
		Book tempBookToAddRating = bookRepo.findByBookId(idOfBook).get();
		ratingCreatedByUserFinal.setBookForRatings(tempBookToAddRating);
		 return ratingRepo.save(ratingCreatedByUserFinal);
	}


	
	

	
	//**********UPDATE RATINGS********
	
	public Rating updateRatingByUser(int idOfUser, int idOfASpecificRating, Rating latestRatingDetails) {
		// TODO Auto-generated method stub
		try
		{
		 if (!ratingRepo.isExistsByRatingId(idOfASpecificRating)) {
		      throw new RatingExceptions();
		    }
		}
		 catch(RatingExceptions e)
		 {
			 e.ratingNotFoundException();
		 }
		Rating ratingUpdatedByAdmin = ratingRepo.findByRatingId(idOfASpecificRating).get();
		ratingUpdatedByAdmin.setRatingValue(latestRatingDetails.getRatingValue());

		return ratingRepo.save(ratingUpdatedByAdmin);
	}
	
	//**********DELETE A SPECIFIC RATING******
	public void deleteRatingByUser(int idOfASpecificRating) {
		// TODO Auto-generated method stub
		try
		{
		 if (!ratingRepo.isExistsByRatingId(idOfASpecificRating)) {
		      throw new RatingExceptions();
		    }
		}
		 catch(RatingExceptions e)
		 {
			 e.ratingNotFoundException();
		 }
		ratingRepo.deleteByRatingId(idOfASpecificRating);;
	}
	
	
	//*******DELETE ALL RATINGS OF A USER*******
	public void deleteAllRatingsOfUser(int idOfUser) {
		// TODO Auto-generated method stub
		try
		{
		 if (!userRepo.isExistsByUserId(idOfUser)) {
		      throw new UserExceptions();
		    }
		}
		 catch(UserExceptions e)
		 {
			 e.userNotFoundException();
		 }
		User userObjectForRatings = userRepo.findByUserId(idOfUser).get();
		ratingRepo.deleteAllByUserForRatings(userObjectForRatings);
	}

	
	
	//**************************BOOK RELATED: VIEW BOOKS*******************
	//*****VIEW BOOKS*******
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	


	

	 
	
}
