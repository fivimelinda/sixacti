package propensi.sixacti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.AtributModel;
import propensi.sixacti.model.KaryawanModel;

@Repository
public interface AtributDb extends JpaRepository<AtributModel, Long>{

    List<AtributModel> findByKaryawan(KaryawanModel karyawan);
    
}