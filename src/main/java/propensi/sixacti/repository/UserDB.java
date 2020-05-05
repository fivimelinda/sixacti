package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.UserModel;

import java.util.Optional;

@Repository
public interface UserDB extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findUserModelByNik(String nik);
}
