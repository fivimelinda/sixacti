package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.repository.LowonganKerjaDB;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LowonganKerjaServiceImpl implements LowonganKerjaService {

    @Autowired
    LowonganKerjaDB lowonganKerjaDB;

    @Autowired
    RequestLowonganService requestLowonganService;

    @Override
    public LowonganKerjaModel getLowonganKerjaById(Long id) {
        Optional<LowonganKerjaModel> loker = lowonganKerjaDB.findById(id);
        if(loker.isPresent()){
            return loker.get();
        }
        return null;
    }

    @Override
    public void addLowonganKerja(LowonganKerjaModel lowonganKerja) {
        lowonganKerjaDB.save(lowonganKerja);

    }

    @Override
    public LowonganKerjaModel changeLowonganKerja(Long idLowongan, LowonganKerjaModel newLoker) {
        LowonganKerjaModel targetLoker = getLowonganKerjaById(idLowongan);
        targetLoker.setTanggalMulai(newLoker.getTanggalMulai());
        targetLoker.setTanggalBerakhir(newLoker.getTanggalBerakhir());
        targetLoker.setDeskripsi(newLoker.getDeskripsi());
        return lowonganKerjaDB.save(targetLoker);
    }

    @Override
    public List<LowonganKerjaModel> getListLowonganKerja() {
        return lowonganKerjaDB.findAllByOrderByTanggalMulaiAsc();
    }

    @Override
    public void deleteLowonganKerja(Long idLowongan) {
        LowonganKerjaModel loker = getLowonganKerjaById(idLowongan);

        if(loker != null){
            lowonganKerjaDB.delete(loker);

        }

    }

}
