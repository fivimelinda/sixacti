package propensi.sixacti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import propensi.sixacti.model.RequestLowonganModel;

public interface RequestLowonganDB extends JpaRepository<RequestLowonganModel, Long> {
    Optional<RequestLowonganModel> getRequestLowonganById(Long id);
}