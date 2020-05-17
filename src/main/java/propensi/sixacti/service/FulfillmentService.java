package propensi.sixacti.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import propensi.sixacti.model.FulfillmentModel;
import propensi.sixacti.model.LowonganKerjaModel;

public interface FulfillmentService {
	void add(FulfillmentModel target);
	FulfillmentModel getFulfillmentByLokerAndTanggal(LowonganKerjaModel loker, Date currdate);
	List<FulfillmentModel> getFulfillmentByLoker(LowonganKerjaModel loker);
}
