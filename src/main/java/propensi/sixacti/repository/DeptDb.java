package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.DepartemenModel;

@Repository
public interface DeptDb extends JpaRepository<DepartemenModel, Long>{

}
