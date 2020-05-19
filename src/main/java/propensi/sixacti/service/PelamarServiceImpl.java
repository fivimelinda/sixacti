package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.repository.UserDB;
import propensi.sixacti.repository.tes.PelamarDb;

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
    
}