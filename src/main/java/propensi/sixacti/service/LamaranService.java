package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.LamaranModel;

import java.util.List;

public interface LamaranService {
    LamaranModel findByIdLamaran(Long id);
    void addLamaran(LamaranModel lamaran, MultipartFile file);
    List<LamaranModel> getLamaran();
}
