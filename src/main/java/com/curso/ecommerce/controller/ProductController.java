package com.curso.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String show(Model model) {
		model.addAttribute("products", productService.findAll());
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

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Product product = new Product();
		Optional<Product> optionalProduct = productService.get(id);
		product = optionalProduct.get();

		LOGGER.info("Product find: {}", product);

		model.addAttribute("product", product);
		return "products/edit";
	}

	@PostMapping("/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/products";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.delete(id);
		return "redirect:/products";
	}

}
