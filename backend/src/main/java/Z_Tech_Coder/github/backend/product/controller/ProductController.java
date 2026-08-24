package Z_Tech_Coder.github.backend.product.controller;

import Z_Tech_Coder.github.backend.product.service.ProductServiceImpl;
import Z_Tech_Coder.github.backend.product.service.serviceObj.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/addProduct")
    AddProductResponse addProduct(@RequestBody AddProductRequest addProductRequest) {
        return productService.addProduct(addProductRequest);
    }

    @PostMapping("/updateProduct")
    UpdateProductResponse updateProduct(@RequestBody UpdateProductRequest updateProductRequest) {
        return productService.updateProduct(updateProductRequest);
    }

    @PostMapping("/deleteProduct")
    DeleteProductResponse deleteProduct(@RequestBody DeleteProductRequest deleteProductRequest) {
        return productService.deleteProduct(deleteProductRequest);
    }
}
