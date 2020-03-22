package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.CutiModel;

@Repository
public interface CutiDb extends JpaRepository<CutiModel, Long>{
	
}
