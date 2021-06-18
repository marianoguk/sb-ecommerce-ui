package com.sb.ecommerceui.infrastructure.config;

import com.sb.ecommerceui.domain.repository.ProductRepository;
import com.sb.ecommerceui.domain.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@Configuration
@EnableMapRepositories(basePackages = "com.sb.ecommerceui.domain.repository")
public class UiConfig {

    @Bean
    public ProductService productService(ProductRepository repository) {
        return new ProductService(repository);
    }
}
