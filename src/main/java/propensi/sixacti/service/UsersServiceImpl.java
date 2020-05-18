package propensi.sixacti.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.UserModel;
import propensi.sixacti.model.Users;
import propensi.sixacti.repository.UserDB;
import propensi.sixacti.repository.UsersDB;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDB usersDb;

    @Autowired
    private UserDB userDb;

    @Override
    public Users getUsersById(Long id) {
        Optional<Users> user = usersDb.getUsersById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Users setUser(UserModel user, Long id) {
        Users users = getUsersById(id);
        users.setUser(user);
        return usersDb.save(users);
    }

    @Override
    public Users editUser(UserModel user, Long id){
        Users users = getUsersById(id);
        UserModel userNow = users.getUser();
        userNow.setNIK(user.getNIK());
        userNow.setNama(user.getNama());
        userNow.setTanggal_lahir(user.getTanggal_lahir());
        userNow.setJenis_kelamin(user.isJenis_kelamin());
        userNow.setTempat_lahir(user.getTempat_lahir());
        userNow.setAlamat(user.getAlamat());
        userNow.setRT(user.getRT());
        userNow.setRW(user.getRW());
        userNow.setKelurahan(user.getKelurahan());
        userNow.setKecamatan(user.getKecamatan());
        userNow.setKodePos(user.getKode_pos());
        userNow.setTelepon(user.getTelepon());
        userNow.setEmail(user.getEmail());
        userNow.setNPWP(user.getNPWP());
        userDb.save(userNow);
        return usersDb.save(users);
    }
    
}
    
