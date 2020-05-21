package propensi.sixacti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import propensi.sixacti.model.DepartemenModel;
import propensi.sixacti.model.SectionModel;
import propensi.sixacti.repository.DepartemenDb;
import propensi.sixacti.repository.SectionDb;

@Service
@Transactional
public class SectAndDeptServiceImpl implements SectAndDeptRestService {
    @Autowired
    private SectionDb sectionDb;

    @Autowired
    private DepartemenDb departemenDb;

    @Override
    public List<SectionModel> getAllSection(){
        return sectionDb.findAll();
    }

    @Override
    public List<DepartemenModel> getAllDepartemen(){
        return departemenDb.findAll();
    }

}