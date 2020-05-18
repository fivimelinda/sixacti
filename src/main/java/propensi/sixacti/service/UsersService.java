package propensi.sixacti.service;

import propensi.sixacti.model.UserModel;
import propensi.sixacti.model.Users;

public interface UsersService {
    Users getUsersById(Long id);
    Users setUser(UserModel user, Long id);
    Users editUser(UserModel user, Long id);
}