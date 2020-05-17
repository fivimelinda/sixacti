package propensi.sixacti.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.Users;
import propensi.sixacti.repository.UsersDB;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDB usersDb;

    @Override
    public Users getUsersById(Long id) {
        Optional<Users> user = usersDb.getUsersById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new NoSuchElementException();
        }
    }
    
}
    
