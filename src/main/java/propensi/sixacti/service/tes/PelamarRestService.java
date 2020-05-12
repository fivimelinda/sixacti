package propensi.sixacti.service.tes;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.UserModel;

public interface PelamarRestService {

    void saveUpdatePelamar(PelamarModel pelamar);
    PelamarModel getPelamarByIdPelamar(Long idPelamar);
    PelamarModel getPelamarByUser(UserModel user);

}