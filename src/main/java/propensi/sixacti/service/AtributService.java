package propensi.sixacti.service;

import propensi.sixacti.model.AtributModel;

import java.util.List;
import java.util.Optional;

public interface AtributService {
    AtributModel changeStatusAtribut (Long id_atribut, AtributModel atributModel);
    List<AtributModel> getListAtribut();
    AtributModel getAtributById(Long id_atribut);
}
