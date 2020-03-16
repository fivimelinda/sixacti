package propensi.sixacti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.service.LowonganKerjaService;

import java.util.List;

@Controller
@RequestMapping("/loker")
public class LowonganKerjaController {

    @Autowired
    LowonganKerjaService lowonganKerjaService;

    @RequestMapping(value = "/list-loker")
    public String viewAllLoker(Model model){
        List<LowonganKerjaModel> lokerList = lowonganKerjaService.getListLowonganKerja();
        model.addAttribute("daftarSemuaLoker", lokerList);
        return "view-all-loker";
    }

    @RequestMapping(value = "/tambah-loker", method = RequestMethod.GET)
    public String tambahLoker(Model model){
        LowonganKerjaModel newLoker =  new LowonganKerjaModel();
        model.addAttribute("loker", newLoker);

        return "form-add-loker";
    }

    @RequestMapping(value = "/tambah-loker", method = RequestMethod.POST)
    public String tambahLokerSubmit(@ModelAttribute LowonganKerjaModel loker, Model model){
        lowonganKerjaService.addLowonganKerja(loker);
        model.addAttribute("deskripsi", loker.getDeskripsi());

        return "tambah-loker";
    }
}
