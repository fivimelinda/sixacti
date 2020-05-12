package propensi.sixacti.service.tes.tesTulis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.TesTulisModel;
import propensi.sixacti.repository.tes.TesTulisDb;

@Service
@Transactional
public class TesTulisRestServiceImpl implements TesTulisRestService{
    
    @Autowired
    private TesTulisDb tesTulisDb;

    public TesTulisModel buatTesTulis(TesTulisModel tesTulis){
        return tesTulisDb.save(tesTulis);
    }

    public TesTulisModel ubahTesTulis(Long idTesTulis, TesTulisModel tesTulis){
        TesTulisModel updateTesTulis = getTesTulisByIdTesTulis(idTesTulis);
        updateTesTulis.setNilai(tesTulis.getNilai());
        updateTesTulis.setIsEdit(tesTulis.getIsEdit());
        updateTesTulis.setIsLolos(tesTulis.getIsLolos());
        updateTesTulis.setIsGagal(tesTulis.getIsGagal());
        return tesTulisDb.save(updateTesTulis);
    }


    public TesTulisModel getTesTulisByIdTesTulis(Long idTesTulis){
        TesTulisModel tesTulis = tesTulisDb.findByIdTesTulis(idTesTulis).get(0);
        return tesTulis;
        // if(restoran.isPresent()){
        //     return restoran.get();
        // }else{
        //     throw new NoSuchElementException();
        // }
    }

    @Override 
    public TesTulisModel getTesTulisByPelamar(PelamarModel pelamar){
        List<TesTulisModel> listTesTulis = tesTulisDb.findByPelamarTesTulis(pelamar);
        if(listTesTulis.size() != 0){
            return listTesTulis.get(0);
        }else{
            return null;
        }
    }
}