package propensi.sixacti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.DepartemenModel;

@Repository
public interface DepartemenDb extends JpaRepository<DepartemenModel, Long>{
}
