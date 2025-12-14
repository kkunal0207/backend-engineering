package com.hotel.booking.airbnb.controllers;

import com.hotel.booking.airbnb.entities.ProductEntity;
import com.hotel.booking.airbnb.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    @Autowired
    private final IProductRepository productRepository;

    public ProductController(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/title")
    List<ProductEntity> getByTitleOrderByPrice(){
        return productRepository.findByTitleOrderByPrice("Britannia");
    }

    @GetMapping
    List<ProductEntity> findByAll(@RequestParam(defaultValue = "id") String sort){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,sort,"price"));
    }
}
