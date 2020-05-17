package propensi.sixacti.service;

import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.BerkasModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.model.PelamarModel;

import java.util.List;

public interface LamaranService {
    LamaranModel findByIdLamaran(Long id);
    void addLamaran(LamaranModel lamaran);
    List<LamaranModel> getLamaranByLowonganId (Long idLowongan);
    List<LamaranModel> getLamaran();
    LamaranModel setStatus(Long id, LamaranModel lamaran);
//    LamaranModel getLamaranByPelamar(PelamarModel pelamar);
}
