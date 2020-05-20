package propensi.sixacti.service;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.SectionModel;
import propensi.sixacti.repository.SectionDb;

@Service
@Transactional
public class SectionServiceImpl implements SectionService{
	@Autowired
	SectionDb sectionDb;
	
	@Override
	public SectionModel getSectionById(Long id) {
		Optional<SectionModel> sect = sectionDb.findById(id);
		if (sect.isPresent()) {
			return sect.get();
		}
		return null;
	}

}
