package com.hotel.booking.airbnb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product",
    uniqueConstraints = {
                @UniqueConstraint(name = "unique_sku",columnNames = {"sku"}),
                @UniqueConstraint(name = "price_title_Constraint",columnNames = {"title_x","price"}) // Note: so there can be one 1 title with same price, meaning parle-g can be just one with 20 rupees, now parle-g can have an entry with another amount
                                                                                // Note: here column name is title_x as below we have used @Column annotation to change name to title_x so we have to use that name only


}




)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String sku;

    @Column(name = "title_x")
    private String title;
    private BigDecimal price;
    private Integer quantity;

    @Column(name = "createdat")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updatedat")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
