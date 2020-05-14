package propensi.sixacti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.AtributModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.repository.AtributDb;

@Service
@Transactional
public class AtributRestServiceImpl implements AtributRestService{
    @Autowired
    private AtributDb atributDb;

    @Override
    public AtributModel buatAtribut(AtributModel atribut){
        return atributDb.save(atribut);
    }

    @Override
    public AtributModel ubahAtribut(Long idAtribut, AtributModel atribut){
        AtributModel updateAtribut = getAtributByIdAtribut(idAtribut);
        updateAtribut.setUkuran_baju(atribut.getUkuran_baju());
        updateAtribut.setUkuran_sepatu(atribut.getUkuran_sepatu());
        updateAtribut.setUkuran_jas_lab(atribut.getUkuran_jas_lab());
        updateAtribut.setUkuran_helm(atribut.getUkuran_helm());
        return atributDb.save(updateAtribut);
    }

    @Override
    public AtributModel getAtributByIdAtribut(Long idAtribut){
        AtributModel atribut = atributDb.findById(idAtribut).orElse(null);
        return atribut;
    }

    @Override
    public AtributModel getAtributKaryawan(KaryawanModel karyawan){
        List<AtributModel> listAtribut = atributDb.findByKaryawan(karyawan);
        if(listAtribut.size() != 0){
            return listAtribut.get(0);
        }else{
            return null;
        }
    }

}