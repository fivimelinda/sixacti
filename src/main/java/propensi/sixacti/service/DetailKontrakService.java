package propensi.sixacti.service;

import java.util.List;

import propensi.sixacti.model.DetailKontrakModel;
import propensi.sixacti.model.KaryawanModel;
import propensi.sixacti.model.UserModel;

public interface DetailKontrakService {
    DetailKontrakModel getDetailKontrakById(Long id);
    List<DetailKontrakModel> retrieveListDetailKontrak();
    List<String> getDetailKontrakWithName();
    List<String> getDetailKontrakDepartemen();
    DetailKontrakModel ubahStatus(Long id);
    Integer getGaji(Long id);
    UserModel getUser(Long id);
    String getSection(Long id);
}