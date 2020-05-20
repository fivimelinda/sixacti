package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.SectionModel;

@Repository
public interface SectionDb extends JpaRepository<SectionModel, Long> {

}
