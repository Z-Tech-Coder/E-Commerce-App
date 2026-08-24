package Z_Tech_Coder.github.backend.inventory.repository;

import Z_Tech_Coder.github.backend.inventory.entity.Inventory;
import Z_Tech_Coder.github.backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Optional<Inventory> findByVendor(User user);
}
