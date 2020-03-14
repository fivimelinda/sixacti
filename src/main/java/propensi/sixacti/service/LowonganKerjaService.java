package propensi.sixacti.service;

import propensi.sixacti.model.LowonganKerjaModel;

import java.util.List;

public interface LowonganKerjaService {

    LowonganKerjaModel getLowonganKerjaById(Long id);
    void addLowonganKerja (LowonganKerjaModel lowonganKerja);
    LowonganKerjaModel changeLowonganKerja (LowonganKerjaModel newLoker);
    List<LowonganKerjaModel> getListLowonganKerja();
    void deleteLowonganKerja(LowonganKerjaModel lowonganKerja);


}
