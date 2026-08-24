package Z_Tech_Coder.github.backend.inventory.entity;

import Z_Tech_Coder.github.backend.product.entity.Product;
import Z_Tech_Coder.github.backend.user.entity.User;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inventoryId;

    @OneToOne
    @JoinColumn(name = "user_id")
    User vendor;

    @OneToMany(mappedBy = "inventory")
    List<Product> products = new ArrayList<>();
}
