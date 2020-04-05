package propensi.sixacti.service.tes.tesWawancara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.TesWawancaraModel;

@Service
@Transactional
public class TesWawancaraRestServiceImpl implements TesWawancaraRestService{
    @Autowired
    private TesWawancaraDb tesWawancaraDb;

    public TesWawancaraModel buatTesWawancara(TesWawancaraModel tesWawancara){
        return tesWawancaraDb.save(tesWawancara);
    }

    public TesWawancaraModel ubahTesWawancara(Long idTesWawancara, TesWawancaraModel tesWawancara){
        TesWawancaraModel oldTesWanwancara = getTesWawancaraByIdTesWawancara(idTesWawancara);
        // restoran.setNama(restoranUpdate.getNama());
        // restoran.setAlamat(restoranUpdate.getAlamat());
        // restoran.setNomorTelepon(restoranUpdate.getNomorTelepon());
        // restoran.setRating(restoranUpdate.getRating());

        return tesMWawancaraDb.save(oldTesWawancara);
    }

    public TesWawancaraModel getTesWawancaraByIdTesWawancara(Long idTesWawancara){
        return null;
        // Optional<RestoranModel> restoran = restoranDb.findByIdRestoran(idRestoran);
        // if(restoran.isPresent()){
        //     return restoran.get();
        // }else{
        //     throw new NoSuchElementException();
        // }
    }
}