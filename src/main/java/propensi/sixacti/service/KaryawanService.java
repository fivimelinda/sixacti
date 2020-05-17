package propensi.sixacti.service;

import java.util.List;
import java.util.Optional;

import propensi.sixacti.model.CutiModel;
import propensi.sixacti.model.KaryawanModel;


public interface KaryawanService {
	KaryawanModel getKaryawanById(Long id);
	void addKaryawan(KaryawanModel cuti);
	// KaryawanModel addDummy();
}

