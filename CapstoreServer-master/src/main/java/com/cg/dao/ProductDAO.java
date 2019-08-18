package com.cg.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bean.Merchant;
import com.cg.bean.Product;


@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	
	@Query("select p from Product p where p.merchant=?1")
	public Product findbymerchant(Merchant merchant);
	
}
