package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ProductService;

@Controller
public class OpController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("ProductList", productService.getAllProduct());
        return "/index";
    }
    

    
}