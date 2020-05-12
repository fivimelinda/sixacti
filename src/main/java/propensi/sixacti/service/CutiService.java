package propensi.sixacti.service;

import java.util.List;
import java.util.Optional;

import propensi.sixacti.model.CutiModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.rest.CutiDetail;

public interface CutiService {
	void addCuti(CutiModel cuti);
	void deleteCuti(CutiModel cuti);
	Optional<CutiModel> getCutiById(Long id);
	Optional<CutiModel> getCutiOnProcess(KaryawanModel karyawan);
	List<CutiModel> getCutiDoneByKaryawan(KaryawanModel karyawan);
	List<CutiModel> getCutiByKaryawanAndStatus(List<KaryawanModel> idKaryawan, String status);
}
