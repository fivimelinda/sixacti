package propensi.sixacti.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import propensi.sixacti.model.DetailKontrakModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.service.DetailKontrakService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @CrossOrigin
    @RequestMapping(value = "/getDepartemen", method = RequestMethod.GET)
    private List<String> getDetailKontrakDepartemen() {
        return detailKontrakService.getDetailKontrakDepartemen();
    }

    @CrossOrigin
    @PutMapping(value = "/changeStatus/{id}")
    private DetailKontrakModel changeStatus(
        @PathVariable("id") Long id
    ){
        return detailKontrakService.ubahStatus(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/gaji/{id}")
    private Integer getGaji(@PathVariable("id") Long id){
        return detailKontrakService.getGaji(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/user/{id}")
    private UserModel getUser(@PathVariable("id") Long id){
        return detailKontrakService.getUser(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/section/{id}")
    private String getSection(@PathVariable("id") Long id){
        return detailKontrakService.getSection(id);
    }

}
