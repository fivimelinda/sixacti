package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.NpwpModel;

import java.util.Optional;

public interface NpwpDB extends JpaRepository<NpwpModel, Long> {
    Optional<NpwpModel> findByFileName(String fileName);
}
