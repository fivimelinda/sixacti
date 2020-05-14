package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.exception.FileStorageException;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.KisModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.KisDB;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
public class KisServiceImpl implements KisService{
    @Autowired
    KisDB kisDB;

    @Override
    public KisModel storeFile(LamaranModel lamaran, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            KisModel kisModel= new KisModel(fileName, file.getBytes());
            kisModel.setLamaran(lamaran);
            return kisDB.save(kisModel);
        } catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ", Please try again!", ex);
        }
    }

    @Override
    public KisModel getFileByName(String fileName) {
        Optional<KisModel> berkas = kisDB.findByFileName(fileName);
        if(berkas.isPresent()){
            return berkas.get();
        }
        return null;
    }
}
