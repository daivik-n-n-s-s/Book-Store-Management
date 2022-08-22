/**
 * 
 */
package com.grouptwo.bookstore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grouptwo.bookstore.model.Admin;

/**
 * @author HY1916H
 *
 */
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	public Optional<Admin> findByAdminId(int id);
	public void deleteByAdminId(int id);

	@Query("SELECT CASE WHEN COUNT(s)>0 THEN TRUE ELSE FALSE END FROM Admin s WHERE s.adminId = ?1")
	public boolean isExistsByAdminId(Integer id);
}
