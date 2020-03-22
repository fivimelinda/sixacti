package propensi.sixacti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.CutiModel;
import propensi.sixacti.repository.CutiDb;

@Service
@Transactional
public class CutiServiceImpl implements CutiService{
	@Autowired
	private CutiDb cutiDb;
	
	@Override
	public void addCuti(CutiModel cuti) {
		cutiDb.save(cuti);
	}
}
