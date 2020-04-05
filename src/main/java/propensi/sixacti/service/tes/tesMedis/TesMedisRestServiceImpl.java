package propensi.sixacti.service.tes.tesMedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.TesMedisModel;
import propensi.sixacti.repository.tes.TesMedisDb;

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
        TesMedisModel updateTesMedis = getTesMedisByIdTesMedis(idTesMedis);
        updateTesMedis.setBeratBadan(tesMedis.getBeratBadan());
        updateTesMedis.setTinggiBadan(tesMedis.getTinggiBadan());
        updateTesMedis.setButaWarna(tesMedis.getButaWarna());
        updateTesMedis.setRiwayatPenyakit(tesMedis.getRiwayatPenyakit());
        updateTesMedis.setTekananDarah(tesMedis.getTekananDarah());
        return tesMedisDb.save(updateTesMedis);
    }

    @Override
    public TesMedisModel getTesMedisByIdTesMedis(Long idTesMedis){
        TesMedisModel tesMedis = tesMedisDb.findById(idTesMedis).orElse(null);
        return tesMedis;
        // if(restoran.isPresent()){
        //     return restoran.get();
        // }else{
        //     throw new NoSuchElementException();
        // }
    }
}