package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.AtributModel;

@Repository
public interface AtributDb extends JpaRepository<AtributModel, Long>{
    List<AtributModel> findByKaryawan(KaryawanModel karyawan);
    
}
