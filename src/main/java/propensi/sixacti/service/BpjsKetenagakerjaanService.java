package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;

public interface BpjsKetenagakerjaanService {
    BpjsKetenagakerjaanModel storeFile(MultipartFile file);
}
