package propensi.sixacti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.KategoriCutiModel;

@Repository
public interface KategoriCutiDb extends JpaRepository<KategoriCutiModel, Long>{
	Optional<KategoriCutiModel> findById(Integer id);
}
