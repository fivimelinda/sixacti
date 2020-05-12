package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.KisModel;

import java.util.Optional;

public interface KisDB extends JpaRepository<KisModel, Long> {
    Optional<KisModel> findByFileName(String fileName);
}
