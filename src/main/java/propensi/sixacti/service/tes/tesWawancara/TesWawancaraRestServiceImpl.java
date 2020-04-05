package propensi.sixacti.service.tes.tesWawancara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.TesWawancaraModel;
import propensi.sixacti.repository.tes.TesWawancaraDb;

@Service
@Transactional
public class TesWawancaraRestServiceImpl implements TesWawancaraRestService{
    @Autowired
    private TesWawancaraDb tesWawancaraDb;

    public TesWawancaraModel buatTesWawancara(TesWawancaraModel tesWawancara){
        return tesWawancaraDb.save(tesWawancara);
    }

    public TesWawancaraModel ubahTesWawancara(Long idTesWawancara, TesWawancaraModel tesWawancara){
        TesWawancaraModel updateTesWawancara = getTesWawancaraByIdTesWawancara(idTesWawancara);
        // restoran.setNama(restoranUpdate.getNama());
        // restoran.setAlamat(restoranUpdate.getAlamat());
        // restoran.setNomorTelepon(restoranUpdate.getNomorTelepon());
        // restoran.setRating(restoranUpdate.getRating());

        return tesWawancaraDb.save(updateTesWawancara);
    }

    public TesWawancaraModel getTesWawancaraByIdTesWawancara(Long idTesWawancara){
        TesWawancaraModel tesWawancara = tesWawancaraDb.findById(idTesWawancara).orElse(null);
        return tesWawancara;
        // if(restoran.isPresent()){
        //     return restoran.get();
        // }else{
        //     throw new NoSuchElementException();
        // }
    }
}