package kz.home.demo.repository;

import kz.home.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Product> getall(){
        return jdbcTemplate.query(
                "select * from railways.rw_document.product",
                new ProductRowMapper()
        );
    }

}
