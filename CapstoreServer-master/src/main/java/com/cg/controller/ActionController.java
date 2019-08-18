package com.cg.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.cg.bean.Merchant;
import com.cg.bean.Product;
import com.cg.dao.ProductDAO;
import com.cg.exception.MerchantNotFoundException;
import com.cg.exception.ProductNotFoundException;
import com.cg.service.MerchantServices;
import com.cg.service.MerchantServicesImpl;

@RestController
@CrossOrigin("http://localhost:4200")
public class ActionController {
	
	@Autowired
	private MerchantServices merchantService;


	@PostMapping(value="/products/add", consumes= {"application/json"})
	public int addProduct(@RequestBody Product product) throws ProductNotFoundException {
		product.setReleaseDate(new Date(2019,8,24));
		merchantService.addProduct(product);
		return 0;
	}
	@PutMapping(value="/products/update", consumes= {"application/json"})
	public Product updateProduct(@RequestBody Product product) {
		try {
			merchantService.updateProduct(product);
			return product;
		}catch(Exception e) {
			return null;
		}
	}

	@GetMapping(value="products/getmerchantbyid/{merchantId}") 
	public Merchant getMerchantById(@PathVariable("merchantId") Integer merchantId) throws MerchantNotFoundException {
		return merchantService.getMerchantById(merchantId);
	}
	
	
	@GetMapping(value="products/all/{merchantId}")
	public @ResponseBody List<Product> getAllProduct(@PathVariable("merchantId") int merchantId) {
		System.out.println("Hello");
		System.out.println(merchantId);
		List<Product> product = merchantService.getAllProducts(merchantId);
		return product;
	}
	
	@DeleteMapping(value="products/delete/{productID}")
	public void removeProduct(@RequestParam("merchantId") int merchantId,@PathVariable int productId) {
		Merchant merchant;
		try {
		merchant=merchantService.getMerchantById(merchantId);
		
		merchantService.removeProduct(productId);
		}
		catch (ProductNotFoundException e) {

		}
		 catch (MerchantNotFoundException e) {

			}
	}
	
}
