package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KkModel;

public interface KkService {
    KkModel storeFile(MultipartFile file);
}
