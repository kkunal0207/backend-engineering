package com.hotel.booking.airbnb;

import com.hotel.booking.airbnb.entities.ProductEntity;
import com.hotel.booking.airbnb.repositories.IProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class HotelBookingApplicationTests {

    @Autowired
    IProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void saveProduct(){
        ProductEntity entity = ProductEntity
            .builder()
            .sku("Diet Coke")
            .title("Coco Cola")
            .quantity(1)
            .price(BigDecimal.valueOf(12223))
            .build();

        ProductEntity savedProduct = productRepository.save(entity);
        System.out.println(savedProduct);

    }

    @Test
    void saveProduct2(){
        ProductEntity entity = ProductEntity
            .builder()
            .sku("Namkeen")
            .title("Britannia")
            .quantity(1)
            .price(BigDecimal.valueOf(113.33))
            .build();

        ProductEntity savedProduct = productRepository.save(entity);
        System.out.println(savedProduct);
    }

    @Test
    void getAll(){
        List<ProductEntity> getAll = productRepository.findAll();
        System.out.println(getAll);
    }

    @Test
    void getBySku(){
        List<ProductEntity> getBySku = productRepository.findBySku("Marie Gold");
        System.out.println(getBySku);
    }

    @Test
    void getByTitle(){
        List<ProductEntity> getByTitle = productRepository.findByTitle("Britannia");
        System.out.println(getByTitle);
    }

    @Test
    void findByPriceAndTitle(){
        ProductEntity getValueByPriceAndTitle = productRepository.findByPriceAndTitle(BigDecimal.valueOf(113.33),"Britannia");
        System.out.println(getValueByPriceAndTitle);
    }

    @Test
    void findByPriceAndSku(){
        ProductEntity getValue = productRepository.findByPriceAndSku(BigDecimal.valueOf(113.33),"Namkeen");
        System.out.println(getValue);
    }

}
