package propensi.sixacti.service;

import propensi.sixacti.model.AtributModel;
import propensi.sixacti.model.KaryawanModel;

public interface AtributRestService {
    AtributModel buatAtribut(AtributModel atribut);

    AtributModel ubahAtribut(Long idAtribut, AtributModel atribut);

    AtributModel getAtributByIdAtribut(Long idAtribut);

    AtributModel getAtributKaryawan(KaryawanModel karyawan);
}