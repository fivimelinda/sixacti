package propensi.sixacti.service.tes.tesTulis;

import propensi.sixacti.model.TesTulisModel;

public interface TesTulisRestService {
    TesTulisModel buatTesTulis(TesTulisModel tesTulis);

    TesTulisModel ubahTesTulis(Long idTesTulis, TesTulisModel tesTulis);

    TesTulisModel getTesTulisByIdTesTulis(Long idTesTulis);
}