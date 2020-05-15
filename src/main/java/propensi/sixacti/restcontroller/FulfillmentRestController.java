package propensi.sixacti.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.FulfillmentModel;
import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.service.RequestLowonganService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8081", "http://localhost:8080" })
@RestController
public class FulfillmentRestController {
	@Autowired
    private RequestLowonganService  requestLowonganService;
	
	@GetMapping(value="/api/fulfillment/get")
	private List<FulfillmentModel> retrieveProgres(@RequestParam("reqLokerId") Long reqLokerId){
		try {
			RequestLowonganModel target = requestLowonganService.getRequestLowonganById(reqLokerId);
			return target.getLowonganKerja().getListFulfillment();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	@GetMapping(value="/api/detailReq")
	private HashMap<String, String> detailReqLoker(@RequestParam("reqLokerId") Long reqLokerId){
		try {
			RequestLowonganModel target = requestLowonganService.getRequestLowonganById(reqLokerId);
			HashMap<String, String> response = new HashMap<String, String>();
			response.put("judul", target.getJobTitle());
			response.put("jumlah", Integer.toString(target.getJumlah()));
			return response;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND);
		}
	}
}
