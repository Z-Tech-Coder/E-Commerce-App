package Z_Tech_Coder.github.backend.user.repository;

import Z_Tech_Coder.github.backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    /*
    userRepository.save(user);

    userRepository.findById(id);

    userRepository.findAll();

    userRepository.deleteById(id);

    userRepository.existsById(id);
     */
}
