package propensi.sixacti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import propensi.sixacti.model.DetailKontrakModel;

public interface DetailKontrakDB extends JpaRepository<DetailKontrakModel, Long>{
    Optional<DetailKontrakModel> getDetailKontrakByNoSurat(Long noSurat);
}