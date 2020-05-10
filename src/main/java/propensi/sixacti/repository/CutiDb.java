package propensi.sixacti.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.CutiModel;
import propensi.sixacti.model.KaryawanModel;

@Repository
public interface CutiDb extends JpaRepository<CutiModel, Long>{
	@Query(value = "SELECT c FROM CutiModel c WHERE c.karyawan = ?1 and c.status = ?2 or c.status = ?3")
    Optional<CutiModel> findCutionProcess(KaryawanModel karyawan, String status, String status2);
	
	@Query(value = "SELECT c FROM CutiModel c WHERE c.karyawan = ?1 and c.status = ?2")
	List<CutiModel> findCutiDone(KaryawanModel karyawan, String status, String status2);
}
