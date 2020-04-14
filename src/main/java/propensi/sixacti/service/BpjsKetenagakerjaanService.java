package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BpjsKetenagakerjaanModel;
import propensi.sixacti.model.LamaranModel;

public interface BpjsKetenagakerjaanService {
    BpjsKetenagakerjaanModel storeFile(LamaranModel lamaran, MultipartFile file);
}
