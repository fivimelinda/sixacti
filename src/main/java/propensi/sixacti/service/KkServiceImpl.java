package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.exception.FileStorageException;
import propensi.sixacti.model.KkModel;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.KkDB;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
public class KkServiceImpl implements KkService{
    @Autowired
    KkDB kkDB;

    @Override
    public KkModel storeFile(LamaranModel lamaran, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            KkModel kkModel = new KkModel(fileName, file.getBytes());
            kkModel.setLamaran(lamaran);
            return kkDB.save(kkModel);
        } catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ", Please try again!", ex);
        }
    }

    @Override
    public KkModel getFileByName(String fileName) {
        Optional<KkModel> berkas = kkDB.findByFileName(fileName);
        if(berkas.isPresent()){
            return berkas.get();
        }
        return null;
    }
}
