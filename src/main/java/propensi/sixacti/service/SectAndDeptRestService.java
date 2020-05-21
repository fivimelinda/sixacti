package propensi.sixacti.service;

import java.util.List;

import propensi.sixacti.model.DepartemenModel;
import propensi.sixacti.model.SectionModel;

public interface SectAndDeptRestService {
    List<SectionModel> getAllSection();
    List<DepartemenModel> getAllDepartemen();
}