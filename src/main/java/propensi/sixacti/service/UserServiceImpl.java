package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.repository.UserDB;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDB userDB;


//    @Override
//    public UserModel getuserByNIK(String nik) {
//        Optional<UserModel> user = userDB.findUserModelByNik(nik);
//        if(user.isPresent()){
//            return user.get();
//        }
//        return null;
//    }
}
