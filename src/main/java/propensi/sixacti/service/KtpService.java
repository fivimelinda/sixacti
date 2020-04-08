package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KtpModel;

public interface KtpService {
    KtpModel storeFile(MultipartFile file);
}
