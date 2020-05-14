package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.exception.FileStorageException;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.BpjsKesehatanModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.BpjsKesehatanDB;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
public class BpjsKesehatanServiceImpl implements BpjsKesehatanService {
    @Autowired
    BpjsKesehatanDB bpjsKesehatanDB;

    @Override
    public BpjsKesehatanModel storeFile(LamaranModel lamaran, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            BpjsKesehatanModel bpjsKesehatanModel= new BpjsKesehatanModel(fileName, file.getBytes());
            bpjsKesehatanModel.setLamaran(lamaran);
            return bpjsKesehatanDB.save(bpjsKesehatanModel);
        } catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ", Please try again!", ex);
        }
    }

    @Override
    public BpjsKesehatanModel getFileByName(String fileName) {
        Optional<BpjsKesehatanModel> berkas = bpjsKesehatanDB.findByFileName(fileName);
        if(berkas.isPresent()){
            return berkas.get();
        }
        return null;
    }
}
