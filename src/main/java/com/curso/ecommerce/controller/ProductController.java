package com.curso.ecommerce.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.curso.ecommerce.model.Product;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.ProductService;
import com.curso.ecommerce.service.UploadFileService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private UploadFileService upload;

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
	public String save(Product product, @RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("This is a product object {}", product);

		Usuario u = new Usuario(1, "", "", "", "", "", "", "");
		product.setUsuario(u);

		// image
		if (product.getId() == null) { // when creating a product
			String imageName = upload.saveImage(file);
			product.setImage(imageName);
		} else {
			if (file.isEmpty()) { // when we edit a product but don't change the image
				Product p = new Product();
				p = productService.get(product.getId()).get();
				product.setImage(p.getImage());
			} else {
				String imageName = upload.saveImage(file);
				product.setImage(imageName);
			}
		}

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
