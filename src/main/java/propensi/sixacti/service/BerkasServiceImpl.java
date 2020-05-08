package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.exception.FileStorageException;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.BerkasDB;


import java.io.IOException;
@Service
@Transactional
public class BerkasServiceImpl implements BerkasService{
    @Autowired
    private BerkasDB berkasDB;

    @Override
    public BerkasModel storeFile(LamaranModel lamaran, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            BerkasModel berkasModel= new BerkasModel(fileName, file.getBytes());
            berkasModel.setLamaran(lamaran);
            return berkasDB.save(berkasModel);
        } catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ", Please try again!", ex);
        }
    }
}
