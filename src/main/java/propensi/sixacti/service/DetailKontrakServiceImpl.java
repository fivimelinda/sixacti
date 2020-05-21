package propensi.sixacti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.DetailKontrakModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.Roles;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.model.Users;
import propensi.sixacti.repository.DetailKontrakDB;
import propensi.sixacti.repository.KaryawanDB;
import propensi.sixacti.repository.UsersDB;

@Service
@Transactional
public class DetailKontrakServiceImpl implements DetailKontrakService {

    @Autowired
    private DetailKontrakDB detailKontrakDb;

    @Autowired
    private KaryawanDB karyawanDb;

    @Autowired
    private UsersDB usersDb;


    @Override
    public DetailKontrakModel getDetailKontrakById(Long id) {
        Optional <DetailKontrakModel> kontrak = detailKontrakDb.getDetailKontrakByNoSurat(id);
        if (kontrak.isPresent()) {
            return kontrak.get();
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<DetailKontrakModel> retrieveListDetailKontrak() {
       return detailKontrakDb.findAll();
    }

    @Override
    public List<String> getDetailKontrakWithName(){
        List <String> all = new ArrayList<>();
        List<DetailKontrakModel> detailKontrakAll = detailKontrakDb.findAll();
        for (DetailKontrakModel d : detailKontrakAll) {
            String b = d.getKaryawan().getUser().getNama();
            all.add(b);
        }
        return all;
    }

    @Override
    public List<String> getDetailKontrakDepartemen() {
        List <String> all = new ArrayList<>();
        List<DetailKontrakModel> detailKontrakAll = detailKontrakDb.findAll();
        for (DetailKontrakModel d : detailKontrakAll) {
            String b = d.getKaryawan().getDepartemen().getNamaDepartemen();
            all.add(b);
        }
        return all;
    }

    @Override
    public DetailKontrakModel ubahStatus(Long id) {
        DetailKontrakModel kontrak = getDetailKontrakById(id);
        kontrak.setStatus(true);
        return detailKontrakDb.save(kontrak);
    }

    @Override
    public Integer getGaji(Long id) {
        return getDetailKontrakById(id).getKaryawan().getGaji();
        
    }

    @Override
    public UserModel getUser(Long id) {
        return getDetailKontrakById(id).getKaryawan().getUser();
    }

    @Override
    public String getSection(Long id){
        return getDetailKontrakById(id).getKaryawan().getSection().getNamaSection();
    }

    @Override
    public List<Users> getKaryawanNoDetailKontrak() {
        List<KaryawanModel> semua = karyawanDb.findAll();
        List<Users> filter = new ArrayList<>();
        for(KaryawanModel a: semua){
            if(a.getDetailKontrakModel() == null){
                // System.out.println(a.getUser().getUsers());
                Set<Roles> b = a.getUser().getUsers().getRoles();
                for(Roles c : b){
                    if(c.getRoleName().toString().equals("ROLE_KARYAWANKONTRAK")){
                        filter.add(a.getUser().getUsers());
                    }
                }
                
            }
        }
       
        return filter;
    }

    @Override
    public DetailKontrakModel addDetailKontrak(DetailKontrakModel detailKontrak, Long id) {
        detailKontrak.setStatus(false);
        KaryawanModel karyawan = usersDb.getUsersById(id).get().getUser().getKaryawan();
        detailKontrak.setKaryawan(karyawan);
        DetailKontrakModel simpan = detailKontrakDb.save(detailKontrak);
        karyawan.setDetailKontrakModel(simpan);
        return simpan;
    }

}