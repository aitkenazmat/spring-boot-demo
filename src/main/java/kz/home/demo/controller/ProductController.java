package kz.home.demo.controller;

import kz.home.demo.model.Product;
import kz.home.demo.repository.ProductDAO;
import kz.home.demo.repository.ProductRepository;
import kz.home.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    //todo убрать в сервис
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<Product> getAll(){
        return productDAO.getall();
        //return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return shopService.save(product);
    }

    @GetMapping("/name")
    public List<Product> getListProductByName(@RequestParam("name") String name) {
        return productRepository.findByNameStartingWith(name);
    }
}
