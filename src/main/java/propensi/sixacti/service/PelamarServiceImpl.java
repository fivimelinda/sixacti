package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.repository.UserDB;
import propensi.sixacti.repository.tes.PelamarDb;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional

public class PelamarServiceImpl implements PelamarService {
    @Autowired
    private PelamarDb pelamarDb;

    @Autowired
    private UserDB userDb;

    @Override
    public PelamarModel generatePelamar(String id) {
        PelamarModel baru = new PelamarModel();
        UserModel lama = userDb.findUserModelByNik(id).get();
        baru.setUserPelamar(lama);
        return pelamarDb.save(baru);
    }

    @Override
    public PelamarModel getPelamarByNik(String nik){
        UserModel user = userDb.findUserModelByNik(nik).orElse(null);
        List<PelamarModel> pelamar = pelamarDb.findByUserPelamar(user);
        if(pelamar.size()==0){
            return null;
        }else{
            return pelamar.get(0);
        }
    }


    
}