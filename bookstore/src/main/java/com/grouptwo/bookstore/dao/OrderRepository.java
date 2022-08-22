/**
 * 
 */
package com.grouptwo.bookstore.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grouptwo.bookstore.model.Order;
import com.grouptwo.bookstore.model.User;

/**
 * @author HY1916H
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {


	public Optional<Order> findByOrderId(int id);
	
	public void deleteByOrderId(int id);

	@Query("SELECT CASE WHEN COUNT(s)>0 THEN TRUE ELSE FALSE END FROM Order s WHERE s.orderId = ?1")
	public boolean isExistsByOrderId(Integer id);
	
	//This find By returns the values of orders of a specific user
	public List<Order> findAllByUserForOrders(User userObjectForOrders);
	
	//This deletes all the orders specific to user
	@Transactional
	public void deleteAllByUserForOrders(User userObjectForOrders);
	
}
