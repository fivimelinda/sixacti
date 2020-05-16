package propensi.sixacti.repository.Login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
}