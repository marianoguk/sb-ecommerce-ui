package com.sb.ecommerceui.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product updateWith(Product item) {
        return new Product(this.id,item.name,item.description,item.price);
    }

}
