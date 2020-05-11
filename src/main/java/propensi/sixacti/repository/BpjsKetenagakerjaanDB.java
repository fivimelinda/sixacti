package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;

import java.util.Optional;

public interface BpjsKetenagakerjaanDB extends JpaRepository<BpjsKetenagakerjaanModel, Long>  {
    Optional<BpjsKetenagakerjaanModel> findByFileName(String fileName);
}
