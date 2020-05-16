package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.ProfileModel;
import propensi.sixacti.repository.ProfileDB;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ProfileDB profileDB;


    @Override
    public ProfileModel getuserByNIK(String nik) {
        Optional<ProfileModel> user = profileDB.findProfileModelByNik(nik);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }
}
