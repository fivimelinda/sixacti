package propensi.sixacti.service;

import propensi.sixacti.model.LowonganKerjaModel;

import java.util.List;

public interface LowonganKerjaService {

    LowonganKerjaModel getLowonganKerjaById(Long id);
    void addLowonganKerja (LowonganKerjaModel lowonganKerja);
    LowonganKerjaModel changeLowonganKerja (Long idLowongan, LowonganKerjaModel newLoker);
    List<LowonganKerjaModel> getListLowonganKerja();
    void deleteLowonganKerja(Long idLowongan);


}
