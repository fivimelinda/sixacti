package propensi.sixacti.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import propensi.sixacti.model.DetailKontrakModel;
import propensi.sixacti.service.DetailKontrakService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/detailKontrak")


public class DetailKontrakRestController {
    @Autowired
    private DetailKontrakService detailKontrakService;

    @CrossOrigin
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    private List<DetailKontrakModel> retrieveListDetailKontrak() {
        return detailKontrakService.retrieveListDetailKontrak();
    }

    @CrossOrigin
    @RequestMapping(value = "/get/{id}")
    private DetailKontrakModel getDetailKontrakById(@PathVariable("id") Long id){
        return detailKontrakService.getDetailKontrakById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    private List<String> getDetailKontrakName() {
        return detailKontrakService.getDetailKontrakWithName();
    }
}