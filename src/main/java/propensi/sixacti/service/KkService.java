package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.KkModel;
import propensi.sixacti.model.LamaranModel;

public interface KkService {
    KkModel storeFile(LamaranModel lamaran, MultipartFile file);
}
