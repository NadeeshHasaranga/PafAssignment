package com.springweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springweb.dao.ShoppingcartDAO;
import com.springweb.model.ShoppingCart;



@RestController
@RequestMapping("/ecommercecart")
public class ShoppingcartController {
	
	@Autowired

	ShoppingcartDAO shoppingcartDAO;

	/* to add a cart */

	@PostMapping("/shopping")
	public ShoppingCart createShoppingCart(@Valid @RequestBody ShoppingCart shop) {
		return shoppingcartDAO.save(shop);
	}

	/* get all shopping cart details */

	@GetMapping("/shopping")
	public List<ShoppingCart> getAllShoppingCarts() {
		return shoppingcartDAO.findAll();
	}

	/* get shopping cart by cart id*/

	@GetMapping("/shopping/{id}")
	public ResponseEntity<ShoppingCart> getShoppinCartById(@PathVariable(value = "id") Long shoid) {

		ShoppingCart pro = shoppingcartDAO.findone(shoid);

		if (pro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pro);

	}

	/*
	 * update shopping cart
	 * 
	 */

	
	  @PutMapping("/shopping/{id}") public ResponseEntity<ShoppingCart>
	  updateProduct(@PathVariable(value = "id") Long crtid,
	  
	  @Valid @RequestBody ShoppingCart proDetails) {
	  
	  ShoppingCart sho = shoppingcartDAO.findone(crtid);
	  
	  if (sho == null) { return ResponseEntity.notFound().build(); }
	  
	  sho.setName(proDetails.getName());
	  sho.setDiscount(proDetails.getDiscount());
	  sho.setProcount(proDetails.getProcount());
	  sho.setTotamount(proDetails.getTotamount());
	  
	  ShoppingCart updateProduct = shoppingcartDAO.save(sho); return
	  ResponseEntity.ok().body(sho);
	  
	  }
	 
	// Delete a shopping cart by id 
	@DeleteMapping("/shopping/{id}")
	public ResponseEntity<ShoppingCart> deleteShoppingCart(@PathVariable(value = "id") Long crtid) {
		ShoppingCart shop = shoppingcartDAO.findone(crtid);

		if (shop == null) {
			return ResponseEntity.notFound().build();
		}
		shoppingcartDAO.delete(shop);
		return ResponseEntity.ok().build();

	}

}
