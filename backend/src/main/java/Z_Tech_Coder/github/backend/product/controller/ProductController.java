package Z_Tech_Coder.github.backend.product.controller;

import Z_Tech_Coder.github.backend.product.service.ProductServiceImpl;
import Z_Tech_Coder.github.backend.product.service.serviceObj.AddProductRequest;
import Z_Tech_Coder.github.backend.product.service.serviceObj.AddProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductServiceImpl inventoryService;

    @PostMapping("/addProduct")
    public AddProductResponse addProduct(@RequestBody AddProductRequest addProductRequest) {
        return inventoryService.addProduct(addProductRequest);
    }
}
