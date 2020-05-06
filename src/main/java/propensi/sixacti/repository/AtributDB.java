package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import propensi.sixacti.model.AtributModel;

import java.util.Optional;

@Repository
public interface AtributDB extends JpaRepository<AtributModel, Long> {
}
