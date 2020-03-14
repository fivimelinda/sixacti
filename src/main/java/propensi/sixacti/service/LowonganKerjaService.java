package propensi.sixacti.service;

import propensi.sixacti.model.LowonganKerjaModel;

public interface LowonganKerjaService {

    LowonganKerjaModel getLowonganKerjaById(Long id);
    void addLowonganKerja (LowonganKerjaModel newLoker);

}
