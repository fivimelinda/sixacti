package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KisModel;

public interface KisService {
    KisModel storeFile(MultipartFile file);
}
