package propensi.sixacti.service;

import propensi.sixacti.model.PelamarModel;

public interface PelamarService {
    PelamarModel generatePelamar(String id);
    PelamarModel getPelamarByNik(String nik);
}