package propensi.sixacti.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import propensi.sixacti.model.RequestLowonganModel;
import propensi.sixacti.repository.RequestLowonganDB;

@Service
@Transactional
public class RequestLowonganServiceImpl implements RequestLowonganService {
    @Autowired
    private RequestLowonganDB requestLowonganDb;

    @Override
    public RequestLowonganModel getRequestLowonganById(Long id) {
        Optional<RequestLowonganModel> Request = requestLowonganDb.getRequestLowonganById(id);
        if (Request.isPresent()) {
            return Request.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<RequestLowonganModel> retrieveListRequestLowongan() {
        return requestLowonganDb.findAll();
    }

    @Override
    public RequestLowonganModel addRequestLowongan(RequestLowonganModel requestLowongan) {
        return requestLowonganDb.save(requestLowongan);
    }
    
    
}