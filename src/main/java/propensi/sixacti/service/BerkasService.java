package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.LamaranModel;

public interface BerkasService {
    BerkasModel storeFile(LamaranModel lamaran, MultipartFile file);
    BerkasModel getFileByName(String fileName);
}
