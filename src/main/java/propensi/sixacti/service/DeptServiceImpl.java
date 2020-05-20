package propensi.sixacti.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.DepartemenModel;
import propensi.sixacti.model.FulfillmentModel;
import propensi.sixacti.repository.DeptDb;

@Service
@Transactional
public class DeptServiceImpl implements DeptService{
	@Autowired
	DeptDb deptDb;
	
	@Override
	public DepartemenModel getDeptById(Long id) {
		Optional<DepartemenModel> dept = deptDb.findById(id);
		if (dept.isPresent()) {
			return dept.get();
		}
		return null;
	}

}
