package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.KkModel;
import propensi.sixacti.model.KtpModel;

import java.util.Optional;

@Repository
public interface KkDB extends JpaRepository<KkModel, Long> {
    Optional<KkModel> findByFileName(String fileName);
}
