package propensi.sixacti.service;

import java.util.List;
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

    @Override
    public KaryawanModel buatKaryawan(KaryawanModel karyawan){
        return karyawanDb.save(karyawan);
    }
	
	@Override
	public void addKaryawan(KaryawanModel cuti) {
		karyawanDb.save(cuti);
	}

    // @Override
    // public KaryawanModel addDummy() {
    //     KaryawanModel dummy = new KaryawanModel();
    //     dummy.setId(Long.valueOf(1));
    //     dummy.setJenisKaryawan(true);
    //     dummy.setGaji(12000);
    //     dummy.setSisaCuti(1);

    // }

}
