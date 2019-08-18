package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bean.Merchant;
import com.cg.bean.Product;


@Repository
public interface MerchantDAO extends JpaRepository<Merchant,Integer>{

}
