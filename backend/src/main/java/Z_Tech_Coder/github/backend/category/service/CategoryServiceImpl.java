package Z_Tech_Coder.github.backend.category.service;

import Z_Tech_Coder.github.backend.category.entity.Category;
import Z_Tech_Coder.github.backend.category.repository.CategoryRepository;
import Z_Tech_Coder.github.backend.category.service.serviceObj.createCategoryRequest;
import Z_Tech_Coder.github.backend.category.service.serviceObj.createCategoryResponse;
import Z_Tech_Coder.github.backend.user.entity.User;
import Z_Tech_Coder.github.backend.user.entity.UserType;
import Z_Tech_Coder.github.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public createCategoryResponse createCategory(createCategoryRequest createCategoryRequest) {
        User user = new User();
        user = userRepository.findByEmail(createCategoryRequest.userEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getUserType() !=  UserType.Admin) {
            return new createCategoryResponse(false);
        }

        Category category = new Category();
        category.setName(createCategoryRequest.categoryName());
        categoryRepository.save(category);

        return new createCategoryResponse(true);
    }
}
