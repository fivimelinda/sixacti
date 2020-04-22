package propensi.sixacti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import propensi.sixacti.model.KaryawanModel;

public interface KaryawanDB extends JpaRepository<KaryawanModel, Long> {
    
}