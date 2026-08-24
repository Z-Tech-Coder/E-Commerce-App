package Z_Tech_Coder.github.backend.category.entity;

import Z_Tech_Coder.github.backend.product.entity.Product;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;

    String name;

    @OneToMany(mappedBy = "category")
    List<Product> products = new ArrayList<>();
}
