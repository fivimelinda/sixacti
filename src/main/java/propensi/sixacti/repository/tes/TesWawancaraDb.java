package propensi.sixacti.repository.tes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.TesWawancaraModel;

@Repository
public interface TesWawancaraDb extends JpaRepository<TesWawancaraModel, Long>{
    Optional<TesWawancaraModel> findById(Long idTesWawancara);
}