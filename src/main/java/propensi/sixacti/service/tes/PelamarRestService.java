package propensi.sixacti.service.tes;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.ProfileModel;

public interface PelamarRestService {

    void saveUpdatePelamar(PelamarModel pelamar);
    PelamarModel getPelamarByIdPelamar(Long idPelamar);
    PelamarModel getPelamarByUser(ProfileModel user);

}