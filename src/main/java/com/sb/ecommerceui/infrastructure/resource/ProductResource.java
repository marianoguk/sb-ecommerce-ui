package com.sb.ecommerceui.infrastructure.resource;

import com.sb.ecommerceui.domain.model.Product;
import com.sb.ecommerceui.domain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class ProductResource {

    private final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = {"/home", "/"})
    public String home() {
        return "home";
    }

    @GetMapping(value = {"/hello"})
    public String hello() {
        return "hello";
    }



    @GetMapping("/product")
    public String findAll(Model model) {
        model.addAttribute("products", service.findAll());
        return "products";
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Product> find(@PathVariable("id") Long id) {
        return ResponseEntity.of(service.find(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product item) {
        Product created = service.create(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody Product updatedItem) {
        Optional<Product> updated = service.update(id, updatedItem);
        return updated.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> {
            Product created = service.create(updatedItem);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(created.getId()).toUri();
            return ResponseEntity.created(location).body(created);
        });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

     */
}