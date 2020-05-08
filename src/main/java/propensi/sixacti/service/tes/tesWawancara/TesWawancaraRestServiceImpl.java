package propensi.sixacti.service.tes.tesWawancara;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.PelamarModel;
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
        updateTesWawancara.setNilai(tesWawancara.getNilai());
        updateTesWawancara.setFeedback(tesWawancara.getFeedback());
        updateTesWawancara.setIsEdit(tesWawancara.getIsEdit());
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

    @Override 
    public TesWawancaraModel getTesWawancaraByPelamar(PelamarModel pelamar){
        List<TesWawancaraModel> listTesWawancara = tesWawancaraDb.findByPelamarTesWawancara(pelamar);
        if(listTesWawancara.size() != 0){
            return listTesWawancara.get(0);
        }else{
            return null;
        }
    }
}