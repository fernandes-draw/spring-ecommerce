package com.curso.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
