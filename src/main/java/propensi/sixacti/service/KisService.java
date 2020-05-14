package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KisModel;
import propensi.sixacti.model.LamaranModel;

public interface KisService {
    KisModel storeFile(LamaranModel lamaran, MultipartFile file);
    KisModel getFileByName(String fileName);
}
