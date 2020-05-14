package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import propensi.sixacti.model.BpjsKesehatanModel;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;

import java.util.Optional;

public interface BpjsKesehatanDB extends JpaRepository<BpjsKesehatanModel, Long> {
    Optional<BpjsKesehatanModel> findByFileName(String fileName);
}
