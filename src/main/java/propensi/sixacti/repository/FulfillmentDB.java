package propensi.sixacti.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import propensi.sixacti.model.FulfillmentModel;
import propensi.sixacti.model.LowonganKerjaModel;

@Repository
public interface FulfillmentDB extends JpaRepository<FulfillmentModel, Long>{
	Optional<FulfillmentModel> findByLokerAndTanggalDiterima(LowonganKerjaModel loker, Date currdate);
	List<FulfillmentModel> findByLokerOrderByTanggalDiterimaDesc(LowonganKerjaModel loker);
}
