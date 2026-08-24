package Z_Tech_Coder.github.backend.product.service;

import Z_Tech_Coder.github.backend.product.service.serviceObj.*;


public interface ProductService {
    AddProductResponse addProduct(AddProductRequest addProductRequest);
    UpdateProductResponse updateProduct(UpdateProductRequest updateProduct);
    DeleteProductResponse deleteProduct(DeleteProductRequest deleteProductRequest);
}
