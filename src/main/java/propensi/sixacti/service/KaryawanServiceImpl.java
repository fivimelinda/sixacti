package propensi.sixacti.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.repository.KaryawanDB;

@Service
@Transactional
public class KaryawanServiceImpl implements KaryawanService{
	@Autowired
	KaryawanDB karyawanDb;
	
	@Override
    public KaryawanModel getKaryawanById(Long id) {
        Optional<KaryawanModel> karyawan = karyawanDb.findById(id);
        if(karyawan.isPresent()){
            return karyawan.get();
        }
        return null;
    }

}
