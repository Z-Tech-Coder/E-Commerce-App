package Z_Tech_Coder.github.backend.category.service;

import Z_Tech_Coder.github.backend.category.service.serviceObj.createCategoryRequest;
import Z_Tech_Coder.github.backend.category.service.serviceObj.createCategoryResponse;

public interface CategoryService {
    createCategoryResponse createCategory(createCategoryRequest createCategoryRequest);
}
