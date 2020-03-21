package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.repository.LowonganKerjaDB;

import java.util.List;
import java.util.Optional;

@Service
public class LowonganKerjaServiceImpl implements LowonganKerjaService {

    @Autowired
    LowonganKerjaDB lowonganKerjaDB;

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
    public LowonganKerjaModel changeLowonganKerja(LowonganKerjaModel newLoker) {
        LowonganKerjaModel targetLoker = lowonganKerjaDB.findById(newLoker.getIdLowongan()).get();
        targetLoker.setDeskripsi(newLoker.getDeskripsi());
        targetLoker.setNomorLowongan(newLoker.getNomorLowongan());
        targetLoker.setTanggalBerakhir(newLoker.getTanggalBerakhir());
        targetLoker.setTanggalMulai(newLoker.getTanggalMulai());
        lowonganKerjaDB.save(targetLoker);
        return targetLoker;
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
