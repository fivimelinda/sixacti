package propensi.sixacti.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.service.LowonganKerjaService;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8080" })
@RestController
@RequestMapping("/api")
public class LowonganKerjaRestController {

    @Autowired
    private LowonganKerjaService lowonganKerjaService;

    @GetMapping(value = "/listLoker")
    private List<LowonganKerjaModel> retrieveListLoker(){
        return lowonganKerjaService.getListLowonganKerja();
    }
}
