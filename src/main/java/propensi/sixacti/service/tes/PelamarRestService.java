package propensi.sixacti.service.tes;

import propensi.sixacti.model.PelamarModel;

public interface PelamarRestService {

    void saveUpdatePelamar(PelamarModel pelamar);
    PelamarModel getPelamarByIdPelamar(Long idPelamar);

}