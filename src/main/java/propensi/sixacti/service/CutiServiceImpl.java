package propensi.sixacti.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.CutiModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.repository.CutiDb;
import propensi.sixacti.rest.CutiDetail;

@Service
@Transactional
public class CutiServiceImpl implements CutiService{
	@Autowired
	private CutiDb cutiDb;
	
	@Override
	public Optional<CutiModel> getCutiById(Long idCuti) {
		return cutiDb.findById(idCuti);
	}
	
	@Override
	public Optional<CutiModel> getCutiOnProcess(KaryawanModel karyawan) {
		return cutiDb.findCutionProcess(karyawan, "Diajukan", "Diproses");
	}
	
	@Override
	public void addCuti(CutiModel cuti) {
		cutiDb.save(cuti);
	}
	
	@Override
	public void deleteCuti(CutiModel cuti) {
		cutiDb.delete(cuti);
	}
	
	@Override
	public List<CutiModel> getCutiDoneByKaryawan(KaryawanModel karyawan){
		List<String> status = Arrays.asList("Disetujui", "Ditolak");
		return cutiDb.findCutiDone(karyawan, status);
	}
	
	@Override
	public List<CutiModel> getCutiByKaryawanAndStatus(List<KaryawanModel> karyawan, String status){
		return cutiDb.findUnreviewed(karyawan, status);
	}
}
