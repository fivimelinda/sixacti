package propensi.sixacti.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import propensi.sixacti.model.UserModel;
import propensi.sixacti.model.Users;

public interface UsersDB extends JpaRepository<Users, Long> {
    Optional<Users> getUsersById(Long id);
    List<Users> findByUser(UserModel user);
}