package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.NpwpModel;

public interface NpwpDB extends JpaRepository<NpwpModel, Long> {
}
