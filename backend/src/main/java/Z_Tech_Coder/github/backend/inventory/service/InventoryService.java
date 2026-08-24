package Z_Tech_Coder.github.backend.inventory.service;

import Z_Tech_Coder.github.backend.inventory.service.serviceObj.createInventoryRequest;
import Z_Tech_Coder.github.backend.inventory.service.serviceObj.createInventoryResponse;

public interface InventoryService {
    createInventoryResponse createInventory(createInventoryRequest createInventoryRequest);
}
