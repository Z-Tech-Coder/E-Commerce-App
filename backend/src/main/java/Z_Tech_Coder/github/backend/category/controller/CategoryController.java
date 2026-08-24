package Z_Tech_Coder.github.backend.category.controller;

import Z_Tech_Coder.github.backend.category.service.CategoryService;
import Z_Tech_Coder.github.backend.category.service.serviceObj.createCategoryRequest;
import Z_Tech_Coder.github.backend.category.service.serviceObj.createCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/createCategory")
    createCategoryResponse createCategory(@RequestBody createCategoryRequest createCategoryRequest){
        return categoryService.createCategory(createCategoryRequest);
    }
}
