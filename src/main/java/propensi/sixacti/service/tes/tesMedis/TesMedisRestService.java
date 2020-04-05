package propensi.sixacti.service.tes.tesMedis;

import propensi.sixacti.model.TesMedisModel;

public interface TesMedisRestService {
    
    TesMedisModel buatTesMedis(TesMedisModel tesMedis);

    TesMedisModel ubahTesMedis(Long idTesMedis, TesMedisModel tesMedis);

    TesMedisModel getTesMedisByIdTesMedis(Long idTesMedis);
}