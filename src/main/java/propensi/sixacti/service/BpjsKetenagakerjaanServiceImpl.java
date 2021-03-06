package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.exception.FileStorageException;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.BpjsKetenagakerjaanDB;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
public class BpjsKetenagakerjaanServiceImpl implements BpjsKetenagakerjaanService {
    @Autowired
    BpjsKetenagakerjaanDB bpjsKetenagakerjaanDB;

    public BpjsKetenagakerjaanModel storeFile(LamaranModel lamaran, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            BpjsKetenagakerjaanModel bpjsKetenagakerjaanModel= new BpjsKetenagakerjaanModel(fileName, file.getBytes());
            bpjsKetenagakerjaanModel.setLamaran(lamaran);
            return bpjsKetenagakerjaanDB.save(bpjsKetenagakerjaanModel);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ", Please try again!", ex);
        }
    }

    @Override
    public BpjsKetenagakerjaanModel getFileByName(String fileName) {
        Optional<BpjsKetenagakerjaanModel> berkas = bpjsKetenagakerjaanDB.findByFileName(fileName);
        if(berkas.isPresent()){
            return berkas.get();
        }
        return null;
    }
}
