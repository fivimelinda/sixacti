package propensi.sixacti.service.tes.tesMedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.TesMedisModel;

@Service
@Transactional
public class TesMedisRestServiceImpl implements TesMedisRestService{

    @Autowired
    private TesMedisDb tesMedisDb;

    @Override
    public TesMedisModel buatTesMedis(TesMedisModel tesMedis){
        return tesMedisDb.save(tesMedis);
    }

    @Override
    public TesMedisModel ubahTesMedis(Long idTesMedis, TesMedisModel tesMedis){
        TesMedisModel oldTesMedis = getTesMedisByIdTesMedis(idTesMedis);
        // restoran.setNama(restoranUpdate.getNama());
        // restoran.setAlamat(restoranUpdate.getAlamat());
        // restoran.setNomorTelepon(restoranUpdate.getNomorTelepon());
        // restoran.setRating(restoranUpdate.getRating());

        return tesMedisDb.save(oldTesMedis);
    }

    @Override
    public TesMedisModel getTesMedisByIdTesMedis(Long idTesMedis){
        return null;
        // Optional<RestoranModel> restoran = restoranDb.findByIdRestoran(idRestoran);
        // if(restoran.isPresent()){
        //     return restoran.get();
        // }else{
        //     throw new NoSuchElementException();
        // }
    }
}