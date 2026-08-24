package Z_Tech_Coder.github.backend.product.service.serviceObj;

public record UpdateProductRequest(
        String userEmail,
        Integer productId,
        String newProductName,
        String newProductDescription,
        Integer newProductPrice,
        Integer newProductStock,
        String newCategoryName
) {
}
