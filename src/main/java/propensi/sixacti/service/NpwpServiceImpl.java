package propensi.sixacti.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.exception.FileStorageException;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.model.NpwpModel;
import propensi.sixacti.repository.NpwpDB;

import java.io.IOException;

@Service
@Transactional
public class NpwpServiceImpl implements NpwpService{
    @Autowired
    NpwpDB npwpDB;

    @Override
    public NpwpModel storeFile(LamaranModel lamaran, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            NpwpModel npwpModel = new NpwpModel(fileName, file.getBytes());
            npwpModel.setLamaran(lamaran);
            return npwpDB.save(npwpModel);
        } catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ", Please try again!", ex);
        }
    }
}
