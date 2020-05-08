package propensi.sixacti.service;

import java.util.List;
import java.util.Optional;

import propensi.sixacti.model.KategoriCutiModel;

public interface KategoriCutiService {
	Optional<KategoriCutiModel> getKategoriById(Integer id);
	List<KategoriCutiModel> retrieveListKategori();
}
