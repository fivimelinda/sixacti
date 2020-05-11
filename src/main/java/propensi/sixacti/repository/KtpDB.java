package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.KtpModel;

import java.util.Optional;

@Repository
public interface KtpDB extends JpaRepository<KtpModel, Long> {
    Optional<KtpModel> findByFileName(String fileName);
}
