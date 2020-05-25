package kz.home.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "product_type", schema = "rw_document", catalog = "railways")
public class ProductType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_type_generator")
    @SequenceGenerator(name = "product_type_generator", sequenceName = "rw_document.product_type_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;

    public ProductType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
