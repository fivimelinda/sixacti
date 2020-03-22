package propensi.sixacti.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.repository.KaryawanDb;

@Service
@Transactional
public class KaryawanServiceImpl implements KaryawanService{
	@Autowired
	KaryawanDb karyawanDb;
	
	@Override
	public Optional<KaryawanModel> getKaryawanById(Long idKaryawan) {
		return karyawanDb.findById(idKaryawan);
	}

}
