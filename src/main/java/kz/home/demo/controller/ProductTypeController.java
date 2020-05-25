package kz.home.demo.controller;

import kz.home.demo.model.ProductType;
import kz.home.demo.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-type")
public class ProductTypeController {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping
    public List<ProductType> getAll(){
        return productTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductType getProductType(@PathVariable("id") Long id){

        ProductType result = null;
        Optional<ProductType> productTypeOptional = productTypeRepository.findById(id);

        if (productTypeOptional.isPresent()) {
            result = productTypeOptional.get();
        }
       return result;
    }

    @PostMapping
    public ProductType savePt(@RequestBody ProductType productType){
        return productTypeRepository.save(productType);
    }
}
