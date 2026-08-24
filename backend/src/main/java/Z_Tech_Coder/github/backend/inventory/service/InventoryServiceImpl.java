package Z_Tech_Coder.github.backend.inventory.service;

import Z_Tech_Coder.github.backend.inventory.entity.Inventory;
import Z_Tech_Coder.github.backend.inventory.repository.InventoryRepository;
import Z_Tech_Coder.github.backend.inventory.service.serviceObj.createInventoryRequest;
import Z_Tech_Coder.github.backend.inventory.service.serviceObj.createInventoryResponse;
import Z_Tech_Coder.github.backend.user.entity.User;
import Z_Tech_Coder.github.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public createInventoryResponse createInventory(createInventoryRequest createInventoryRequest) {
        User user = new User();
        user = userRepository.findByEmail(createInventoryRequest.userEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Inventory inventory = new Inventory();
        inventory.setVendor(user);

        inventoryRepository.save(inventory);
        return new createInventoryResponse(true);
    }
}
