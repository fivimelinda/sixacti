package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.KisModel;

public interface KisDB extends JpaRepository<KisModel, Long> {
}
