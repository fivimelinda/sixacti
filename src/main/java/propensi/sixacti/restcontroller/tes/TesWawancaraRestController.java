package propensi.sixacti.restcontroller.tes;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import propensi.sixacti.model.ERole;
import propensi.sixacti.model.FulfillmentModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.LamaranModel;
import propensi.sixacti.model.LowonganKerjaModel;
import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.Roles;
import propensi.sixacti.model.TesWawancaraModel;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.model.Users;
import propensi.sixacti.repository.UserDB;
import propensi.sixacti.repository.UsersDB;
import propensi.sixacti.repository.Login.RolesRepository;
import propensi.sixacti.service.FulfillmentService;
import propensi.sixacti.service.KaryawanService;
import propensi.sixacti.service.LamaranService;
import propensi.sixacti.service.UserService;
import propensi.sixacti.service.tes.PelamarRestService;
import propensi.sixacti.service.tes.tesWawancara.TesWawancaraRestService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/tes")
public class TesWawancaraRestController {

    @Autowired
    private TesWawancaraRestService tesWawancaraRestService;

    @Autowired
    private PelamarRestService pelamarRestService;

    @Autowired
    private LamaranService lamaranService;
    
    @Autowired
    private FulfillmentService fulfillmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDB userDb;

    @Autowired
    private UsersDB usersDb;

    @Autowired
    RolesRepository roleRepository;
    
    @Autowired
    KaryawanService karyawanService;

    //tambah tes wawancara
    @PostMapping(value = "/wawancara/{idPelamar}")
    public TesWawancaraModel tambahTesWawancara(
        @Valid @RequestBody TesWawancaraModel tesWawancara,
        @PathVariable (value = "idPelamar") Long idPelamar,
        BindingResult bindingResult
    ){
        //TODO: process POST request
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            pelamar.setTesWawancara(tesWawancara);
            tesWawancara.setPelamarTesWawancara(pelamar);
            return tesWawancaraRestService.buatTesWawancara(tesWawancara);
        }
    }

    @GetMapping(value = "/wawancara/pelamar/{idPelamar}")
    public TesWawancaraModel getTesWawancaraByPelamar(
        @PathVariable (value = "idPelamar") Long idPelamar
    ){
        try{
            PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(idPelamar);
            return tesWawancaraRestService.getTesWawancaraByPelamar(pelamar);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tes Wawancara Not Found"
            );
        }
    }

    @GetMapping(value = "/wawancara/get/{idTesWawancara}")
    public TesWawancaraModel getTesWawancara(
        @PathVariable (value = "idTesWawancara") Long idTesWawancara
    ){
        try{
            return tesWawancaraRestService.getTesWawancaraByIdTesWawancara(idTesWawancara);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Tes Wawancara " + String.valueOf(idTesWawancara+ " Not Found"
            ));
        }
    }

    //ubah tes wawancara
    @PutMapping(value = "/wawancara/update/{idTesWawancara}")
    public TesWawancaraModel ubahTesWawancara(
        @PathVariable (value = "idTesWawancara") Long idTesWawancara,
        @RequestBody TesWawancaraModel tesWawancara
    ){
        try{

             if (tesWawancara.getIsLolos()){
            	 TesWawancaraModel wawancara = tesWawancaraRestService.getTesWawancaraByIdTesWawancara(idTesWawancara);
                 PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(wawancara.getPelamarTesWawancara().getIdPelamar());
                 LamaranModel lamaran = lamaranService.findByIdLamaran(pelamar.getLamaran().getId());
                 lamaran.setLolos(true);
                 lamaran.setStatusLamaran("Diterima");
                 LowonganKerjaModel loker = lamaran.getLowongan();
                 boolean gender = pelamar.getUserPelamar().isJenis_kelamin();
                 Date currentDate = new Date();
                 FulfillmentModel target = fulfillmentService.getFulfillmentByLokerAndTanggal(loker, currentDate);
                 if (target!=null) {
                 	if(gender) {
                 		target.setJumlahLakilaki(target.getJumlahLakilaki()+1);
                 	} else {
                 		target.setJumlahPerempuan(target.getJumlahPerempuan()+1);
                 	}
                 } else {
                 	target = new FulfillmentModel();
                 	target.setLoker(loker);
                 	target.setTanggalDiterima(currentDate);
                 	if(gender) {
                 		target.setJumlahLakilaki(1);
                 		target.setJumlahPerempuan(0);
                 	} else {
                 		target.setJumlahPerempuan(1);
                 		target.setJumlahLakilaki(0);
                 	}
                 	loker.getListFulfillment().add(target);
                 }
                 fulfillmentService.add(target);
             }

            // if(tesWawancara.getIsLolos()){
            //     PelamarModel pelamar = pelamarRestService.getPelamarByIdPelamar(tesWawancara.getPelamarTesWawancara().getIdPelamar());
            //     UserModel user = userDb.findByPelamar(pelamar).get(0);
            //     KaryawanModel karyawan = new KaryawanModel();
            //     karyawan.setUser(user);
            //     karyawan.setGaji(1000000);
            //     karyawan.setDepartemen(null);
            //     karyawan.setSection(null);
            //     karyawanService.buatKaryawan(karyawan);
            //     Users users = usersDb.findByUser(user).get(0);
            //     Set<Roles> roles = new HashSet<>();
            //     Roles kontrakRole = roleRepository.findByRoleName(ERole.ROLE_KARYAWANKONTRAK).orElse(null);
            //     roles.add(kontrakRole);
            //     users.setRoles(roles);               
            // }
            

            return tesWawancaraRestService.ubahTesWawancara(idTesWawancara, tesWawancara);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Tes Wawancara " + String.valueOf(idTesWawancara+ " Not Found"
            ));
        }
    }
}
