package com.hotel.booking.airbnb.repositories;


import com.hotel.booking.airbnb.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findBySku(String sku);

    List<ProductEntity> findByTitle(String title);

    ProductEntity findByPriceAndTitle(BigDecimal price, String title);

    @Query("select e from ProductEntity e where price = ?1 and sku = ?2")
    ProductEntity findByPriceAndSku(BigDecimal price, String sku);
}
