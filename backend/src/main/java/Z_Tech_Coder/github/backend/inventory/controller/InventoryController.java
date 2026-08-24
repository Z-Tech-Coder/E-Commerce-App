package Z_Tech_Coder.github.backend.inventory.controller;

import Z_Tech_Coder.github.backend.inventory.service.InventoryService;
import Z_Tech_Coder.github.backend.inventory.service.InventoryServiceImpl;
import Z_Tech_Coder.github.backend.inventory.service.serviceObj.createInventoryRequest;
import Z_Tech_Coder.github.backend.inventory.service.serviceObj.createInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping("/createInventory")
    createInventoryResponse createInventory(@RequestBody createInventoryRequest inventoryRequest){
        return inventoryService.createInventory(inventoryRequest);
    }
}
