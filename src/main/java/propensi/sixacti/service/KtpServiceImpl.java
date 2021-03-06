package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.exception.FileStorageException;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.repository.KtpDB;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
public class KtpServiceImpl implements KtpService {
    @Autowired
    KtpDB ktpDB;

    @Override
    public KtpModel storeFile(LamaranModel lamaran, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            KtpModel ktpModel = new KtpModel(fileName, file.getBytes());
            ktpModel.setLamaran(lamaran);
            return ktpDB.save(ktpModel);
        } catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ", Please try again!", ex);
        }
    }

    @Override
    public KtpModel getFileByName(String fileName) {
        Optional<KtpModel> berkas = ktpDB.findByFileName(fileName);
        if(berkas.isPresent()){
            return berkas.get();
        }
        return null;
    }

}
