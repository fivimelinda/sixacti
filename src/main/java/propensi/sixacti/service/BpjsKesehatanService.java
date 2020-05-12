package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKesehatanModel;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.LamaranModel;

public interface BpjsKesehatanService {
    BpjsKesehatanModel storeFile(LamaranModel lamaran, MultipartFile file);
    BpjsKesehatanModel getFileByName(String fileName);
}
