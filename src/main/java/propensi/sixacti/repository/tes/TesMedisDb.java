package propensi.sixacti.repository.tes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.TesMedisModel;

@Repository
public interface TesMedisDb extends JpaRepository<TesMedisModel, Long>{
    Optional<TesMedisModel> findById(Long idTesMedis);
    List<TesMedisModel> findByIdTesMedis(Long idTesMedis);
    List<TesMedisModel> findByPelamarTesMedis(PelamarModel pelamarTesMedis);
}