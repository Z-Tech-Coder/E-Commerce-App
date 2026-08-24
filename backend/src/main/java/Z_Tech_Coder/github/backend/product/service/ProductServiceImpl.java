package Z_Tech_Coder.github.backend.product.service;

import Z_Tech_Coder.github.backend.category.entity.Category;
import Z_Tech_Coder.github.backend.category.repository.CategoryRepository;
import Z_Tech_Coder.github.backend.inventory.entity.Inventory;
import Z_Tech_Coder.github.backend.product.entity.Product;
import Z_Tech_Coder.github.backend.inventory.repository.InventoryRepository;
import Z_Tech_Coder.github.backend.product.repository.ProductRepository;
import Z_Tech_Coder.github.backend.product.service.serviceObj.AddProductRequest;
import Z_Tech_Coder.github.backend.product.service.serviceObj.AddProductResponse;
import Z_Tech_Coder.github.backend.user.entity.User;
import Z_Tech_Coder.github.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {// add product to product Table

        User user = userRepository.findByEmail(addProductRequest.userEmail())
                        .orElseThrow(()-> new RuntimeException("User not found"));

        Inventory inventory = inventoryRepository.findByVendor(user)
                        .orElseThrow(()-> new RuntimeException("Inventory not found"));

        Category category = categoryRepository.findByName(addProductRequest.categoryName())
                .orElseThrow(()-> new RuntimeException("Category not found"));

        Product product = new Product();
            product.setName(addProductRequest.productName());
            product.setDescription(addProductRequest.productDes());
            product.setPrice(addProductRequest.productPrice());
            product.setStock(addProductRequest.productStock());
            product.setCategory(category);
            product.setInventory(inventory);
            product.setProductAvailability((addProductRequest.productStock() > 0));
            productRepository.save(product);

            return new AddProductResponse(true);

    }
}


