package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.NpwpModel;

public interface NpwpService {
    NpwpModel storeFile(MultipartFile file);
}