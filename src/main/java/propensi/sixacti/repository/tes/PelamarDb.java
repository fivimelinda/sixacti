package propensi.sixacti.repository.tes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.PelamarModel;

@Repository
public interface PelamarDb extends JpaRepository<PelamarModel, Long>{

}