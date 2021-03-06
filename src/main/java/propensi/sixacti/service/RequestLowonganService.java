package propensi.sixacti.service;

import java.util.List;

import propensi.sixacti.model.RequestLowonganModel;

public interface RequestLowonganService {
    RequestLowonganModel getRequestLowonganById(Long id);
    List<RequestLowonganModel> retrieveListRequestLowongan();
    RequestLowonganModel addRequestLowongan(RequestLowonganModel requestLowongan);
    void deleteRequestLowonganById(Long id);
    RequestLowonganModel tolakRequest(Long id);
}