package propensi.sixacti.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.KategoriCutiModel;
import propensi.sixacti.repository.KategoriCutiDb;

@Service
@Transactional
public class KategoriCutiServiceImpl implements KategoriCutiService{
	@Autowired
	KategoriCutiDb kategoriCutiDb;
	
	public Optional<KategoriCutiModel> getKategoriById(Integer id) {
		return kategoriCutiDb.findById(id);
	}
}
