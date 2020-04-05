package propensi.sixacti.service.tes.tesTulis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println(updateTesTulis.getIdTesTulis());
        System.out.println(updateTesTulis.getNilai());
        System.out.println("###################################################");
        updateTesTulis.setNilai(tesTulis.getNilai());
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
}