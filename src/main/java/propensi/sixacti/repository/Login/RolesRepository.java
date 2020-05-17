package propensi.sixacti.repository.Login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.ERole;
import propensi.sixacti.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{
    Optional<Roles> findByRoleName(ERole roleName);
}

