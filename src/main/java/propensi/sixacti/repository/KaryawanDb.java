package propensi.sixacti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.KaryawanModel;

@Repository
public interface KaryawanDb extends JpaRepository<KaryawanModel, Long>{
	Optional<KaryawanModel> findById(Long idKaryawan);

}
