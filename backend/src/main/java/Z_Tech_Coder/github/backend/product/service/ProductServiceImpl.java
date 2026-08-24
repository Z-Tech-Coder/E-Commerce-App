package Z_Tech_Coder.github.backend.product.service;

import Z_Tech_Coder.github.backend.category.entity.Category;
import Z_Tech_Coder.github.backend.category.repository.CategoryRepository;
import Z_Tech_Coder.github.backend.inventory.entity.Inventory;
import Z_Tech_Coder.github.backend.product.entity.Product;
import Z_Tech_Coder.github.backend.inventory.repository.InventoryRepository;
import Z_Tech_Coder.github.backend.product.repository.ProductRepository;
import Z_Tech_Coder.github.backend.product.service.serviceObj.*;
import Z_Tech_Coder.github.backend.user.entity.User;
import Z_Tech_Coder.github.backend.user.repository.UserRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
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

    @Override
    @Transactional
    public UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest) {

        User user = userRepository.findByEmail(updateProductRequest.userEmail())
                .orElseThrow(()-> new RuntimeException("User not found"));

        Inventory inventory = inventoryRepository.findByVendor(user)
                .orElseThrow(()-> new RuntimeException("Inventory not found"));

        Product product = productRepository.findById(updateProductRequest.productId())
                .orElseThrow(()-> new RuntimeException("Incorrect Product ID"));

        if(product.getInventory() == inventory) {
            if (updateProductRequest.newProductName() != null)
                product.setName(updateProductRequest.newProductName());

            if (updateProductRequest.newProductDescription() != null)
                product.setDescription(updateProductRequest.newProductDescription());

            if (updateProductRequest.newProductPrice() != null)
                product.setPrice(updateProductRequest.newProductPrice());

            if (updateProductRequest.newProductStock() != null)
                product.setStock(updateProductRequest.newProductStock());

            if (updateProductRequest.newCategoryName() != null) {
                Category category = categoryRepository.findByName(updateProductRequest.newCategoryName())
                        .orElseThrow(() -> new RuntimeException("Category not found"));
                product.setCategory(category);
            }
            return new UpdateProductResponse(true);
        }
        else  {
            return new UpdateProductResponse(false);
        }
    }

    @Transactional
    @Override
    public DeleteProductResponse deleteProduct(DeleteProductRequest deleteProductRequest) {
        User user = userRepository.findByEmail(deleteProductRequest.userEmail())
                .orElseThrow(()-> new RuntimeException("User not found"));

        Inventory inventory = inventoryRepository.findByVendor(user)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        Product product = productRepository.findById(deleteProductRequest.productId())
                .orElseThrow(() -> new RuntimeException("Incorrect Product ID"));
        if(product.getInventory() == inventory) {
            productRepository.delete(product);
            return new DeleteProductResponse(true);
        }else  {
            return new DeleteProductResponse(false);
        }
    }
}


