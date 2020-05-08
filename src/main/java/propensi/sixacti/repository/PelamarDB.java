package propensi.sixacti.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.UserModel;

import java.util.Optional;

@Repository
public interface PelamarDB extends JpaRepository<PelamarModel, Long> {
    Optional<PelamarModel> findPelamarModelByUserPelamar(UserModel user);
}
