package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.LamaranModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface LamaranDB extends JpaRepository<LamaranModel, Long> {
    Optional<LamaranModel> findLamaranModelById(Long id);
    List<LamaranModel> findByLowonganIdLowongan(Long idLowongan);
}
