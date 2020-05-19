package propensi.sixacti.service;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.UserModel;

public interface UserService {
    UserModel getuserByNIK(String nik);
    UserModel addUser(UserModel userModel);
}
