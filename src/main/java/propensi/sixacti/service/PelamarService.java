package propensi.sixacti.service;

import propensi.sixacti.model.PelamarModel;
import propensi.sixacti.model.UserModel;

public interface PelamarService {
    PelamarModel getPelamarByUser(UserModel user);
}
