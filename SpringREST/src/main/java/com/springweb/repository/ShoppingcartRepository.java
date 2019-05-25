package com.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springweb.model.ShoppingCart;

public interface ShoppingcartRepository extends JpaRepository<ShoppingCart, Long> {

}
