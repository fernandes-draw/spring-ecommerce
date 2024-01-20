package com.curso.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.ecommerce.model.Product;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public String show() {
		return "products/show";
	}

	@GetMapping("/create")
	public String create() {
		return "products/create";
	}

	@PostMapping("/save")
	public String save(Product product) {
		LOGGER.info("This is a product object {}", product);

		Usuario u = new Usuario(1, "", "", "", "", "", "", "");
		product.setUsuario(u);
		
		productService.save(product);
		return "redirect:/products";
	}

}











