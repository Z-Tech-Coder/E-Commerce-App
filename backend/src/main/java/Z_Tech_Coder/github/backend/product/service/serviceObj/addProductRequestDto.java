package Z_Tech_Coder.github.backend.product.service.serviceObj;

public record addProductRequestDto(
    String productName,
    String productDes,
    int productPrice,
    int productStock,
    String categoryName
) {
}
