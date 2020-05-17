package propensi.sixacti.service.tes.tesMedis;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.TesMedisModel;

import java.util.List;

public interface TesMedisRestService {
    
    TesMedisModel buatTesMedis(TesMedisModel tesMedis);

    TesMedisModel ubahTesMedis(Long idTesMedis, TesMedisModel tesMedis);

    TesMedisModel getTesMedisByIdTesMedis(Long idTesMedis);

    TesMedisModel getTesMedisByPelamar(PelamarModel pelamar);

//    List<TesMedisModel> getTesMedisByIdPelamar(Long idPelamar);
}