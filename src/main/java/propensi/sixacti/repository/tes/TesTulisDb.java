package propensi.sixacti.repository.tes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.TesTulisModel;

@Repository
public interface TesTulisDb extends JpaRepository<TesTulisModel, Long>{
    
    List<TesTulisModel> findByIdTesTulis(Long idTesTulis);
    List<TesTulisModel> findByPelamarTesTulis(PelamarModel pelamarTesTulis);
}