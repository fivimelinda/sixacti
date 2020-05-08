package propensi.sixacti.service.tes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.repository.tes.PelamarDb;

@Service
@Transactional
public class PelamarRestServiceImpl implements PelamarRestService {
    @Autowired
    private PelamarDb pelamarDb;

    @Override
    public void saveUpdatePelamar(PelamarModel pelamar){
        pelamarDb.save(pelamar);
    }

    @Override
    public PelamarModel getPelamarByIdPelamar(Long idPelamar){
        PelamarModel pelamar= pelamarDb.findById(idPelamar).orElse(null);
        return pelamar;
        // if(restoran.isPresent()){
        //     return restoran.get();
        // }else{
        //     throw new NoSuchElementException();
        // }
    }

}