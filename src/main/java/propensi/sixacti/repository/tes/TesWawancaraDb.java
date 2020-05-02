package propensi.sixacti.repository.tes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.TesWawancaraModel;

@Repository
public interface TesWawancaraDb extends JpaRepository<TesWawancaraModel, Long>{
    Optional<TesWawancaraModel> findById(Long idTesWawancara);
    List<TesWawancaraModel> findByIdTesWawancara(Long idTesWawancara);
    List<TesWawancaraModel> findByPelamarTesWawancara(PelamarModel pelamarTesWawancara);
}