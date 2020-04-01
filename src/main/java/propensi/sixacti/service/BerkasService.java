package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;

public interface BerkasService {
    BerkasModel storeFile(MultipartFile file);
}
