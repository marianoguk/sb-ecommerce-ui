package com.sb.ecommerceui.domain.repository;

import com.sb.ecommerceui.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
