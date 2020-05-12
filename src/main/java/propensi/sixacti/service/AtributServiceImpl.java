package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import propensi.sixacti.model.AtributModel;
import propensi.sixacti.repository.AtributDb;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AtributServiceImpl implements AtributService{
    @Autowired
    AtributDb atributDB ;

    @Override
    public List<AtributModel> getListAtribut(){
        return atributDB.findAll();
    }

    @Override
    public AtributModel getAtributById(Long id_atribut) {
        Optional<AtributModel> atribut = atributDB.findById(id_atribut);
        if(atribut.isPresent()){
            return atribut.get();
        }
        return null;
    }

    @Override
    public AtributModel changeStatusAtribut (Long id_atribut, AtributModel atributModel){
        AtributModel atribut = getAtributById(id_atribut);
        atribut.setStatus(atributModel.getStatus());
        return atributDB.save(atribut);
    }
}
