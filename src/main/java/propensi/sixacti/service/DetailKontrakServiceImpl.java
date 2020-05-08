package propensi.sixacti.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.DetailKontrakModel;
import propensi.sixacti.repository.DetailKontrakDB;

@Service
@Transactional
public class DetailKontrakServiceImpl implements DetailKontrakService {

    @Autowired
    private DetailKontrakDB detailKontrakDb;


    @Override
    public DetailKontrakModel getDetailKontrakById(Long id) {
        Optional <DetailKontrakModel> kontrak = detailKontrakDb.getDetailKontrakByNoSurat(id);
        if (kontrak.isPresent()) {
            return kontrak.get();
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<DetailKontrakModel> retrieveListDetailKontrak() {
        return detailKontrakDb.findAll();
    }
    

}