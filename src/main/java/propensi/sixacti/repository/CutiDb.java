package propensi.sixacti.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.CutiModel;
import propensi.sixacti.model.KaryawanModel;

@Repository
public interface CutiDb extends JpaRepository<CutiModel, Long>{
	@Query(value = "SELECT c FROM CutiModel c WHERE c.karyawan = :karyawan and c.status IN :status")
    Optional<CutiModel> findCutionProcess(@Param("karyawan") KaryawanModel karyawan, @Param("status") Collection<String> status);
	
	@Query(value = "SELECT b FROM CutiModel b WHERE b.karyawan = :karyawan and b.status IN :status ")
	List<CutiModel> findCutiDone(@Param("karyawan") KaryawanModel karyawan, @Param("status") Collection<String> status);
	
	@Query(value = "SELECT k FROM CutiModel k WHERE k.status = :mystatus and k.karyawan IN :karyawans")
	List<CutiModel> findUnreviewed(@Param("karyawans") Collection<KaryawanModel> karyawans, @Param("mystatus") String status);
}
