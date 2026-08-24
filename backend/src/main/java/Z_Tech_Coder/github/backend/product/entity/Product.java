package Z_Tech_Coder.github.backend.product.entity;

import Z_Tech_Coder.github.backend.category.entity.Category;
import Z_Tech_Coder.github.backend.inventory.entity.Inventory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    int productId;
    String name;
    String description;
    int price;
    int stock;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;

    @ManyToOne
    @JoinColumn(name = "inventoryId")
    Inventory inventory;

    boolean productAvailability;
}
