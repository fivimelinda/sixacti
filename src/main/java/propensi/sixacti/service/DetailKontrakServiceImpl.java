package propensi.sixacti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.DetailKontrakModel;
import propensi.sixacti.repository.DetailKontrakDB;
import propensi.sixacti.repository.KaryawanDB;

@Service
@Transactional
public class DetailKontrakServiceImpl implements DetailKontrakService {

    @Autowired
    private DetailKontrakDB detailKontrakDb;

    @Autowired
    private KaryawanDB karyawanDb;


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

    @Override
    public List<String> getDetailKontrakWithName(){
        List <String> all = new ArrayList<>();
        List<DetailKontrakModel> detailKontrakAll = detailKontrakDb.findAll();
        for (DetailKontrakModel d : detailKontrakAll) {
            String b = d.getKaryawan().getProfile().getNama();
            all.add(b);
        }
        return all;
    }

    @Override
    public List<String> getDetailKontrakDepartemen() {
        List <String> all = new ArrayList<>();
        List<DetailKontrakModel> detailKontrakAll = detailKontrakDb.findAll();
        for (DetailKontrakModel d : detailKontrakAll) {
            String b = d.getKaryawan().getDepartemen().getNamaDepartemen();
            all.add(b);
        }
        return all;
    }

    @Override
    public DetailKontrakModel ubahStatus(Long id) {
        DetailKontrakModel kontrak = getDetailKontrakById(id);
        kontrak.setStatus(true);
        return detailKontrakDb.save(kontrak);
    }

    @Override
    public Integer getGaji(Long id) {
        return getDetailKontrakById(id).getKaryawan().getGaji();
        
    }

}