package propensi.sixacti.service.tes.tesWawancara;

import propensi.sixacti.model.TesWawancaraModel;

public interface TesWawancaraRestService {
    TesWawancaraModel buatTesWawancara(TesWawancaraModel tesWawancara);

    TesWawancaraModel ubahTesWawancara(Long idTesWawancara, TesWawancaraModel tesWawancara);

    TesWawancaraModel getTesWawancaraByIdTesWawancara(Long idTesWawancara);
}