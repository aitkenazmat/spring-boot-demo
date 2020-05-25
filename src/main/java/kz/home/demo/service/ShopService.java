package kz.home.demo.service;

import kz.home.demo.model.Product;
import kz.home.demo.model.ProductType;
import kz.home.demo.repository.ProductRepository;
import kz.home.demo.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;


    public Product save(Product product){

        Optional<ProductType> optionalProductType =
                productTypeRepository.findById(product.getProductTypeId());

        if (optionalProductType.isPresent()) {
            return  productRepository.save(product);
        } else {
            System.out.println("Ошибка**** не сущ тип ");
            return null;
        }
    }
}
