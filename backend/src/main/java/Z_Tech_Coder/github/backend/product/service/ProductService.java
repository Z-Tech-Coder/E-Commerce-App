package Z_Tech_Coder.github.backend.product.service;

import Z_Tech_Coder.github.backend.product.service.serviceObj.AddProductRequest;
import Z_Tech_Coder.github.backend.product.service.serviceObj.AddProductResponse;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest product);
}
