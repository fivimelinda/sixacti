package propensi.sixacti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import propensi.sixacti.model.TesMedisModel;
import propensi.sixacti.service.tes.tesMedis.TesMedisRestService;

import java.util.List;

@Service
@Transactional
public class HasilTesServiceImpl implements HasilTesService {
    @Autowired
    TesMedisRestService tesMedis;

    @Override
    public List<String> hasilTest(Long id_pelamar){
//        TesMedisModel tesMedisModel = tesMedis.getTesMedisByIdPelamar(id_pelamar).get().getStatus();
        return null;
    }

}
