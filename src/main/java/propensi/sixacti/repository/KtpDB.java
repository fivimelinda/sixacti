package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.KtpModel;

@Repository
public interface KtpDB extends JpaRepository<KtpModel, Long> {
}
