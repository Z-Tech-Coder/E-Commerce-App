package Z_Tech_Coder.github.backend.product.service.serviceObj;

public record AddProductRequest(
    String userEmail, // serves for validating the vendor account and to know which inventory we gonna add the product to
    String productName,
    String productDes,
    int productPrice,
    int productStock,
    String categoryName
) {
}
