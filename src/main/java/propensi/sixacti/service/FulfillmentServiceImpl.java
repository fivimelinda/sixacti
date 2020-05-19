package propensi.sixacti.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.FulfillmentModel;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.repository.FulfillmentDB;

@Service
@Transactional
public class FulfillmentServiceImpl implements FulfillmentService{
	@Autowired
	FulfillmentDB fulfilDb;
	
	@Override
	public void add(FulfillmentModel target) {
		fulfilDb.save(target);
	}
	
	@Override
	public FulfillmentModel getFulfillmentByLokerAndTanggal(LowonganKerjaModel loker, Date currdate){
		Optional<FulfillmentModel> progres = fulfilDb.findByLokerAndTanggalDiterima(loker, currdate);
		if (progres.isPresent()) {
			return progres.get();
		}
		return null;
	}
	
	@Override
	public List<FulfillmentModel> getFulfillmentByLoker(LowonganKerjaModel loker){
		return fulfilDb.findByLokerOrderByTanggalDiterimaDesc(loker);
	}
	
}
