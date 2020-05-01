package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.repository.PelamarDB;

import java.util.Optional;

@Service
public class PelamarServiceImpl implements PelamarService {

    @Autowired
    PelamarDB pelamarDB;


    @Override
    public PelamarModel getPelamarByUser(UserModel user) {
        Optional<PelamarModel> pelamar = pelamarDB.findPelamarModelByUserPelamar(user);
        if(pelamar.isPresent()){
            return pelamar.get();
        }
        return null;
    }
}
