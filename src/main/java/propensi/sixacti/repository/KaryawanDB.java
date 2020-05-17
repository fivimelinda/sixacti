package propensi.sixacti.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import propensi.sixacti.model.KaryawanModel;

public interface KaryawanDB extends JpaRepository<KaryawanModel, Long> {
    Optional<KaryawanModel> findById(Long id);
}