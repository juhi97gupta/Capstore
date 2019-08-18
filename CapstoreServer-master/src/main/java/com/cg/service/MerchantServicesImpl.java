package com.cg.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.cg.bean.Merchant;
import com.cg.bean.Product;
import com.cg.dao.MerchantDAO;
import com.cg.dao.ProductDAO;
import com.cg.exception.MerchantNotFoundException;
import com.cg.exception.ProductNotFoundException;

@Service
public class MerchantServicesImpl implements MerchantServices{

	@Autowired
	private MerchantDAO merchantRepo;
	
	@Autowired
	private ProductDAO productRepo;
	
	//@Autowired
	private Product product;
	
	//@Autowired
	private Merchant merchant;
	

	

	@Override
	public Merchant getMerchantById(int merchantId) {
		Optional<Merchant> box = merchantRepo.findById(merchantId);
		if(box.isPresent()) {
			Merchant merchant = box.get();
			return merchant;
		}else {
			return null;
		}
		
//		Merchant merchant = merchantRepo.getOne(merchantId);
//		merchant.setPassword(Base64Coder.decodeString(merchant.getPassword()));
//		return merchant;
	}

	@Override
	public Integer addProduct(Product product) throws ProductNotFoundException {
		try {
			System.out.println(product);
			productRepo.saveAndFlush(product);
			return product.getProductID();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Product> getAllProducts(int merchantId) {
		List<Product> list = productRepo.findAll();
		list= list.stream().filter(product->{
			if(product.getMerchant().getMerchantId() == merchantId) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		return list;
	}


	@Override
	public void updateProduct(Product product) throws ProductNotFoundException {
		Optional<Product> box = productRepo.findById(product.getProductID());
		if(box.isPresent()) {
			System.out.println(product);
			productRepo.save(product);
		}else {
			throw new ProductNotFoundException("product not found");
		}
	}

	@Override
	public Product getProductDetails(int productId) throws ProductNotFoundException{
		Optional<Product> box = productRepo.findById(product.getProductID());
		if(box.isPresent()) {
			System.out.println("in service");
			return box.get();
		}else {
			throw new ProductNotFoundException("product not found");
		}
	}

	@Override
	public void removeProduct(int productId) throws ProductNotFoundException {
		Optional<Product> box = productRepo.findById(product.getProductID());
		if(box.isPresent()) {
			productRepo.delete(box.get());
		}else {
			throw new ProductNotFoundException("product not found");
		}
	}

}
