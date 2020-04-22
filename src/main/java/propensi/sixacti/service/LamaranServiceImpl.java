package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.exception.FileStorageException;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.LamaranDB;


import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class LamaranServiceImpl implements LamaranService {
    @Autowired
    private LamaranDB lamaranDB;

    public LamaranModel findByIdLamaran(Long id){
        return lamaranDB.findById(id).get();
    }

    @Override
    public void addLamaran(LamaranModel lamaran) {
//        lamaran.setTimestampPelamar(Calendar.getInstance().getTime());
        lamaranDB.save(lamaran);
    }

    @Override
    public List<LamaranModel> getLamaranByLowonganId(Long idLowongan) {
        return lamaranDB.findByLowonganIdLowongan(idLowongan);
    }

    @Override
    public List<LamaranModel> getLamaran() {
        return lamaranDB.findAll();
    }



}

