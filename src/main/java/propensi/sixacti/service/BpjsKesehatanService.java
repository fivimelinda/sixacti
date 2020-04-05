package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKesehatanModel;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;

public interface BpjsKesehatanService {
    BpjsKesehatanModel storeFile(MultipartFile file);
}
