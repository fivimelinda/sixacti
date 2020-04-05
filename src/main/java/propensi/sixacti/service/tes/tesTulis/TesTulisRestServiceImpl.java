package propensi.sixacti.service.tes.tesTulis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.TesTulisModel;

@Service
@Transactional
public class TesTulisRestServiceImpl implements TesTulisRestService{
    
    @Autowired
    private TesTulisDb tesTulisDb;

    public TesTulisModel buatTesTulis(TesTulisModel tesTulis){
        return tesTulisDb.save(tesTulis);
    }

    public TesTulisModel ubahTesTulis(Long idTesTulis, TesTulisModel tesTulis){
        TesTulisModel oldTesTulis = getTesTulisByIdTesTulis(idTesTulis);
        // restoran.setNama(restoranUpdate.getNama());
        // restoran.setAlamat(restoranUpdate.getAlamat());
        // restoran.setNomorTelepon(restoranUpdate.getNomorTelepon());
        // restoran.setRating(restoranUpdate.getRating());

        return tesMedisDb.save(oldTesTulis);
    }

    public TesTulisModel getTesTulisByIdTesTulis(Long idTesTulis){
        return null;
        // Optional<RestoranModel> restoran = restoranDb.findByIdRestoran(idRestoran);
        // if(restoran.isPresent()){
        //     return restoran.get();
        // }else{
        //     throw new NoSuchElementException();
        // }
    }
}