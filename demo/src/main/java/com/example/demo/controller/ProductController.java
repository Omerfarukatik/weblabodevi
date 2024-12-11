package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/Product/{prodID}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer prodID) {
        return productRepository.findById(prodID).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping("/newProduct")
    // Product newProduct(@RequestBody Product newProduct){
    //     return productRepository.save(newProduct);
    // }
    public String newProduct(@ModelAttribute Product newProduct) {
    productRepository.save(newProduct);
    return "redirect:/";  // Redirects to the root (product list) after adding the product
}

    @PostMapping("/uptProduct/{prodID}")
    Optional<Object> updateProduct(@RequestBody Product newProduct, @PathVariable String prodID) {
        try {
            Integer parsedProtID = Integer.parseInt(prodID);
            return productRepository.findById(parsedProtID).map(prot -> {
                prot.setModel(newProduct.getModel());
                prot.setMarka(newProduct.getMarka());
                prot.setFiyat(newProduct.getFiyat());
                prot.setAdet(newProduct.getAdet());
                return productRepository.save(prot);
            });
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid prodId format");
        }
    }
    @GetMapping("/delProduct/{prodID}")
    String deleteProduct(@PathVariable Integer prodID) {

        productRepository.deleteById(prodID);
        return "redirect:/";
    }
}
