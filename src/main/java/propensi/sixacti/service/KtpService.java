package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KtpModel;
import propensi.sixacti.model.LamaranModel;

public interface KtpService {
    KtpModel storeFile(LamaranModel lamaran, MultipartFile file);
}
