package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.BerkasModel;


import java.util.Optional;
@Repository
public interface BerkasDB extends JpaRepository<BerkasModel, Long> {
    Optional<BerkasModel> findByFileName(String fileName);

}
