package propensi.sixacti.service;

import java.util.Optional;

import propensi.sixacti.model.KaryawanModel;


public interface KaryawanService {
	Optional<KaryawanModel> getKaryawanById(Long idKaryawan);
}
