package propensi.sixacti.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propensi.sixacti.model.DepartemenModel;
import propensi.sixacti.model.SectionModel;
import propensi.sixacti.service.SectAndDeptRestService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SectAndDeptRestController {
    @Autowired
    private SectAndDeptRestService sectAndDeptRestService;

    @GetMapping(value = "/get-section")
    public List<SectionModel> getSection(){
        return sectAndDeptRestService.getAllSection();
    }

    @GetMapping(value = "/get-departemen")
    public List<DepartemenModel> getDepartemen(){
        return sectAndDeptRestService.getAllDepartemen();
    }
}