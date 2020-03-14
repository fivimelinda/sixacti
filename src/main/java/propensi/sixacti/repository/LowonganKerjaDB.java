package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.KaryawanModel;

@Repository
public class LowonganKerjaDB extends JpaRepository<KaryawanModel, Long> {
}
