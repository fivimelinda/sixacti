package propensi.sixacti.repository.tes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.TesTulisModel;

@Repository
public interface TesTulisDb extends JpaRepository<TesTulisModel, Long>{
    
    Optional<TesTulisModel> findById(Long idTesTulis);

}