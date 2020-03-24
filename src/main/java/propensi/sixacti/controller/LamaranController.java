package propensi.sixacti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.service.*;

import java.util.List;

@Controller
@RequestMapping("/lamaran")
public class LamaranController {
    @Qualifier("lamaranServiceImpl")
    @Autowired LamaranService lamaranService;

    public String getLamaran(Model model) {
        List<LamaranModel> listLamaran = lamaranService.getLamaran();
        model.addAttribute("lamaran", listLamaran);

        return "lamaran/form-add-lamaran";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String formAddLamaran(Model model) {
        LamaranModel newLamaran = new LamaranModel();
        List<LamaranModel> docs = lamaranService.getLamaran();
        model.addAttribute("lamaran", docs);
        model.addAttribute("lamaran", newLamaran);
        return "lamaran/form-add-lamaran";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitAddLamaran(@RequestParam ("files") MultipartFile[] files,
            @RequestParam("nik") String nik,
            @ModelAttribute LamaranModel lamaran, Model model) {
        List<LamaranModel> docs = lamaranService.getLamaran();
        System.out.println(nik);
        if (docs!= null){
            for (LamaranModel i : docs){
                if (i.getNik().toLowerCase().equals(nik.toLowerCase())) {
                    model.addAttribute("gagal", true);
                    model.addAttribute("lamaran", docs);
                    return "lamaran/form-add-lamaran";
                }
            }
        }
        for (MultipartFile file: files ) {
            lamaranService.addLamaran(lamaran, file);
        }
        model.addAttribute("docs", docs);
        model.addAttribute("added", true);
        return "lamaran/form-add-lamaran";
    }

//    @GetMapping("/downloadFile/{Id}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long Id){
//        LamaranModel doc = lamaranService.findByIdLamaran(Id);
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(doc.getDocType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
//                .body(new ByteArrayResource(doc.getData()));
//    }
}
