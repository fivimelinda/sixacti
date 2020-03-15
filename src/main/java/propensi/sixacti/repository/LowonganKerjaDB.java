package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import propensi.sixacti.model.LowonganKerjaModel;

import java.util.List;


public interface LowonganKerjaDB extends JpaRepository<LowonganKerjaModel, Long> {

    List<LowonganKerjaModel> findAllByOrderByTanggalMulaiAsc();
}
